package io.pivotal.concoursepushbutton;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private String bearerToken;

    public void setBearerToken(String bearerToken) {
        this.bearerToken = bearerToken;
    }

    public String getBearerToken() {
        return bearerToken;
    }
}
