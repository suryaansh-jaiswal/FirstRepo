package com.pragmaticplay.forex.dao;
import com.pragmaticplay.forex.entity.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrencyRowMapper implements RowMapper<Currency> {

    //@Override
    public Currency mapRow(ResultSet rs, int rowNum) throws SQLException {
        Currency currency = new Currency();
        currency.setCode(rs.getString(1).trim());
        currency.setSymbol(rs.getString(2).trim());
        currency.setDescription(rs.getString(3).trim());
        currency.setBlocked(rs.getInt(4));
        currency.setMultiplier(rs.getInt(5));
        currency.setBaseCurrency(rs.getString(6));
        currency.setBaseMultiplier(rs.getDouble(7));
        currency.setForexNeeded(rs.getInt(8));
        currency.setCryptoId(rs.getInt(9));
        return currency;
    }
}