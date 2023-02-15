package com.pragmaticplay.forex.entity;

public class Currency {
    String code;
    String symbol;
    String description;
    int blocked;
    double multiplier;
    String baseCurrency;
    double baseMultiplier;
    int forexNeeded;
    int cryptoId;


    public void setCode(String code) {
        this.code = code;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public void setBaseCurrency(String baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public void setBaseMultiplier(double baseMultiplier) {
        this.baseMultiplier = baseMultiplier;
    }

    public void setForexNeeded(int forexNeeded) {
        this.forexNeeded = forexNeeded;
    }

    public void setCryptoId(int cryptoId) {
        this.cryptoId = cryptoId;
    }

    public String getCode() {
        return code;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getDescription() {
        return description;
    }

    public int getBlocked() {
        return blocked;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public String getBaseCurrency() {
        return baseCurrency;
    }

    public double getBaseMultiplier() {
        return baseMultiplier;
    }

    public int getForexNeeded() {
        return forexNeeded;
    }

    public int getCryptoId() {
        return cryptoId;
    }
    /*@Override
    public String toString() {
        return "Currency symbol " +currency_symbol;
    }*/
}
