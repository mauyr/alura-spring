package br.com.caelum.loja.controller;

import br.com.caelum.loja.model.CarrinhoCompras;
import br.com.caelum.loja.model.DadosPagamento;
import br.com.caelum.loja.model.PagamentoResponse;
import br.com.caelum.loja.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.*;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.concurrent.Callable;

/**
 * Created by mauyr on 02/02/17.
 */
@RequestMapping("/payment")
@Controller
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class PagamentoController {

    @Autowired
    CarrinhoCompras carrinho;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private CsrfTokenRepository csrfTokenRepository;

    @Autowired
    private MailSender sender;

    @RequestMapping("/end")
    public Callable<ModelAndView> finalizar(@AuthenticationPrincipal Usuario usuario, RedirectAttributes model) {
        return () -> {
            try {
                String uri = "http://localhost:8080/alura/payment/creditcard";

                HttpEntity<DadosPagamento> requestEntity = new HttpEntity<>(new DadosPagamento(carrinho.getTotal()), this.csrfHeaders());

                ResponseEntity<PagamentoResponse> response = restTemplate.exchange(
                        uri,
                        HttpMethod.POST,
                        requestEntity,
                        PagamentoResponse.class);

                PagamentoResponse responseBody = response.getBody();

                model.addFlashAttribute("message", responseBody.getMessage());

                if (responseBody.getStatus().equals(HttpStatus.ACCEPTED)) {
                    enviaEmailCompraProduto(usuario);
                }
            } catch (HttpClientErrorException e) {
                e.printStackTrace();
                model.addFlashAttribute("message", e.getMessage());
            }

            return new ModelAndView("redirect:/produtos");
        };
    }

    @RequestMapping("/creditcard")
    public PagamentoResponse realizaPagamento(DadosPagamento dadosPagamento) {
        if (dadosPagamento.getTotal().compareTo(new BigDecimal(500L)) > 0) {
            return new PagamentoResponse(HttpStatus.BAD_REQUEST, "Valor maior que R$ 500,00");
        } else {
            return new PagamentoResponse(HttpStatus.ACCEPTED, "Pagamento processado com sucesso");
        }
    }

    private void enviaEmailCompraProduto(Usuario usuario) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject("Compra finalizada com sucesso");
//        email.setTo(usuario.getEmail());
        email.setTo("mauyr.pereira@inovapro.com.br");
        email.setText("Compra aprovada com sucesso no valor de " + carrinho.getTotal());
        email.setFrom("suporte@inovapro.com.br");

        sender.send(email);
    }

    //Criado um método temporário devido a não se ter ainda autenticao para WS-REST
    public HttpHeaders basicAuthHeaders() {
        String plainCreds = "admin:admin";
        byte[] plainCredsBytes = plainCreds.getBytes();
        byte[] base64CredsBytes = Base64.getEncoder().encode(plainCredsBytes);
        String base64Creds = new String(base64CredsBytes);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        return headers;
    }

    public HttpHeaders csrfHeaders() {
        CsrfToken csrfToken = csrfTokenRepository.generateToken(null);
        HttpHeaders headers = basicAuthHeaders();

        headers.add(csrfToken.getHeaderName(), csrfToken.getToken());
        headers.add("Cookie", "XSRF-TOKEN=" + csrfToken.getToken());

        return headers;
    }


}
