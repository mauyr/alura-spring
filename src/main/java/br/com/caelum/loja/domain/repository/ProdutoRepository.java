package br.com.caelum.loja.domain.repository;

import br.com.caelum.loja.model.Produto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mauyr on 23/02/17.
 */
@Cacheable(value = "produtos")
public interface ProdutoRepository extends PagingAndSortingRepository<Produto, Integer> {

    @Query("select distinct(p) from Produto p join fetch p.precos")
    List<Produto> findAllWithDetail();

    @Query("select distinct(p) from Produto p join fetch p.precos where p.id = ?1")
    Produto findByIdWithDetail(Integer id);
}
