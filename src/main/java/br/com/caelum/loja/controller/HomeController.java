package br.com.caelum.loja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mauyr on 25/01/17.
 */
@Controller
public class HomeController {

        @RequestMapping("/")
        public String index(){
            System.out.println("Entrando na home da CDC");
            return "home";
        }

}
