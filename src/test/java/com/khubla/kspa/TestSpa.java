package com.khubla.kspa;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

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
}
