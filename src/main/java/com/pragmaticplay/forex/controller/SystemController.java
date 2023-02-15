package com.pragmaticplay.forex.controller;

import com.pragmaticplay.forex.dto.CurrencyExchangeApiResponse;
import com.pragmaticplay.forex.dto.CurrencyMapResponse;
import com.pragmaticplay.forex.service.CacheService;
import com.pragmaticplay.forex.service.CurrencyExchangeApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private CacheService cacheService;
    @Autowired
    private CurrencyExchangeApiService currencyExchangeApiService;
    @GetMapping("/getCurrencyCache")
    public ResponseEntity<CurrencyMapResponse> getCurrencyCache(){
        CurrencyMapResponse response = new CurrencyMapResponse();
        try{
            //HashMap<String,Double> currencyMap= cacheService.maps();
            response.setCode(0);
            response.setMessage("Success");
            response.setCurrencyMap(cacheService.getCurrencyDetails());
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(10);
            response.setMessage("Internal Server Error");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
            //return currencyMap;
        }
        return new ResponseEntity<>(response,HttpStatus.OK);

    }

    @GetMapping("/getCurrencyExchangeApi/{base}")
    public ResponseEntity<CurrencyExchangeApiResponse> getCurrencyExchangeApi(@PathVariable("base") String base){
        CurrencyExchangeApiResponse currencyExchangeApiResponse=new CurrencyExchangeApiResponse();
        //currencyExchangeApiResponse.setCurrencyExchangeApi(currencyExchangeApiService.getCurrencyExchangeApi(base));
        try{
            currencyExchangeApiResponse.setCode(0);
            currencyExchangeApiResponse.setMessage("Success");
            currencyExchangeApiResponse.setCurrencyExchangeApi(currencyExchangeApiService.getCurrencyExchangeApi(base));
        }
        catch (Exception e){
            e.printStackTrace();
            currencyExchangeApiResponse.setCode(10);
            currencyExchangeApiResponse.setMessage("Internal Server Error");
            return new ResponseEntity<>(currencyExchangeApiResponse, HttpStatus.BAD_REQUEST);
        }
        System.out.println("Base = "+currencyExchangeApiResponse.getCurrencyExchangeApi().getBase());
        System.out.println("Rates :");
        for(String c:currencyExchangeApiResponse.getCurrencyExchangeApi().getRates().keySet()){
            System.out.println(c+" : "+currencyExchangeApiResponse.getCurrencyExchangeApi().getRates().get(c));
        }
        return new ResponseEntity<>(currencyExchangeApiResponse,HttpStatus.OK);
    }



}
