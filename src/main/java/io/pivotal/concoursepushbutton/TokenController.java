package io.pivotal.concoursepushbutton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Value("${concourse.login.url}")
    private String concourseLoginUrl;

    @Value("${redirect.url}")
    private String redirectUrl;


    @GetMapping("display")
    public String display() {
        return tokenService.getBearerToken();
    }

    @GetMapping("get")
    public void getBearerToken(HttpServletResponse response) throws Exception {
        response.sendRedirect(concourseLoginUrl + redirectUrl);
    }

    @RequestMapping("set")
    public ResponseEntity setBearerToken(@RequestParam("token") String token) {
        tokenService.setBearerToken(token);
        return ResponseEntity.ok().build();
    }
}
