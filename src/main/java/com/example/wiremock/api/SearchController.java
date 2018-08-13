package com.example.wiremock.api;

import com.example.wiremock.model.IpAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import static com.example.wiremock.util.Constants.IP_HOST_PROPERTY;
import static com.example.wiremock.util.Constants.SEARCH_IP_PATH;

@Controller
public class SearchController {

    @Autowired
    private RestTemplate restTemplate;

    @Value(IP_HOST_PROPERTY)
    private String ipHost;

    @GetMapping(SEARCH_IP_PATH)
    @ResponseBody
    public IpAddress searchIpAddress() {
        return restTemplate.getForEntity(ipHost, IpAddress.class).getBody();
    }
}
