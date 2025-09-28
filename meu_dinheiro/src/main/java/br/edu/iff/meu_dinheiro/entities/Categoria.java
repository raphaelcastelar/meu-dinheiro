package br.edu.iff.meu_dinheiro.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O nome da categoria não pode ser vazio.")
    private String nome;
    private String descricao;
    private TipoCategoria tipo; // Enumeração para tipo (RECEITA ou DESPESA)

    // Construtores
    public Categoria() {}

    public Categoria(String nome, String descricao, TipoCategoria tipo) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public TipoCategoria getTipo() { return tipo; }
    public void setTipo(TipoCategoria tipo) { this.tipo = tipo; }
}

// Enumeração TipoCategoria
enum TipoCategoria {
    RECEITA, DESPESA
}