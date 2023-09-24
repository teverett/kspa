package com.khubla.kspa;

import org.modelmapper.ModelMapper;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.SpaControlApi;
import org.openapitools.client.model.V2Spa200Response;

/**
 * @author Tom Everett
 */
public class Spa {
   private final String apikey;
   private final ApiClient apiClient;
   private static final String BASE_URL = "https://api.myarcticspa.com";
   private final SpaControlApi spaControlApi;
   private final ModelMapper modelMapper = new ModelMapper();

   public Spa(String apikey) {
      super();
      /*
       * key
       */
      this.apikey = apikey;
      /*
       * api client
       */
      apiClient = new ApiClient();
      apiClient.setApiKey(this.apikey);
      /*
       * api
       */
      spaControlApi = new SpaControlApi(apiClient);
      spaControlApi.setCustomBaseUrl(BASE_URL);
   }

   public Status getStatus() throws ApiException {
      /*
       * query
       */
      V2Spa200Response v2Spa200Response = spaControlApi.v2Spa();
      return this.modelMapper.map(v2Spa200Response, Status.class);
   }
}
