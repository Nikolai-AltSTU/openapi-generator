/**
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.api;

import org.openapitools.client.model.Client;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



/**
 * OpenAPI Petstore Test
 *
 * API tests for FakeClassnameTags123Api 
 */
public class FakeClassnameTags123ApiTest {

    private FakeClassnameTags123Api client;
    private String baseUrl = "http://localhost:9080";
    
    @Before
    public void setup() throws MalformedURLException {
        client = RestClientBuilder.newBuilder()
                        .baseUrl(new URL(baseUrl))
                        .register(ApiException.class)
                        .build(FakeClassnameTags123Api.class);
    }

    
    /**
     * To test class name in snake case
     *
     * To test class name in snake case
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void testClassnameTest() {
        // TODO: test validations
        Client client = null;
        //Client response = api.testClassname(client);
        //assertNotNull(response);
        
        
    }
    
}
