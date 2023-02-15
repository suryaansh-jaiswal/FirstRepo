package com.pragmaticplay.forex.listener;
import com.pragmaticplay.forex.cache.CurrencyCache;
import com.pragmaticplay.forex.controller.SystemController;
import com.pragmaticplay.forex.service.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
    public class ServerStartupLoader {

    @Autowired
    CacheService cacheService;





    @EventListener(ApplicationReadyEvent.class)
    public void runStartup() {


        CurrencyCache a = CurrencyCache.getInstance();
        a.setCurrencyMultiplierMap(cacheService.getCurrencyDetails());



    }
}




