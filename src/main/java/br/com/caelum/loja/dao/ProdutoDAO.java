package br.com.caelum.loja.dao;

import br.com.caelum.loja.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mauyr on 26/01/17.
 */
@Repository
public class ProdutoDAO extends GenericDao<Produto, Integer> {


}
