package com.pragmaticplay.forex.dto;

import java.util.HashMap;

public class CurrencyMapResponse extends DefaultResponse{
    HashMap<String,Double> currencyMap=new HashMap<>();

    public HashMap<String, Double> getCurrencyMap() {
        return currencyMap;
    }

    public void setCurrencyMap(HashMap<String,Double> currencyMap) {
        this.currencyMap=currencyMap;
    }
}
