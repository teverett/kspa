package com.khubla.kspa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.openapitools.client.model.V2LightRequest.StateEnum;

public class TestSpa extends BaseTest {
   @Test()
   void testStatus() {
      try {
         if (null != apikey) {
            Spa spa = new Spa(this.apikey);
            Status status = spa.getStatus();
            assertNotNull(status);
         }
      } catch (Exception e) {
         e.printStackTrace();
         fail();
      }
   }

   @Test()
   void testLights() {
      try {
         if (null != apikey) {
            Spa spa = new Spa(this.apikey);
            spa.setLights(StateEnum.ON);
            Thread.sleep(5 * 1000);
            spa.setLights(StateEnum.OFF);
         }
      } catch (Exception e) {
         e.printStackTrace();
         fail();
      }
   }
}
