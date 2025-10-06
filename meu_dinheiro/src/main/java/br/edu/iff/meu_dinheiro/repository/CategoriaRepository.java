package br.edu.iff.meu_dinheiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.edu.iff.meu_dinheiro.entities.Categoria;
import br.edu.iff.meu_dinheiro.entities.TipoCategoria;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Categoria findByNome(String nome);

    @Query("SELECT c FROM Categoria c WHERE c.tipo = :tipo")
    List<Categoria> findByTipo(@Param("tipo") TipoCategoria tipo);
}