package br.com.caelum.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mauyr on 13/02/17.
 */
@Controller
@RequestMapping(value="/login")
public class LoginController {

    @RequestMapping(method= RequestMethod.GET)
    public String login() {
        return "loginForm";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String autentica() {
        return "produtos";
    }
}
