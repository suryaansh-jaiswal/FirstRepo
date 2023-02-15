package com.pragmaticplay.forex.controller;

import com.pragmaticplay.forex.dto.CurrencyListResponse;
import com.pragmaticplay.forex.dto.CurrencyResponse;
import com.pragmaticplay.forex.dto.DefaultResponse;
import com.pragmaticplay.forex.entity.Currency;
import com.pragmaticplay.forex.service.CacheService;
import com.pragmaticplay.forex.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService ;

    @Autowired
    private CacheService cacheService;


    @GetMapping("/getOne/{codes}")
    public ResponseEntity<CurrencyResponse> getOne(@PathVariable("codes") String codes){
            //public CurrencyListResponse getOne(){
        CurrencyResponse response = new CurrencyResponse();
        //Currency currency =  currencyService.getOne(codes);
        //System.out.println(currency.getCode());
        try{
            Currency currency =  currencyService.getOne(codes);
            if(currency.getCode()!=null) {
                response.setCode(0);
               response.setMessage("Success");

            }
            else{
                response.setCode(1);
                response.setMessage("No such Code available");
                return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
            }
            response.setCurrency(currency);
        }catch (EmptyResultDataAccessException e){
            e.printStackTrace();
            response.setCode(10);
            response.setMessage("Invalid Code Name");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);

    }


    // Read operation
    //BeanProperty Row mapper won't work as all parameter names have been changed in Currency class
    /*@GetMapping("/getAll")
    public CurrencyListResponse getAll(){
        CurrencyListResponse response = new CurrencyListResponse();
        try{
            List<Currency>  list = currencyService.getAllCurrencies();
            response.setCode(0);
            response.setMessage("Success");
            response.setCurrencies(list);
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(10);
            response.setMessage("Internal Server Error");
            return response;
        }
        return response;

    }*/

    @GetMapping("/getAllRow")
    public ResponseEntity<CurrencyListResponse> getAllRow(){
        CurrencyListResponse response = new CurrencyListResponse();
        try{
            List<Currency>  list = currencyService.getAllRow();
            response.setCode(0);
            response.setMessage("Success");
            response.setCurrencies(list);
            if(list.isEmpty()){
                response.setCode(10);
                response.setMessage("No records Exist");
                return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(10);
            response.setMessage("Internal Server Error");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);

    }



    // Create operation
    @PostMapping("/save")
    public ResponseEntity<DefaultResponse> save(@RequestBody Currency currency){
        DefaultResponse response = new DefaultResponse();
        try {
            int status = currencyService.save(currency);

            if (status == 1) {
                response.setCode(0);
                response.setMessage("Success");
            } else {
                response.setCode(1);
                response.setMessage("Error");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(10);
            response.setMessage("Internal Server Error");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    // Update operation
    @PutMapping("/update")
    public ResponseEntity<DefaultResponse> update(@RequestBody Currency currency){
        DefaultResponse response = new DefaultResponse();
        try {
       int status =  currencyService.update(currency);
            if (status == 1) {
                response.setCode(0);
                response.setMessage("Success");
            } else {
                response.setCode(1);
                response.setMessage("Update not done");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(10);
            response.setMessage("Internal Server Error");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PutMapping("/updateIndexParam")
    public ResponseEntity<DefaultResponse> updateIndexParam(@RequestBody Currency currency){
        DefaultResponse response = new DefaultResponse();
        try {
            int status =  currencyService.updateIndexParam(currency);
            if (status == 1) {
                response.setCode(0);
                response.setMessage("Success");
            } else {
                response.setCode(1);
                response.setMessage("Update not done");
            }
        }catch (Exception e){
            e.printStackTrace();
            response.setCode(10);
            response.setMessage("Internal Server Error");
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    // Delete operation
    @DeleteMapping("/delete/{code}")
    public ResponseEntity<DefaultResponse> delete(@PathVariable("code") String code){
        DefaultResponse response = new DefaultResponse();

        try {
            int flag = currencyService.delete(code);

            if (flag == 1) {
                response.setCode(0);
                response.setMessage("Success");
            } else {
                response.setCode(1);
                response.setMessage("Currency Not Exists");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            response.setCode(10);
            response.setMessage("Internal Server Error");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @DeleteMapping("/deleteByCode")
        public ResponseEntity<DefaultResponse> deleteByCode(@RequestParam("code") String code){
        DefaultResponse response = new DefaultResponse();
        try {
            int flag = currencyService.delete(code);
            if (flag == 1) {
                response.setCode(0);
                response.setMessage("Success");
            } else {
                response.setCode(1);
                response.setMessage("Currency Not Exists");
            }
        }
        catch(Exception e){
            e.printStackTrace();
            response.setCode(10);
            response.setMessage("Internal Server Error");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
    /*@RequestMapping(value="/hello",method=RequestMethod.POST,consumes = "application/json")
    public void get(@RequestBody CurrencyExchange currencyExchange){
        System.out.println(currencyExchange.getDisclaimer());
        System.out.println(currencyExchange.getLicense());
        System.out.println(currencyExchange.getTimeStamp());
        System.out.println(currencyExchange.getBase());
        System.out.println(currencyExchange.getRates());
}*/


}
