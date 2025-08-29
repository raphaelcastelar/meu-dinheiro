package br.edu.iff.meu_dinheiro.entities;

public class Receita {
    private Long id;
    private String descricao;
    private double valor;
    private Categoria categoria;
    private String data;

    public Receita() {}

    public Receita(Long id, String descricao, double valor, Categoria categoria, String data) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }
}