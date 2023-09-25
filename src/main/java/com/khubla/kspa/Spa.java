package com.khubla.kspa;

import org.modelmapper.ModelMapper;
import org.openapitools.client.ApiClient;
import org.openapitools.client.ApiException;
import org.openapitools.client.api.SpaControlApi;
import org.openapitools.client.model.V2BlowerRequest;
import org.openapitools.client.model.V2EasyModeRequest;
import org.openapitools.client.model.V2FilterRequest;
import org.openapitools.client.model.V2FoggerRequest;
import org.openapitools.client.model.V2LightRequest;
import org.openapitools.client.model.V2PumpRequest;
import org.openapitools.client.model.V2SDSRequest;
import org.openapitools.client.model.V2Spa200Response;
import org.openapitools.client.model.V2TemperatureRequest;
import org.openapitools.client.model.V2YESSRequest;

/**
 * @author Tom Everett
 */
public class Spa {
   private static final String BASE_URL = "https://api.myarcticspa.com";
   private final String apikey;
   private final ApiClient apiClient;
   private final SpaControlApi spaControlApi;
   private final ModelMapper modelMapper = new ModelMapper();
   private final Capabilities capabilities;

   public Spa(String apikey) throws ApiException {
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
      /*
       * query for capabilities
       */
      final Status status = getStatus();
      capabilities = new Capabilities(status);
   }

   public Capabilities getCapabilities() {
      return capabilities;
   }

   public Status getStatus() throws ApiException {
      final V2Spa200Response v2Spa200Response = spaControlApi.v2Spa();
      return modelMapper.map(v2Spa200Response, Status.class);
   }

   public void setBlower(int blower, V2BlowerRequest.StateEnum state) throws ApiException {
      if ((blower > 0) && (blower <= capabilities.getNumberBlowers())) {
         final V2BlowerRequest v2BlowerRequest = new V2BlowerRequest();
         v2BlowerRequest.setState(state);
         spaControlApi.v2Blower(Integer.toString(blower), v2BlowerRequest);
      }
   }

   public void setBoost() throws ApiException {
      spaControlApi.v2Boost();
   }

   public void setEasyMode(V2EasyModeRequest.StateEnum state) throws ApiException {
      final V2EasyModeRequest v2EasyModeRequest = new V2EasyModeRequest();
      v2EasyModeRequest.setState(state);
      spaControlApi.v2EasyMode(v2EasyModeRequest);
   }

   public void setFilter(V2FilterRequest.StateEnum state, Integer frequency, Integer duration, Boolean suspension) throws ApiException {
      final V2FilterRequest v2FilterRequest = new V2FilterRequest();
      v2FilterRequest.setState(state);
      v2FilterRequest.setFrequency(frequency);
      v2FilterRequest.setDuration(duration);
      v2FilterRequest.setSuspension(suspension);
      spaControlApi.v2Filter(v2FilterRequest);
   }

   public void setFogger(V2FoggerRequest.StateEnum state) throws ApiException {
      if (capabilities.isHasFogger()) {
         final V2FoggerRequest v2FoggerRequest = new V2FoggerRequest();
         v2FoggerRequest.setState(state);
         spaControlApi.v2Fogger(v2FoggerRequest);
      }
   }

   public void setLights(V2LightRequest.StateEnum state) throws ApiException {
      final V2LightRequest v2LightRequest = new V2LightRequest();
      v2LightRequest.setState(state);
      spaControlApi.v2Light(v2LightRequest);
   }

   public void setPump(int pump, V2PumpRequest.StateEnum state) throws ApiException {
      if ((pump > 0) && (pump <= capabilities.getNumberPumps())) {
         final V2PumpRequest v2PumpRequest = new V2PumpRequest();
         v2PumpRequest.setState(state);
         spaControlApi.v2Pump(Integer.toString(pump), v2PumpRequest);
      }
   }

   public void setSDS(V2SDSRequest.StateEnum state) throws ApiException {
      if (capabilities.isHasSDS()) {
         final V2SDSRequest v2SDSRequest = new V2SDSRequest();
         v2SDSRequest.setState(state);
         spaControlApi.v2SDS(v2SDSRequest);
      }
   }

   public void setTemperature(int temp) throws ApiException {
      final V2TemperatureRequest v2TemperatureRequest = new V2TemperatureRequest();
      v2TemperatureRequest.setSetpointF(temp);
      spaControlApi.v2Temperature(v2TemperatureRequest);
   }

   public void setYESS(V2YESSRequest.StateEnum state) throws ApiException {
      if (capabilities.isHasYESS()) {
         final V2YESSRequest v2YESSRequest = new V2YESSRequest();
         v2YESSRequest.setState(state);
         spaControlApi.v2YESS(v2YESSRequest);
      }
   }
}
