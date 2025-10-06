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
@RequestMapping("/user/relatorio")
public class RelatorioController {

    private final RelatorioService relatorioService;

    @Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public String showRelatorioPage(Model model) {
        model.addAttribute("relatorios", relatorioService.findAll()); // Exibe todos os relatórios calculados
        return "relatorio";
    }

    @GetMapping(params = "mesAno")
    public String updateMonth(@RequestParam String mesAno, Model model) {
        relatorioService.atualizarRelatorioDoMes(mesAno); // Atualiza o relatório do mês
        model.addAttribute("monthlyReport", relatorioService.findAll().iterator().next()); // Ajuste para mostrar o relatório do mês
        model.addAttribute("relatorios", relatorioService.findAll());
        return "relatorio";
    }
}