package br.edu.iff.meu_dinheiro.entities;

import java.io.Serializable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Relatorio implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;

    @NotBlank(message = "O período (mês/ano) não pode ser vazio.")
    @Size(min = 7, max = 7, message = "O período deve estar no formato 'YYYY-MM' (ex.: 2025-08).")
    private String mesAno;

    private Double totalReceitas;
    private Double totalDespesas;
    private Double saldo;

    public Relatorio() {}

    public Relatorio(Long id, String mesAno, Double totalReceitas, Double totalDespesas, Double saldo) {
        this.id = id;
        this.mesAno = mesAno;
        this.totalReceitas = totalReceitas;
        this.totalDespesas = totalDespesas;
        this.saldo = saldo;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getMesAno() { return mesAno; }
    public void setMesAno(String mesAno) { this.mesAno = mesAno; }

    public Double getTotalReceitas() { return totalReceitas; }
    public void setTotalReceitas(Double totalReceitas) { this.totalReceitas = totalReceitas; }

    public Double getTotalDespesas() { return totalDespesas; }
    public void setTotalDespesas(Double totalDespesas) { this.totalDespesas = totalDespesas; }

    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((mesAno == null) ? 0 : mesAno.hashCode());
        result = prime * result + ((totalReceitas == null) ? 0 : totalReceitas.hashCode());
        result = prime * result + ((totalDespesas == null) ? 0 : totalDespesas.hashCode());
        result = prime * result + ((saldo == null) ? 0 : saldo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Relatorio other = (Relatorio) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}