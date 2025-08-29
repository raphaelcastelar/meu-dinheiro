package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.iff.meu_dinheiro.service.RelatorioService;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public String showReport(@RequestParam(required = false) String mesAno, Model model) {
        String defaultMesAno = "2025-08"; // Padrão para o mês atual (agosto 2025)
        mesAno = (mesAno != null && !mesAno.isEmpty()) ? mesAno : defaultMesAno;
        double monthlyReport = relatorioService.getMonthlyReport(mesAno);
        model.addAttribute("monthlyReport", monthlyReport);
        model.addAttribute("mesAno", mesAno);
        return "relatorio";
    }
}