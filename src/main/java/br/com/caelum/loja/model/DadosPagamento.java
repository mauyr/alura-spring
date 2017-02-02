package br.com.caelum.loja.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by mauyr on 02/02/17.
 */
public class DadosPagamento implements Serializable {
    private BigDecimal total;

    public DadosPagamento(BigDecimal total) {
        this.total = total;
    }

    public DadosPagamento() {
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
