package com.khubla.kspa;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Tom Everett
 */
public class Status {
   private Boolean connected;
   private Integer temperatureF;
   private Integer setpointF;
   private String lights;
   private Boolean spaboyConnected;
   private Boolean spaboyProducing;
   private BigDecimal ph;
   private String phStatus;
   private BigDecimal orp;
   private String orpStatus;
   private String sds;
   private String yess;
   private String fogger;
   private String blower1;
   private String blower2;
   private String pump1;
   private String pump2;
   private String pump3;
   private String pump4;
   private String pump5;
   private String filterStatus;
   private Integer filtrationDuration;
   private BigDecimal filtrationFrequency;
   private Boolean filterSuspension;
   private List<String> errors;

   public String getBlower1() {
      return blower1;
   }

   public String getBlower2() {
      return blower2;
   }

   public Boolean getConnected() {
      return connected;
   }

   public List<String> getErrors() {
      return errors;
   }

   public String getFilterStatus() {
      return filterStatus;
   }

   public Boolean getFilterSuspension() {
      return filterSuspension;
   }

   public Integer getFiltrationDuration() {
      return filtrationDuration;
   }

   public BigDecimal getFiltrationFrequency() {
      return filtrationFrequency;
   }

   public String getFogger() {
      return fogger;
   }

   public String getLights() {
      return lights;
   }

   public BigDecimal getOrp() {
      return orp;
   }

   public String getOrpStatus() {
      return orpStatus;
   }

   public BigDecimal getPh() {
      return ph;
   }

   public String getPhStatus() {
      return phStatus;
   }

   public String getPump1() {
      return pump1;
   }

   public String getPump2() {
      return pump2;
   }

   public String getPump3() {
      return pump3;
   }

   public String getPump4() {
      return pump4;
   }

   public String getPump5() {
      return pump5;
   }

   public String getSds() {
      return sds;
   }

   public Integer getSetpointF() {
      return setpointF;
   }

   public Boolean getSpaboyConnected() {
      return spaboyConnected;
   }

   public Boolean getSpaboyProducing() {
      return spaboyProducing;
   }

   public Integer getTemperatureF() {
      return temperatureF;
   }

   public String getYess() {
      return yess;
   }

   public void setBlower1(String blower1) {
      this.blower1 = blower1;
   }

   public void setBlower2(String blower2) {
      this.blower2 = blower2;
   }

   public void setConnected(Boolean connected) {
      this.connected = connected;
   }

   public void setErrors(List<String> errors) {
      this.errors = errors;
   }

   public void setFilterStatus(String filterStatus) {
      this.filterStatus = filterStatus;
   }

   public void setFilterSuspension(Boolean filterSuspension) {
      this.filterSuspension = filterSuspension;
   }

   public void setFiltrationDuration(Integer filtrationDuration) {
      this.filtrationDuration = filtrationDuration;
   }

   public void setFiltrationFrequency(BigDecimal filtrationFrequency) {
      this.filtrationFrequency = filtrationFrequency;
   }

   public void setFogger(String fogger) {
      this.fogger = fogger;
   }

   public void setLights(String lights) {
      this.lights = lights;
   }

   public void setOrp(BigDecimal orp) {
      this.orp = orp;
   }

   public void setOrpStatus(String orpStatus) {
      this.orpStatus = orpStatus;
   }

   public void setPh(BigDecimal ph) {
      this.ph = ph;
   }

   public void setPhStatus(String phStatus) {
      this.phStatus = phStatus;
   }

   public void setPump1(String pump1) {
      this.pump1 = pump1;
   }

   public void setPump2(String pump2) {
      this.pump2 = pump2;
   }

   public void setPump3(String pump3) {
      this.pump3 = pump3;
   }

   public void setPump4(String pump4) {
      this.pump4 = pump4;
   }

   public void setPump5(String pump5) {
      this.pump5 = pump5;
   }

   public void setSds(String sds) {
      this.sds = sds;
   }

   public void setSetpointF(Integer setpointF) {
      this.setpointF = setpointF;
   }

   public void setSpaboyConnected(Boolean spaboyConnected) {
      this.spaboyConnected = spaboyConnected;
   }

   public void setSpaboyProducing(Boolean spaboyProducing) {
      this.spaboyProducing = spaboyProducing;
   }

   public void setTemperatureF(Integer temperatureF) {
      this.temperatureF = temperatureF;
   }

   public void setYess(String yess) {
      this.yess = yess;
   }
}
