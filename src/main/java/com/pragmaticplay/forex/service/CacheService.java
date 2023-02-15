package com.pragmaticplay.forex.service;
import java.util.HashMap;
import java.util.List;

import com.pragmaticplay.forex.dao.CurrencyDao;
import com.pragmaticplay.forex.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class CacheService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    CurrencyDao currencyDao;

    public HashMap<String,Double> getCurrencyDetails(){
        HashMap<String, Double> multiplierMap = new HashMap<>();
        //CurrencyCache a = CurrencyCache.getInstance();
        //hm = a.getMaps();
        List<Currency> list = currencyDao.getAllRow();
        for (Currency c : list) {
            multiplierMap.put(c.getCode(),c.getMultiplier());
            //a.setMaps(hm);
        }
        return multiplierMap;
    }
}

