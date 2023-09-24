package com.khubla.kspa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.openapitools.client.ApiClient;
import org.openapitools.client.api.SpaControlApi;
import org.openapitools.client.model.V2Spa200Response;

/**
 * @author Tom Everett
 */
public class TestLogin extends BaseTest {
   private static final String BASE_URL = "https://api.myarcticspa.com";

   @Test()
   void testlogin() {
      try {
         /*
          * authenticate
          */
         if (null != apikey) {
            ApiClient apiClient = new ApiClient();
            apiClient.setApiKey(this.apikey);
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
         }
      } catch (Exception e) {
         e.printStackTrace();
         fail();
      }
   }

   @Test()
   void testGetStatus() {
      try {
         if (null != apikey) {
            V2Spa200Response v2Spa200Response = this.getStatus(BASE_URL);
            assertNotNull(v2Spa200Response);
         }
      } catch (Exception e) {
         e.printStackTrace();
         fail();
      }
   }
}
