package br.com.caelum.loja.domain.repository;

import br.com.caelum.loja.model.Produto;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by mauyr on 18/02/17.
 */
public interface ProdutoRepository extends CrudRepository<Produto, Integer> {
}
