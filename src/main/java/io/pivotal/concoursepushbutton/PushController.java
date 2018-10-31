package io.pivotal.concoursepushbutton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class PushController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${push.button.endpoint}")
    private String pushButtonEndpoint;

    @PostMapping("/push")
    public Map push() {
        return restTemplate.postForEntity(pushButtonEndpoint, "", Map.class ).getBody();
    }
}




