package br.edu.iff.meu_dinheiro.entities;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


@Entity
public class expenses implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;

    @NotBlank(message = "A descrição não pode ser vazia.")
    @Size(min = 3, max = 255, message = "A descrição deve ter entre 3 e 255 caracteres.")
    private String descricao;

    @NotEmpty(message = "O valor não pode ser vazio.")
    @Positive(message = "O valor deve ser positivo.")
    private Double valor;

    @NotEmpty(message = "A data não pode ser nula.")
    private LocalDate data;

    @NotBlank(message = "A categoria não pode ser vazia.")
    @Size(min = 3, max = 100, message = "A categoria deve ter entre 3 e 100 caracteres.")
    private String categoria;

    public expenses() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return descricao;
    }

    public void setDescription(String description) {
        this.descricao = description;
    }

    public Double getValue() {
        return valor;
    }

    public void setValue(Double value) {
        this.valor = value;
    }

    public LocalDate getDate() {
        return data;
    }

    public void setDate(LocalDate date) {
        this.data = date;
    }

    public String getCategory() {
        return categoria;
    }

    public void setCategory(String category) {
        this.categoria = category;
    }

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
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        expenses other = (expenses) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (descricao == null) {
            if (other.descricao != null)
                return false;
        } else if (!descricao.equals(other.descricao))
            return false;
        if (valor == null) {
            if (other.valor != null)
                return false;
        } else if (!valor.equals(other.valor))
            return false;
        if (data == null) {
            if (other.data != null)
                return false;
        } else if (!data.equals(other.data))
            return false;
        if (categoria == null) {
            if (other.categoria != null)
                return false;
        } else if (!categoria.equals(other.categoria))
            return false;
        return true;
    }

    
    
    

}