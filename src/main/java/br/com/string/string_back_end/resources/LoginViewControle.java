package br.com.string.string_back_end.resources;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginViewControle {

    @GetMapping("/login")
    public String login(){
        return "login";
    }

}
