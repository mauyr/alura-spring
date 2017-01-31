package br.com.caelum.loja.controller;

import br.com.caelum.loja.dao.ProdutoDAO;
import br.com.caelum.loja.model.Preco;
import br.com.caelum.loja.model.Produto;
import br.com.caelum.loja.model.TipoPreco;
import br.com.caelum.loja.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    public ModelAndView create(Produto produto, RedirectAttributes redirectAttributes){
        produto.getPrecos().forEach(preco->preco.setProduto(produto));
        produtoDao.save(produto);
        redirectAttributes.addFlashAttribute("message", Messages.ITEM_SAVED.getMessage("Produto"));
        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ModelAndView update(Produto produto, RedirectAttributes redirectAttributes){
        produto.getPrecos().forEach(preco->preco.setProduto(produto));
        produtoDao.update(produto);
        redirectAttributes.addFlashAttribute("message", Messages.ITEM_SAVED.getMessage("Produto"));
        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(Produto produto){
        ModelAndView modelAndView = new ModelAndView("produtos/list");
        modelAndView.addObject("produtos", produtoDao.findAll());

        return modelAndView;
    }
}
