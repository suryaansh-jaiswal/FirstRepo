package com.pragmaticplay.forex.dto;
import com.pragmaticplay.forex.entity.Currency;

public class CurrencyResponse extends DefaultResponse{
    Currency currency;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
