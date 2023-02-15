package com.pragmaticplay.forex.dto;

import com.pragmaticplay.forex.entity.Currency;

import java.util.List;

public class CurrencyListResponse extends DefaultResponse{

    List<Currency> currencies;

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
