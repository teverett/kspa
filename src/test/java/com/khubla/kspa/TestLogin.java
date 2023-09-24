package com.khubla.kspa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.SpaControlApi;
import org.openapitools.client.model.V2Spa200Response;

/**
 * @author Tom Everett
 */
public class TestLogin {
   private static final String API_KEY = "abc123";
   private static final String BASE_URL = "https://api.myarcticspa.com";

   @Disabled("Needs test API key")
   @Test()
   void testlogin() {
      try {
         /*
          * authenticate
          */
         ApiClient apiClient = new ApiClient();
         apiClient.setApiKey(API_KEY);
         /*
          * api
          */
         SpaControlApi spaControlApi = new SpaControlApi(apiClient);
         spaControlApi.setCustomBaseUrl(BASE_URL);
         /*
          * get status
          */
         V2Spa200Response v2Spa200Response = spaControlApi.v2Spa();
         assertNotNull(v2Spa200Response);
      } catch (Exception e) {
         e.printStackTrace();
         fail();
      }
   }
}
