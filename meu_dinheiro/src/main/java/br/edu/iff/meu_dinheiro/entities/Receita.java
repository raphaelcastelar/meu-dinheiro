package br.edu.iff.meu_dinheiro.entities;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class Receita implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    @NotBlank(message = "A descrição não pode ser vazia.")
    @Size(min = 3, max = 255, message = "A descrição deve ter entre 3 e 255 caracteres.")
    private String descricao;

    @NotEmpty(message = "O valor não pode ser vazio.")
    @Positive(message = "O valor deve ser positivo.")
    private Double valor;

    @NotEmpty(message = "A data não pode ser nula.")
    private String data;

    @NotBlank(message = "A categoria não pode ser vazia.")
    @Size(min = 3, max = 100, message = "A categoria deve ter entre 3 e 100 caracteres.")
    private Categoria categoria;

    public Receita() {}

    public Receita(Long id, String descricao, Double valor, Categoria categoria, String data) {
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
    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }
    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((valor == null) ? 0 : valor.hashCode());
        result = prime * result + ((data == null) ? 0 : data.hashCode());
        result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Receita other = (Receita) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}