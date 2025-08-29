package br.edu.iff.meu_dinheiro.service;

import br.edu.iff.meu_dinheiro.entities.Despesa;
import br.edu.iff.meu_dinheiro.entities.Receita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioService {
    @Autowired
    private DespesaService despesaService;
    @Autowired
    private ReceitaService receitaService;

    public double getMonthlyReport(String mesAno) {
        List<Despesa> despesas = despesaService.findAll();
        List<Receita> receitas = receitaService.findAll();

        // Filtra por mês/ano (simplificado, assume que data está no formato "yyyy-MM-dd")
        double totalDespesas = despesas.stream()
                .filter(d -> d.getData().startsWith(mesAno))
                .mapToDouble(Despesa::getValor)
                .sum();

        double totalReceitas = receitas.stream()
                .filter(r -> r.getData().startsWith(mesAno))
                .mapToDouble(Receita::getValor)
                .sum();

        return totalReceitas - totalDespesas;
    }
}
