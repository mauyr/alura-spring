package br.com.caelum.loja.dao;

import br.com.caelum.loja.builder.ProdutoBuilder;
import br.com.caelum.loja.domain.repository.ProdutoRepository;
import br.com.caelum.loja.model.Produto;
import br.com.caelum.loja.model.TipoPreco;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mauyr on 14/02/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ProdutoRepository.class})
@ActiveProfiles("test")
public class ProdutoDAOTest {

    @Autowired
    private ProdutoRepository repository;

}
