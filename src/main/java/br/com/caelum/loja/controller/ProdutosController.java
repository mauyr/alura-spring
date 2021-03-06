package br.com.caelum.loja.controller;

import br.com.caelum.loja.dao.ProdutoDAO;
import br.com.caelum.loja.domain.repository.ProdutoRepository;
import br.com.caelum.loja.infra.FileSaver;
import br.com.caelum.loja.model.Produto;
import br.com.caelum.loja.model.TipoPreco;
import br.com.caelum.loja.util.Messages;
import br.com.caelum.loja.validation.ProdutoValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.NoResultException;
import javax.validation.Valid;

/**
 * Created by mauyr on 26/01/17.
 */
@Controller
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private FileSaver fileSaver;

    @InitBinder
    public void InitBinder(WebDataBinder binder){
        binder.addValidators(new ProdutoValidator());
    }


    @RequestMapping("/edit")
    public ModelAndView edit(Produto produto) {
        ModelAndView modelAndView = new ModelAndView("produtos/edit");
        modelAndView.addObject("tipos", TipoPreco.values());

        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST)
    @CacheEvict(value = "produtos", allEntries = true)
    public ModelAndView create(MultipartFile imagemCapa, @Valid Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return edit(produto);
        }

        String path = fileSaver.write("imagens-capa", imagemCapa);
        produto.setCaminhoImagemCapa(path);

        repository.save(produto);
        redirectAttributes.addFlashAttribute("message", Messages.ITEM_SAVED.getMessage("Produto"));
        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.PUT)
    @CacheEvict(value = "produtos")
    public ModelAndView update(Produto produto, RedirectAttributes redirectAttributes){
        produto.getPrecos().forEach(preco->preco.setProduto(produto));
        repository.save(produto);
        redirectAttributes.addFlashAttribute("message", Messages.ITEM_SAVED.getMessage("Produto"));
        return new ModelAndView("redirect:/produtos");
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView list(Produto produto){
        ModelAndView modelAndView = new ModelAndView("produtos/list");
//        modelAndView.addObject("produtos", repository.findAllWithDetail());

        return modelAndView;
    }

    @RequestMapping("/{id}")
    public ModelAndView detail(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView("/produtos/detail");
        Produto produto = repository.findByIdWithDetail(id);
        modelAndView.addObject("produto", produto);
        return modelAndView;
    }
}
