package com.khubla.kspa;

/**
 * @author Tom Everett
 */
public class Capabilities {
   private final int numberPumps;
   private final int numberBlowers;
   private final boolean hasSDS;
   private final boolean hasYESS;
   private final boolean hasFogger;

   public Capabilities(Status status) {
      /*
       * blowers
       */
      if (status.getBlower1() != null) {
         if (status.getBlower2() != null) {
            numberBlowers = 2;
         } else {
            numberBlowers = 1;
         }
      } else {
         numberBlowers = 0;
      }
      /*
       * pumps
       */
      if (status.getPump1() != null) {
         if (status.getPump2() != null) {
            if (status.getPump3() != null) {
               if (status.getPump4() != null) {
                  if (status.getPump5() != null) {
                     numberPumps = 5;
                  } else {
                     numberPumps = 4;
                  }
               } else {
                  numberPumps = 3;
               }
            } else {
               numberPumps = 2;
            }
         } else {
            numberPumps = 1;
         }
      } else {
         numberPumps = 0;
      }
      /*
       * Fogger
       */
      if (null != status.getFogger()) {
         hasFogger = true;
      } else {
         hasFogger = false;
      }
      /*
       * SDS
       */
      if (null != status.getSds()) {
         hasSDS = true;
      } else {
         hasSDS = false;
      }
      /*
       * YESS
       */
      if (null != status.getYess()) {
         hasYESS = true;
      } else {
         hasYESS = false;
      }
   }

   public int getNumberBlowers() {
      return numberBlowers;
   }

   public int getNumberPumps() {
      return numberPumps;
   }

   public boolean isHasFogger() {
      return hasFogger;
   }

   public boolean isHasSDS() {
      return hasSDS;
   }

   public boolean isHasYESS() {
      return hasYESS;
   }
}
