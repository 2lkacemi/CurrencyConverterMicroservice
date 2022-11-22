package com.microservice.currencyconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//Give ability to use Feign,
@EnableFeignClients
@EnableDiscoveryClient
public class CurrencyConversionApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyConversionApplication.class, args);
    }

}
