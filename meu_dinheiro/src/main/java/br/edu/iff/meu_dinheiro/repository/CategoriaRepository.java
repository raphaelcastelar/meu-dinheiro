package br.edu.iff.meu_dinheiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.iff.meu_dinheiro.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);
}