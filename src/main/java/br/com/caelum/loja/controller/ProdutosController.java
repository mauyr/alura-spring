package br.com.caelum.loja.controller;

import br.com.caelum.loja.dao.ProdutoDAO;
import br.com.caelum.loja.model.Preco;
import br.com.caelum.loja.model.Produto;
import br.com.caelum.loja.model.TipoPreco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mauyr on 26/01/17.
 */
@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoDAO produtoDao;

    @RequestMapping("/edit")
    public ModelAndView edit() {
        ModelAndView modelAndView = new ModelAndView("produtos/edit");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create(Produto produto){
        produto.getPrecos().forEach(preco->preco.setProduto(produto));
        System.out.println(produto.toString());
        produtoDao.save(produto);
        return "produtos/ok";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(Produto produto){
        produto.getPrecos().forEach(preco->preco.setProduto(produto));
        System.out.println(produto.toString());
        produtoDao.save(produto);
        return "produtos/ok";
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(Produto produto){
        ModelAndView modelAndView = new ModelAndView("produtos/list");
        modelAndView.addObject("produtos", produtoDao.findAll());

        return modelAndView;
    }
}
