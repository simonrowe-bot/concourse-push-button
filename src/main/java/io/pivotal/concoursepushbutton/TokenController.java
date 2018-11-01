package io.pivotal.concoursepushbutton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/token")
public class TokenController {

    @Autowired
    private TokenService tokenService;

    @Value("${concourse.login.url}")
    private String concourseLoginUrl;

    @Value("${redirect.url}")
    private String redirectUrl;


    @GetMapping("get")
    public String getBearerToken() {
        return "redirect:" + concourseLoginUrl + redirectUrl;
    }

    @RequestMapping("set")
    public String setBearerToken(@RequestParam("token") String token, HttpServletResponse response) {
        tokenService.setBearerToken(token);
        return "redirect:/";
    }
}
