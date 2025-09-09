package br.edu.iff.meu_dinheiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.edu.iff.meu_dinheiro.entities.Relatorio;
import br.edu.iff.meu_dinheiro.exception.*;
import br.edu.iff.meu_dinheiro.repository.relatorioRepository;

@Service
public class RelatorioService {

    private final relatorioRepository relatorioRepository;

    @Autowired
    public RelatorioService(relatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    public Relatorio generateReport(String mesAno) {
        Relatorio report = relatorioRepository.findByMesAno(mesAno != null ? mesAno : 
                java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM")));
        
        if (report == null) {
            throw new RelatorioNaoEncontradoException(mesAno != null ? mesAno : 
                    java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM")));
        }
        
        return report;
    }
}