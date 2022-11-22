package com.microservice.currencyconversion;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * implementation of REST Client to call the forex service and process the response.
 */
@RestController
public class CurrencyConversionController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private CurrencyExchangeServiceProxy proxy;

    public CurrencyConversionController(CurrencyExchangeServiceProxy proxy) {
        this.proxy = proxy;
    }

    @GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
                                                       @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);

        logger.info("{}", response);

        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}

