package com.supermercado.model; //Define que esta classe faz parte desse pacote

import java.util.Date; //Classe do Java para manipular datas.
import jakarta.persistence.Entity; //Anotação usada para especificar que a classe é uma entidade JPA (Java Persistence API).
import jakarta.persistence.Id; //Anotação usada para indicar o campo que será a chave primária da entidade.

@Entity //Indica que esta classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.
public class Produto { //Declaração da classe produto.
    
    @Id //Anotação que define codigoBarras como a chave primária da entidade.
    private String codigoBarras;  // Definindo o código de barras como ID
    
    // Defininndo os campos da Classe.
    private String nome;
    private Double preco;
    private Integer quantidade;
    private String categoria;
    private Date dataValidade;

    // Construtores
    public Produto() {}
    
    public Produto(String nome, Double preco, Integer quantidade, String categoria, Date dataValidade, String codigoBarras) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.dataValidade = dataValidade;
        this.codigoBarras = codigoBarras;
    }

    // Getters e Setters: Permitem acessar e modificar os valores dos campos privados da classe.
    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
}
