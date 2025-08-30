package br.edu.iff.meu_dinheiro.entities;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    @NotBlank(message = "O nome da categoria não pode ser vazio.")
    @Size(min = 3, max = 100, message = "O nome da categoria deve ter entre 3 e 100 caracteres.")
    private String nome;

    public Categoria() {}

    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Categoria other = (Categoria) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}