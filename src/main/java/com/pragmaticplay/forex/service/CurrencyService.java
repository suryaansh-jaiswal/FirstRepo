package com.pragmaticplay.forex.service;
import java.util.List;

import com.pragmaticplay.forex.dao.CurrencyDao;
import com.pragmaticplay.forex.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

      @Value("${application.name}")
      String appName;

      @Autowired
      CurrencyDao currencyDao;


      public  int delete(String code) {

          return currencyDao.delete(code);
      }

      public List<Currency> getAllCurrencies(){

            System.out.println("appname " + appName);
            return currencyDao.getAll();
      }

      public List<Currency> getAllRow(){

            //System.out.println("appname " + appName);
            return currencyDao.getAllRow();
      }
      public Currency getOne(String code){

            System.out.println("appname " + appName);
            return currencyDao.getOne(code);
      }


      public int save(Currency currency) {
            return currencyDao.save(currency);
      }

      public int update(Currency cur) {
            return currencyDao.update(cur);
      }

      public int updateIndexParam(Currency cur) {
            return currencyDao.updateIndexParam(cur);
      }
}
