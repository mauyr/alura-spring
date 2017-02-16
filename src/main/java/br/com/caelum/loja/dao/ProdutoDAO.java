package br.com.caelum.loja.dao;

import br.com.caelum.loja.model.Produto;
import br.com.caelum.loja.model.TipoPreco;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mauyr on 26/01/17.
 */
@Repository
public class ProdutoDAO extends GenericDao<Produto, Integer> {

    public ProdutoDAO() {
        super(Produto.class);
    }

    public List<Produto> findAllWithDetail() {
        return entityManager.createQuery("select distinct(p) from Produto p join fetch p.precos").getResultList();
    }

    public Produto findByIdWithDetail(Integer id) {
        return entityManager.createQuery("select distinct(p) " +
                "from Produto p " +
                "join fetch p.precos " +
                "where p.id = :id", Produto.class)
                .setParameter("id", id)
                .getSingleResult();

    }

    @Override
    public Produto save(Produto produto) {
        produto.getPrecos().forEach(preco->preco.setProduto(produto));
        return super.save(produto);
    }

    public BigDecimal somaPrecosPorTipo(TipoPreco tipoPreco){
        TypedQuery<BigDecimal> query = entityManager.createQuery("select sum(preco.valor) from Produto p join p.precos preco where preco.tipo = :tipoPreco", BigDecimal.class);
        query.setParameter("tipoPreco", tipoPreco);
        return query.getSingleResult();
    }
}
