package com.example.unittesting;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

    String actualResponse =
            "{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}";
    @Test
    public void jsonAssert_StrictTrue_ExceptForSpaces() throws JSONException {
        String expectedResponse = "{\"id\":  1,  \"name\":\"Ball\",\"price\":  10,\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, true);
    }

    @Test
    public void jsonAssert_StrictFalse() throws JSONException {
        String expectedResponse = "{\"quantity\":100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }

    @Test
    public void jsonAssert_StrictFalse_WithoutEscapeCharacters() throws JSONException {
        String expectedResponse = "{id:1,name:Ball,price:10,quantity:100}";
        JSONAssert.assertEquals(expectedResponse, actualResponse, false);
    }
}
