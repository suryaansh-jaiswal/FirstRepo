package com.pragmaticplay.forex.dto;

import com.pragmaticplay.forex.entity.CurrencyExchangeApi;

public class CurrencyExchangeApiResponse {
    String message;
    int code;
    CurrencyExchangeApi currencyExchangeApi;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CurrencyExchangeApi getCurrencyExchangeApi() {
        return currencyExchangeApi;
    }

    public void setCurrencyExchangeApi(CurrencyExchangeApi currencyExchangeApi) {
        this.currencyExchangeApi = currencyExchangeApi;
    }


}
