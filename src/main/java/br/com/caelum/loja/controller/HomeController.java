package br.com.caelum.loja.controller;

import br.com.caelum.loja.dao.ProdutoDAO;
import br.com.caelum.loja.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by mauyr on 25/01/17.
 */
@Controller
public class HomeController {

    @Autowired
    ProdutoDAO produtoDao;

    @RequestMapping("/")
    @Cacheable(value="produtos")
    public ModelAndView index() {
        List<Produto> produtos = produtoDao.findAll();
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("produtos", produtos);
        return modelAndView;
    }

}
