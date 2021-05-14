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

import java.math.BigDecimal;
import org.openapitools.client.model.Client;
import java.util.Date;
import java.io.File;
import org.openapitools.client.model.FileSchemaTestClass;
import org.openapitools.client.model.HealthCheckResult;
import org.openapitools.client.model.OuterComposite;
import org.openapitools.client.model.OuterObjectWithEnumProperty;
import org.openapitools.client.model.Pet;
import org.openapitools.client.model.User;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * OpenAPI Petstore
 *
 * <p>This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 */

@RegisterRestClient
@RegisterProvider(ApiExceptionMapper.class)
@Path("/fake")
public interface FakeApi  {

    /**
     * Health check endpoint
     *
     */
    @GET
    @Path("/health")
    @Produces({ "application/json" })
    public HealthCheckResult fakeHealthGet() throws ApiException, ProcessingException;

    /**
     * test http signature authentication
     *
     */
    @GET
    @Path("/http-signature-test")
    @Consumes({ "application/json", "application/xml" })
    public void fakeHttpSignatureTest(Pet pet, @QueryParam("query_1") String query1, @HeaderParam("header_1")  String header1) throws ApiException, ProcessingException;

    @POST
    @Path("/outer/boolean")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    public Boolean fakeOuterBooleanSerialize(Boolean body) throws ApiException, ProcessingException;

    @POST
    @Path("/outer/composite")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    public OuterComposite fakeOuterCompositeSerialize(OuterComposite outerComposite) throws ApiException, ProcessingException;

    @POST
    @Path("/outer/number")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    public BigDecimal fakeOuterNumberSerialize(BigDecimal body) throws ApiException, ProcessingException;

    @POST
    @Path("/outer/string")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    public String fakeOuterStringSerialize(String body) throws ApiException, ProcessingException;

    @POST
    @Path("/property/enum-int")
    @Consumes({ "application/json" })
    @Produces({ "*/*" })
    public OuterObjectWithEnumProperty fakePropertyEnumIntegerSerialize(OuterObjectWithEnumProperty outerObjectWithEnumProperty) throws ApiException, ProcessingException;

    @PUT
    @Path("/body-with-file-schema")
    @Consumes({ "application/json" })
    public void testBodyWithFileSchema(FileSchemaTestClass fileSchemaTestClass) throws ApiException, ProcessingException;

    @PUT
    @Path("/body-with-query-params")
    @Consumes({ "application/json" })
    public void testBodyWithQueryParams(@QueryParam("query") String query, User user) throws ApiException, ProcessingException;

    /**
     * To test \&quot;client\&quot; model
     *
     * To test \&quot;client\&quot; model
     *
     */
    @PATCH
    
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Client testClientModel(Client client) throws ApiException, ProcessingException;

    /**
     * Fake endpoint for testing various parameters 假端點 偽のエンドポイント 가짜 엔드 포인트 
     *
     * Fake endpoint for testing various parameters 假端點 偽のエンドポイント 가짜 엔드 포인트 
     *
     */
    @POST
    
    @Consumes({ "application/x-www-form-urlencoded" })
    public void testEndpointParameters(@Multipart(value = "number")  BigDecimal number, @Multipart(value = "double")  Double _double, @Multipart(value = "pattern_without_delimiter")  String patternWithoutDelimiter, @Multipart(value = "byte")  byte[] _byte, @Multipart(value = "integer", required = false)  Integer integer, @Multipart(value = "int32", required = false)  Integer int32, @Multipart(value = "int64", required = false)  Long int64, @Multipart(value = "float", required = false)  Float _float, @Multipart(value = "string", required = false)  String string,  @Multipart(value = "binary" , required = false) Attachment binaryDetail, @Multipart(value = "date", required = false)  Date date, @Multipart(value = "dateTime", required = false)  Date dateTime, @Multipart(value = "password", required = false)  String password, @Multipart(value = "callback", required = false)  String paramCallback) throws ApiException, ProcessingException;

    /**
     * To test enum parameters
     *
     * To test enum parameters
     *
     */
    @GET
    
    @Consumes({ "application/x-www-form-urlencoded" })
    public void testEnumParameters(@HeaderParam("enum_header_string_array")  List<String> enumHeaderStringArray, @HeaderParam("enum_header_string")  String enumHeaderString, @QueryParam("enum_query_string_array") List<String> enumQueryStringArray, @QueryParam("enum_query_string") @DefaultValue("-efg") String enumQueryString, @QueryParam("enum_query_integer") Integer enumQueryInteger, @QueryParam("enum_query_double") Double enumQueryDouble, @Multipart(value = "enum_form_string_array", required = false)  List<String> enumFormStringArray, @Multipart(value = "enum_form_string", required = false)  String enumFormString) throws ApiException, ProcessingException;

    /**
     * Fake endpoint to test group parameters (optional)
     *
     * Fake endpoint to test group parameters (optional)
     *
     */
    @DELETE
    
    public void testGroupParameters(@QueryParam("required_string_group") Integer requiredStringGroup, @HeaderParam("required_boolean_group")  Boolean requiredBooleanGroup, @QueryParam("required_int64_group") Long requiredInt64Group, @QueryParam("string_group") Integer stringGroup, @HeaderParam("boolean_group")  Boolean booleanGroup, @QueryParam("int64_group") Long int64Group) throws ApiException, ProcessingException;

    /**
     * test inline additionalProperties
     *
     */
    @POST
    @Path("/inline-additionalProperties")
    @Consumes({ "application/json" })
    public void testInlineAdditionalProperties(Map<String, String> requestBody) throws ApiException, ProcessingException;

    /**
     * test json serialization of form data
     *
     */
    @GET
    @Path("/jsonFormData")
    @Consumes({ "application/x-www-form-urlencoded" })
    public void testJsonFormData(@Multipart(value = "param")  String param, @Multipart(value = "param2")  String param2) throws ApiException, ProcessingException;

    @PUT
    @Path("/test-query-paramters")
    public void testQueryParameterCollectionFormat(@QueryParam("pipe") List<String> pipe, @QueryParam("ioutil") List<String> ioutil, @QueryParam("http") List<String> http, @QueryParam("url") List<String> url, @QueryParam("context") List<String> context) throws ApiException, ProcessingException;
}

