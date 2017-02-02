package br.com.caelum.loja.controller;

import br.com.caelum.loja.model.CarrinhoCompras;
import br.com.caelum.loja.model.DadosPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.concurrent.Callable;

/**
 * Created by mauyr on 02/02/17.
 */
@RequestMapping("/pagamento")
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {

    @Autowired
    CarrinhoCompras carrinho;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/finalizar")
    public Callable<ModelAndView> finalizar(RedirectAttributes model) {
        return () -> {
            try {
                String uri = "http://book-payment.herokuapp.com/payment";
                String response = restTemplate.postForObject(uri, new DadosPagamento(carrinho.getTotal()), String.class);

                model.addFlashAttribute("message", response);
                System.out.println(response);
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
                model.addFlashAttribute("message", e.getMessage());
            }

            return new ModelAndView("redirect:/produtos");
        };
    }

}
