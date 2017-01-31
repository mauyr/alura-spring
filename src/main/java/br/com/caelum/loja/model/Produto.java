package br.com.caelum.loja.model;

import javax.persistence.*;
import java.io.Serializable;
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
}
