package com.pragmaticplay.forex.entity;

import java.util.HashMap;

public class CurrencyExchangeApi {
    String base;
    HashMap<String,Double> rates=new HashMap<>();

    public String getBase(){
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
