package br.edu.iff.meu_dinheiro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.iff.meu_dinheiro.entities.Relatorio;

@Repository
public interface RelatorioRepository extends JpaRepository<Relatorio, Long> {
    // Método personalizaro para buscar relatório por período (mesAno)
    Relatorio findByMesAno(String mesAno);
}
