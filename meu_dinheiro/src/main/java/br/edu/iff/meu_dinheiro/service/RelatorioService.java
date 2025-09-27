package br.edu.iff.meu_dinheiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.iff.meu_dinheiro.entities.Relatorio;
import br.edu.iff.meu_dinheiro.entities.Receita;
import br.edu.iff.meu_dinheiro.entities.Despesa;
import br.edu.iff.meu_dinheiro.repository.RelatorioRepository;
import br.edu.iff.meu_dinheiro.repository.ReceitaRepository;
import br.edu.iff.meu_dinheiro.repository.DespesaRepository;

@Service
public class RelatorioService {

    private final RelatorioRepository relatorioRepository;
    private final ReceitaRepository receitaRepository;
    private final DespesaRepository despesaRepository;

    @Autowired
    public RelatorioService(RelatorioRepository relatorioRepository, ReceitaRepository receitaRepository, DespesaRepository despesaRepository) {
        this.relatorioRepository = relatorioRepository;
        this.receitaRepository = receitaRepository;
        this.despesaRepository = despesaRepository;
    }

    // Método para atualizar ou criar relatório do mês
    public void atualizarRelatorioDoMes(String mesAno) {
        Relatorio relatorio = relatorioRepository.findByMesAno(mesAno);

        if (relatorio == null) {
            relatorio = new Relatorio();
            relatorio.setMesAno(mesAno);
            relatorio.setTotalReceitas(0.0);
            relatorio.setTotalDespesas(0.0);
            relatorio.setSaldo(0.0);
        }

        // Calcular total de receitas do mês
        double totalReceitas = receitaRepository.findAll().stream()
                .filter(r -> r.getData().equals(mesAno))
                .mapToDouble(Receita::getValor)
                .sum();

        // Calcular total de despesas do mês
        double totalDespesas = despesaRepository.findAll().stream()
                .filter(d -> d.getData().equals(mesAno))
                .mapToDouble(Despesa::getValor)
                .sum();

        relatorio.setTotalReceitas(totalReceitas);
        relatorio.setTotalDespesas(totalDespesas);
        relatorio.setSaldo(totalReceitas - totalDespesas);

        relatorioRepository.save(relatorio);
    }

    // Método para atualizar relatório ao adicionar receita
    public void atualizarAposAdicionarReceita(Receita receita) {
        atualizarRelatorioDoMes(receita.getData());
    }

    // Método para atualizar relatório ao adicionar despesa
    public void atualizarAposAdicionarDespesa(Despesa despesa) {
        atualizarRelatorioDoMes(despesa.getData());
    }

    public Iterable<Relatorio> findAll() {
        return relatorioRepository.findAll();
    }
}