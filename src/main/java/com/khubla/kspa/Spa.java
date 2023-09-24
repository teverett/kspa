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
      final V2Spa200Response v2Spa200Response = spaControlApi.v2Spa();
      return modelMapper.map(v2Spa200Response, Status.class);
   }

   public void setBlower(int blower, boolean on) throws ApiException {
      final V2BlowerRequest v2BlowerRequest = new V2BlowerRequest();
      if (on) {
         v2BlowerRequest.state(V2BlowerRequest.StateEnum.ON);
      } else {
         v2BlowerRequest.state(V2BlowerRequest.StateEnum.OFF);
      }
      spaControlApi.v2Blower(Integer.toString(blower), v2BlowerRequest);
   }

   public void setBoost() throws ApiException {
      spaControlApi.v2Boost();
   }

   public void setEasyMode(boolean on) throws ApiException {
      final V2EasyModeRequest v2EasyModeRequest = new V2EasyModeRequest();
      if (on) {
         v2EasyModeRequest.state(V2EasyModeRequest.StateEnum.ON);
      } else {
         v2EasyModeRequest.state(V2EasyModeRequest.StateEnum.OFF);
      }
      spaControlApi.v2EasyMode(v2EasyModeRequest);
   }

   public void setFilter(boolean on) throws ApiException {
      final V2FilterRequest v2FilterRequest = new V2FilterRequest();
      if (on) {
         v2FilterRequest.state(V2FilterRequest.StateEnum.ON);
      } else {
         v2FilterRequest.state(V2FilterRequest.StateEnum.OFF);
      }
      spaControlApi.v2Filter(v2FilterRequest);
   }

   public void setFogger(boolean on) throws ApiException {
      final V2FoggerRequest v2FoggerRequest = new V2FoggerRequest();
      if (on) {
         v2FoggerRequest.state(V2FoggerRequest.StateEnum.ON);
      } else {
         v2FoggerRequest.state(V2FoggerRequest.StateEnum.OFF);
      }
      spaControlApi.v2Fogger(v2FoggerRequest);
   }

   public void setLights(boolean on) throws ApiException {
      final V2LightRequest v2LightRequest = new V2LightRequest();
      if (on) {
         v2LightRequest.setState(V2LightRequest.StateEnum.ON);
      } else {
         v2LightRequest.setState(V2LightRequest.StateEnum.OFF);
      }
      spaControlApi.v2Light(v2LightRequest);
   }

   public void setPump(int pump, boolean on) throws ApiException {
      final V2PumpRequest v2PumpRequest = new V2PumpRequest();
      if (on) {
         v2PumpRequest.state(V2PumpRequest.StateEnum.ON);
      } else {
         v2PumpRequest.state(V2PumpRequest.StateEnum.OFF);
      }
      spaControlApi.v2Pump(Integer.toString(pump), v2PumpRequest);
   }

   public void setSDS(boolean on) throws ApiException {
      final V2SDSRequest v2SDSRequest = new V2SDSRequest();
      if (on) {
         v2SDSRequest.state(V2SDSRequest.StateEnum.ON);
      } else {
         v2SDSRequest.state(V2SDSRequest.StateEnum.OFF);
      }
      spaControlApi.v2SDS(v2SDSRequest);
   }

   public void setTemperature(int temp) throws ApiException {
      final V2TemperatureRequest v2TemperatureRequest = new V2TemperatureRequest();
      v2TemperatureRequest.setSetpointF(temp);
      spaControlApi.v2Temperature(v2TemperatureRequest);
   }

   public void setYESS(boolean on) throws ApiException {
      final V2YESSRequest v2YESSRequest = new V2YESSRequest();
      if (on) {
         v2YESSRequest.state(V2YESSRequest.StateEnum.ON);
      } else {
         v2YESSRequest.state(V2YESSRequest.StateEnum.OFF);
      }
      spaControlApi.v2YESS(v2YESSRequest);
   }
}
