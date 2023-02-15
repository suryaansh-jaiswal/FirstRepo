package com.pragmaticplay.forex.dao;

import com.pragmaticplay.forex.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CurrencyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    //getByCodeApi
    // Remove currencies in method name
    // try catch for all api's
    // use index params in query

    //testing
    // change properties name in Currency class
    // use custom mapper

    //https://www.geeksforgeeks.org/spring-rowmapper-interface-with-example/
    public List<Currency> getAll() {
        String sql = "select currency_code from Currency";
        List<Currency> list = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Currency.class));
        return list;
    }
    public List<Currency> getAllRow() {
        String sql = "select * from Currency";
        List<Currency> list = jdbcTemplate.query(sql,new CurrencyRowMapper());
        return list;
    }

    public Currency getOne(String code) {
        String sql = "select * from Currency where currency_code=?";
        Currency temp=new Currency();
        try {
            Currency currency = (Currency) jdbcTemplate.queryForObject(sql, new Object[]{code}, new CurrencyRowMapper());
            return currency;
        }
        catch(Exception e){

            temp.setCode(null);
        }
       // return currency;
        return temp;
    }


    public int save(Currency currency) {
        String sql = "insert into Currency(currency_code,currency_symbol,currency_description,currency_blocked,multiplier,base_currency,base_multiplier,forex_needed,crypto_id) values (?,?,?,?,?,?,?,?,?)";
        int res = jdbcTemplate.update(sql,currency.getCode(),currency.getSymbol(),currency.getDescription(),currency.getBlocked(),currency.getMultiplier(),currency.getBaseCurrency(),currency.getBaseMultiplier(),currency.getForexNeeded(),currency.getCryptoId());
        return res;
    }

    public int delete(String code) {
        String sql = "delete from Currency where currency_code =?";
        int res = jdbcTemplate.update(sql, code);
        return res;
    }

    public int update(Currency currency) {
        String sql = "update Currency set currency_symbol=?,currency_description='"+currency.getDescription()+
                "',currency_blocked="+currency.getBlocked()+",multiplier="+currency.getMultiplier()+",base_currency='"+currency.getBaseCurrency()+
                "',base_multiplier="+currency.getBaseMultiplier()+",forex_needed="+currency.getForexNeeded()+",crypto_id="+currency.getCryptoId()+" where currency_code='"+currency
                .getCode()+"'";
        //System.out.println(" query " + sql);
        int res = jdbcTemplate.update(sql, currency.getSymbol());

        return res;
    }
    public int updateIndexParam(Currency currency) {
        String sql = "update Currency set currency_symbol=?,currency_description=?,currency_blocked=?,multiplier=?,base_currency=?,base_multiplier=?,forex_needed=?,crypto_id=? where currency_code=?";
        System.out.println(" query " + sql);
        int res = jdbcTemplate.update(sql, currency.getSymbol(),currency.getDescription(),currency.getBlocked(),currency.getMultiplier(),currency.getBaseCurrency(),currency.getBaseMultiplier(),currency.getForexNeeded(),currency.getCryptoId(),currency.getCode());

        return res;
    }
}
