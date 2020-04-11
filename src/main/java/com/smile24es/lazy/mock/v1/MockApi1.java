package com.smile24es.lazy.mock.v1;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockApi1 {

    private static final String RESPONSE_1 = "{\n" +
          "  \"accountId\": 1,\n" +
          "  \"accountName\": \"Smile24\",\n" +
          "  \"isActive\": true,\n" +
          "  \"monthlyCharge\": 10.75,\n" +
          "  \"phone\": {\n" +
          "    \"number\": \"12345678\"\n" +
          "  },\n" +
          "  \"settings\": [\n" +
          "    {\n" +
          "      \"id\": 840,\n" +
          "      \"key\": \"payment.period\",\n" +
          "      \"value\": \"monthly\",\n" +
          "      \"isActive\": true,\n" +
          "      \"chargeForFeature\": 11.9\n" +
          "    },\n" +
          "    {\n" +
          "      \"id\": 841,\n" +
          "      \"key\": \"payment.method\",\n" +
          "      \"value\": \"direct\",\n" +
          "      \"isActive\": true,\n" +
          "      \"chargeForFeature\": 12.86,\n" +
          "      \"supportedMethods\": [\n" +
          "        {\n" +
          "          \"type\": \"Card\",\n" +
          "          \"minValue\": 1\n" +
          "        },\n" +
          "        {\n" +
          "          \"type\": \"Cash\",\n" +
          "          \"allowed\": [\n" +
          "            \"SLR\",\n" +
          "            \"USD\"\n" +
          "          ]\n" +
          "        }\n" +
          "      ]\n" +
          "    }\n" +
          "  ]\n" +
          "}";
    private static final String ERROR_RESPONSE = "{\n" +
          " \"error\": {\n" +
          "  \"errors\": [\n" +
          "   {\n" +
          "    \"domain\": \"global\",\n" +
          "    \"reason\": \"invalidParameter\",\n" +
          "    \"message\": \"Invalid string value: 'asdf'. Allowed values: [STUDENT]\",\n" +
          "    \"locationType\": \"parameter\",\n" +
          "    \"location\": \"chart\"\n" +
          "   }\n" +
          "  ],\n" +
          "  \"code\": 400,\n" +
          "  \"message\": \"Invalid string value: 'asdf'. Allowed values: [STUDENTS]\"\n" +
          " }\n" +
          "}";
    public static final String RESPONSE_2 = "{\n" +
          "  \"studentId\": 1,\n" +
          "  \"studentName\": \"Jone Doe\",\n" +
          "  \"isActive\": true,\n" +
          "  \"weight\": 60.75,\n" +
          "  \"phone\": {\n" +
          "    \"number\": \"12345678\"\n" +
          "  },\n" +
          "  \"settings\": [\n" +
          "    {\n" +
          "      \"id\": 840,\n" +
          "      \"key\": \"school.fee.payment.period\",\n" +
          "      \"value\": \"monthly\",\n" +
          "      \"isActive\": true,\n" +
          "      \"amount\": 10\n" +
          "    },\n" +
          "    {\n" +
          "      \"id\": 841,\n" +
          "      \"key\": \"sport.club.payment.period\",\n" +
          "      \"value\": \"annualy\",\n" +
          "      \"isActive\": false,\n" +
          "      \"amount\": 20.85,\n" +
          "      \"paymentMethods\": [\n" +
          "        {\n" +
          "          \"type\": \"Card\",\n" +
          "          \"minValue\": 10\n" +
          "        },\n" +
          "        {\n" +
          "          \"type\": \"Cash\",\n" +
          "          \"allowd\": [\n" +
          "            \"SLR\",\n" +
          "            \"USD\"\n" +
          "          ]\n" +
          "        }\n" +
          "      ]\n" +
          "    }\n" +
          "  ]\n" +
          "}";

    @GetMapping(value = "lazy-mock-api/v1/ping")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String ping() {
        return Long.toString(System.currentTimeMillis());
    }

    @PostMapping(value = "lazy-mock-api/v1/mock")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String mockApiResponse() {
        return RESPONSE_1;
    }

    @PostMapping(value = "lazy-mock-api/v1/accounts")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public String createJsonResponse(@RequestBody Object anyObject) {
        return RESPONSE_2;
    }

    @GetMapping(value = "lazy-mock-api/v1/accounts/1")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String getJsonResponse() {
        return RESPONSE_2;
    }

    @GetMapping(value = "lazy-mock-api/v1/accounts/2")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String getErrorResponse() {
        return ERROR_RESPONSE;
    }





}
