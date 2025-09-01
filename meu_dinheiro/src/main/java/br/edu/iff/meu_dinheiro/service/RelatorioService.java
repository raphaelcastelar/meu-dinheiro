package br.edu.iff.meu_dinheiro.service;

import org.springframework.stereotype.Service;

import br.edu.iff.meu_dinheiro.MonthlyReport;

@Service
public class RelatorioService {

    public MonthlyReport generateReport(String mesAno) {
        MonthlyReport report = new MonthlyReport(); // Sempre inicializa
        report.setMesAno(mesAno != null ? mesAno : java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM")));
        // Simulação de valores (substitua por lógica real se necessário)
        report.setTotalReceitas(5000.0);
        report.setTotalDespesas(3000.0);
        report.setSaldo(2000.0);
        return report;
    }
}