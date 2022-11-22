package com.microservice.forex;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class ForexController {

    private Environment environment;
    private ExchangeValueRepository repository;

    //todo transform it to it feign
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from,
                                               @PathVariable String to) {

        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));

        return exchangeValue;
    }
}
