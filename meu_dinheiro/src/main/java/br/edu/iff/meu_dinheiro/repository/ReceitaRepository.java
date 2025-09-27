package br.edu.iff.meu_dinheiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iff.meu_dinheiro.entities.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    Receita findByDataAndDescricao(String data, String descricao);
}