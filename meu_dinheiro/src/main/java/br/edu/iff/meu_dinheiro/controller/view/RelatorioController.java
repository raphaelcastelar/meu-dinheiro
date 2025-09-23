package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.iff.meu_dinheiro.entities.Relatorio;
import br.edu.iff.meu_dinheiro.service.RelatorioService;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public String showReport(@RequestParam(required = false) String mesAno, Model model) {
        Relatorio relatorio = relatorioService.generateReport(mesAno != null ? mesAno : 
                java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM")));
        model.addAttribute("pageTitle", "Relatório");
        model.addAttribute("monthlyReport", relatorio);
        return "relatorio";
    }
}