package br.edu.iff.meu_dinheiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iff.meu_dinheiro.entities.Despesa;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    Despesa findByDataAndDescricao(String data, String descricao);
}