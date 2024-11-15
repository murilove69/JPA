package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {
    // Define a chave primária para a entidade.
    @Id
    // Especifica que o ID será gerado automaticamente pelo banco.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Declara os atributos do produto.
    private String nome;
    private Double preco;

    // Método getter para chamar o ID do produto.
    public Long getId() {
        return id;
    }

    // Método setter para definir o ID do produto.
    public void setId(Long id) {
        this.id = id;
    }

    // Método getter para chamar o nome do produto.
    public String getNome() {
        return nome;
    }

    // Método setter para definir o nome do produto.
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método getter para chamar o preço do produto.
    public Double getPreco() {
        return preco;
    }

    // Método setter para definir o preço do produto.
    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
