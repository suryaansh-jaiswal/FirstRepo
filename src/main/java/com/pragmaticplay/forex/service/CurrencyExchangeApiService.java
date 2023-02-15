package com.pragmaticplay.forex.service;

import com.pragmaticplay.forex.entity.CurrencyExchangeApi;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CurrencyExchangeApiService {

    public CurrencyExchangeApi getCurrencyExchangeApi(String base){
        String url="http://openexchangerates.org/api/latest.json?app_id=a3f7e48ca6864d76b62f14e0d76740c0&show_experimental=1&base="+base;
        RestTemplate restTemplate=new RestTemplate();
        CurrencyExchangeApi result=restTemplate.getForObject(url,CurrencyExchangeApi.class);
        return result;

    }
}
