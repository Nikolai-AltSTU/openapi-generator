/*
 * Copyright 2019 OpenAPI-Generator Contributors (https://openapi-generator.tech)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openapitools.codegen.templating;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import org.openapitools.codegen.api.TemplatingEngineAdapter;
import org.openapitools.codegen.api.TemplatingExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Map;


public class MustacheEngineAdapter implements TemplatingEngineAdapter {

    private final Logger LOGGER = LoggerFactory.getLogger(TemplatingEngineAdapter.class);

    /**
     * Provides an identifier used to load the adapter. This could be a name, uuid, or any other string.
     *
     * @return A string identifier.
     */
    @Override
    public String getIdentifier() {
        return "mustache";
    }

    private final String[] extensions = new String[]{"mustache"};
    Mustache.Compiler compiler = Mustache.compiler();

    /**
     * Compiles a template into a string
     *
     * @param executor    From where we can fetch the templates content (e.g. an instance of DefaultGenerator)
     * @param bundle       The map of values to pass to the template
     * @param templateFile The name of the template (e.g. model.mustache )
     * @return the processed template result
     * @throws IOException an error ocurred in the template processing
     */
    @Override
    public String compileTemplate(TemplatingExecutor executor, Map<String, Object> bundle, String templateFile) throws IOException {

        String content = executor.getFullTemplateContents(templateFile);
        if(templateFile.contains("pom"))
        {
            for (String key: bundle.keySet()) {
                if(key.contains("-version")){
                    if (content.indexOf("<properties>") > content.indexOf("<" + key + ">") || content.indexOf("<" + key + ">") > content.indexOf("</properties>")){
                        LOGGER.warn("The library {} isn't used in template file {}", key.replaceFirst("-version", ""), templateFile);
                    }
                    else {
                        content = content.replaceFirst( String.format("<%s>(.*)</%s>", key, key), String.format("<%s>{{%s}}</%s>", key, key, key) );
                    }

                }
            }
            String[] ignoredInPomList = new String[]{"licenses", "developers", "parent"};
            for (String s : ignoredInPomList) {
                if (bundle.containsKey(s) && bundle.get(s).toString().contains("false")) {
                    content = content.replaceFirst(String.format("<%s>([^.$]*)</%s>\n", s, s), "");
                }
            }
        }

        Template tmpl = compiler
                .withLoader(name -> findTemplate(executor, name))
                .defaultValue("")
                .compile(content);

        return tmpl.execute(bundle);
    }

    @SuppressWarnings({"java:S108"}) // catch-all is expected, and is later thrown
    public Reader findTemplate(TemplatingExecutor generator, String name) {
        for (String extension : extensions) {
            final String templateName = name + "." + extension;
            try {
                return new StringReader(generator.getFullTemplateContents(templateName));
            } catch (Exception exception) {
                LOGGER.error("Failed to read full template {}, {}", templateName, exception.getMessage());
            }
        }

        throw new TemplateNotFoundException(name);
    }

    public Mustache.Compiler getCompiler() {
        return compiler;
    }

    public void setCompiler(Mustache.Compiler compiler) {
        this.compiler = compiler;
    }

    @Override
    public String[] getFileExtensions() {
        return extensions;
    }
}
