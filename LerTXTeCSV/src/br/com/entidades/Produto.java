
package br.com.entidades;

import java.io.Serializable;

public class Produto implements Serializable { 
// O Serializable é um padrão que permite que o meu objeto do tipo produto seja                                                
// transformado em uma sequência de bytes, isso serve principalmente se eu precisar 
//gravar esses arquivos em disco ou trafegar em rede. Em sistemas java mais antigos 
//pode ocorrer problemas se não colocar o Serializable.
//    public static final long serialVersionUID = 1L; // Colocando um ID para o Serializable coloco 1.
    private String name;
    private Double preco;
    private Integer quantidade;

    public Produto() {
    }

    public Produto(String name, Double preco, Integer quantidade) {
        this.name = name;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getName() {
        return name;
    }

    public Double getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produto{" + "name=" + name + ", preco=" + preco + ", quantidade=" + quantidade + '}';
    }   
}
