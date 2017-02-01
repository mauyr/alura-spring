package br.com.caelum.loja.controller;

import br.com.caelum.loja.dao.ProdutoDAO;
import br.com.caelum.loja.model.CarrinhoCompras;
import br.com.caelum.loja.model.CarrinhoItem;
import br.com.caelum.loja.model.Produto;
import br.com.caelum.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    private ProdutoDAO produtoDao;

    @Autowired
    private CarrinhoCompras carrinho;

    @RequestMapping("/add")
    public ModelAndView add(Integer produtoId, TipoPreco tipo){
        ModelAndView modelAndView = new ModelAndView("redirect:/produtos");
        CarrinhoItem carrinhoItem = criaItem(produtoId, tipo);
        carrinho.add(carrinhoItem);
        return modelAndView;
    }

    private CarrinhoItem criaItem(Integer produtoId, TipoPreco tipo){
        Produto produto = produtoDao.findById(produtoId);
        CarrinhoItem carrinhoItem = new CarrinhoItem(produto, tipo);
        return carrinhoItem;
    }
}
