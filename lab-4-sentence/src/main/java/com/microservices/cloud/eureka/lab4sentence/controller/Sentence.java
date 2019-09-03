package com.microservices.cloud.eureka.lab4sentence.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RestController
public class Sentence {

    @Autowired
    private RestTemplate template;

    @GetMapping("/sentence")
    public @ResponseBody String getSentence() {
        return getWord("LAB-4-SUBJECT") + " "
                + getWord("LAB-4-VERB")+ " "
                + getWord("LAB-4-ARTICLE")+ " "
                + getWord("LAB-4-ADJECTIVE")+ " "
                + getWord("LAB-4-NOUN")+ ".";
    }

    public String getWord(String service) {
        return  template.getForObject("http://" + service, String.class);
    }
}
