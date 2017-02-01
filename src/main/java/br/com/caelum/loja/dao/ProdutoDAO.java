package br.com.caelum.loja.dao;

import br.com.caelum.loja.model.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mauyr on 26/01/17.
 */
@Repository
public class ProdutoDAO extends GenericDao<Produto, Integer> {

    public ProdutoDAO() {
        super(Produto.class);
    }

    public Produto findByIdWithDetail(Integer id) {
        return entityManager.createQuery("select distinct(p) " +
                "from Produto p " +
                "join fetch p.precos " +
                "where p.id = :id", Produto.class)
                .setParameter("id", id)
                .getSingleResult();

    }
}
