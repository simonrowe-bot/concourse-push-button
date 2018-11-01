package io.pivotal.concoursepushbutton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
public class PushController {


    @Autowired
    private TokenService tokenService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${push.button.endpoint}")
    private String pushButtonEndpoint;

    @RequestMapping("/push")
    public Map push() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", tokenService.getBearerToken());
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        return restTemplate.postForEntity(pushButtonEndpoint, entity, Map.class ).getBody();
    }
}




