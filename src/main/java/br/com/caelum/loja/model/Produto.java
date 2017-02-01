package br.com.caelum.loja.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

/**
 * Created by mauyr on 26/01/17.
 */
@Entity
public class Produto implements Serializable {

    @Id @GeneratedValue
    private Integer id;

    private String titulo;
    private String descricao;
    private int paginas;

    @DateTimeFormat
    private Calendar dataLancamento;

    private String caminhoImagemCapa;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Preco> precos;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    @Override
    public String toString() {
        return "Produto [titulo=" + titulo + ", descricao=" + descricao + ", paginas=" + paginas + "]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Preco> getPrecos() {
        return precos;
    }

    public void setPrecos(List<Preco> precos) {
        this.precos = precos;
    }

    public Calendar getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(Calendar dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getCaminhoImagemCapa() {
        return caminhoImagemCapa;
    }

    public void setCaminhoImagemCapa(String caminhoImagemCapa) {
        this.caminhoImagemCapa = caminhoImagemCapa;
    }

    public BigDecimal precoPara(TipoPreco tipoPreco) {
        return precos.stream().filter(preco -> preco.getTipo().equals(tipoPreco)).findFirst().get().getValor();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Produto other = (Produto) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
