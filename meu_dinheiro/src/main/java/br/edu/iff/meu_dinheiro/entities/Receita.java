package br.edu.iff.meu_dinheiro.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "A descrição não pode ser vazia.")
    private String descricao;
    private Double valor;
    private String data; // Formato: yyyy-MM

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false) // Relação obrigatória
    private Categoria categoria;

    // Construtores
    public Receita() {}

    public Receita(String descricao, Double valor, String data) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.categoria = new Categoria();
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
}