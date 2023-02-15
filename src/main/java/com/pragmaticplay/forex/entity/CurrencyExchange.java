package com.pragmaticplay.forex.entity;

import java.util.HashMap;

public class CurrencyExchange {
    String disclaimer;
    String license;
    int timestamp;
    String base;
    HashMap<String,Double> rates=new HashMap<>();

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public int getTimeStamp() {
        return timestamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timestamp = timeStamp;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public HashMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }
}
