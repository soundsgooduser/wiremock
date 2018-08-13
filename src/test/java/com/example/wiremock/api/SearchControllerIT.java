package com.example.wiremock.api;

import com.example.wiremock.config.WiremockApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static com.example.wiremock.util.Constants.SEARCH_IP_PATH;
import static org.assertj.core.api.BDDAssertions.then;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WiremockApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SearchControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testSearchIp() {
        final String searchIpUrl = "http://localhost:" + this.port + SEARCH_IP_PATH;
        final ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(searchIpUrl, Map.class);

        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
