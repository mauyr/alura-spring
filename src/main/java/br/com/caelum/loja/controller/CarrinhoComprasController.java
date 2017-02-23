package br.com.caelum.loja.controller;

import br.com.caelum.loja.dao.ProdutoDAO;
import br.com.caelum.loja.domain.repository.ProdutoRepository;
import br.com.caelum.loja.model.CarrinhoCompras;
import br.com.caelum.loja.model.CarrinhoItem;
import br.com.caelum.loja.model.Produto;
import br.com.caelum.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mauyr on 01/02/17.
 */
@Controller
@RequestMapping("/carrinho")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class CarrinhoComprasController {

    @Autowired
    ProdutoRepository repository;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipo){
        ModelAndView modelAndView = new ModelAndView("redirect:/carrinho");
        CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
        carrinho.add(carrinhoItem);
        return modelAndView;
    }

    @RequestMapping(method= RequestMethod.GET)
    public ModelAndView itens(){
        return new ModelAndView("/carrinho/itens");
    }

    @RequestMapping(value = "/remove", method= RequestMethod.POST)
    public ModelAndView remove(Integer produtoId, TipoPreco tipoPreco){
        Produto produto = new Produto();
        produto.setId(produtoId);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipoPreco);
        carrinho.remove(carrinhoItem);
        return new ModelAndView("/carrinho/itens");
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipo){
        Produto produto = repository.findByIdWithDetail(produtoId);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipo);
        return carrinhoItem;
    }
}
