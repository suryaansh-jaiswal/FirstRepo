package com.pragmaticplay.forex.cache;

import java.util.HashMap;
public class CurrencyCache {


    private static CurrencyCache instance = null;

    private CurrencyCache() {}

    public static CurrencyCache getInstance() {
        if (instance == null)
            instance = new CurrencyCache();
        return instance;
    }
    public HashMap<String,Double> currencyMultiplierMap=new HashMap<>();

    public HashMap<String,Double> getCurrencyMultiplierMap() {
        return currencyMultiplierMap;
    }

    public void setCurrencyMultiplierMap(HashMap<String,Double> currencyMultiplierMap) {
        this.currencyMultiplierMap = currencyMultiplierMap;
    }
    public void put(String currencyCode,Double multiplier){
        currencyMultiplierMap.put(currencyCode, multiplier);
    }
}
