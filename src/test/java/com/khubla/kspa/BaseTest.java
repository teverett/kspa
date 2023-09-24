package com.khubla.kspa;

import java.io.File;
import java.nio.file.Files;

import org.junit.jupiter.api.BeforeAll;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.SpaControlApi;
import org.openapitools.client.model.V2Spa200Response;

public class BaseTest {
   protected static String apikey;
   protected static final String BASE_URL = "https://api.myarcticspa.com";

   @BeforeAll
   static void setup() {
      try {
         File file = new File(".apikey");
         if (file.exists()) {
            apikey = Files.readString(file.toPath());
            if ((null != apikey) && (apikey.length() > 0)) {
               apikey = apikey.trim();
            }
         } else {
            apikey = null;
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   protected V2Spa200Response getStatus() throws ApiException {
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
         return spaControlApi.v2Spa();
      }
      return null;
   }
}
