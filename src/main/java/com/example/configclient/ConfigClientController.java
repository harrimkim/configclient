package com.example.configclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${who.am.i}")
    private String identity;
    @Value("${test.name}")
    private String testName;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/test")
    public String test() {
        return identity + "\t" + testName +"\n";
    }

    @GetMapping("/message")
    public String message(){
        return messageSource.getMessage("korea", null, Locale.KOREAN) + "\n";
    }
}