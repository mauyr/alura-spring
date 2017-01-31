package br.com.caelum.loja.controller;

import br.com.caelum.loja.dao.ProdutoDAO;
import br.com.caelum.loja.model.Preco;
import br.com.caelum.loja.model.Produto;
import br.com.caelum.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mauyr on 26/01/17.
 */
@Controller
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDao;

    @RequestMapping("/produtos/form")
    public ModelAndView form() {
        ModelAndView modelAndView = new ModelAndView("produtos/form");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping("/produtos/gravar")
    public String gravar(Produto produto){
        produto.getPrecos().forEach(preco->preco.setProduto(produto));
        System.out.println(produto.toString());
        produtoDao.save(produto);
        return "produtos/ok";
    }
}
