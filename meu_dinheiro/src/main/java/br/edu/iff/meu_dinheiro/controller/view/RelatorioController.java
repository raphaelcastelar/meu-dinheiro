package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.meu_dinheiro.entities.Relatorio;
import br.edu.iff.meu_dinheiro.repository.RelatorioRepository;

@Controller
@RequestMapping("/user/relatorio")
public class RelatorioController {

    private final RelatorioRepository relatorioRepository;

    @Autowired
    public RelatorioController(RelatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    @GetMapping
    public String showRelatorioPage(Model model) {
        model.addAttribute("relatorios", relatorioRepository.findAll());
        model.addAttribute("newRelatorio", new Relatorio());
        model.addAttribute("monthlyReport", new Relatorio()); // Para o resumo original, se necessário
        return "relatorio";
    }

    @GetMapping(params = "mesAno")
    public String updateMonth(@RequestParam String mesAno, Model model) {
        Relatorio monthlyReport = relatorioRepository.findByMesAno(mesAno);
        model.addAttribute("monthlyReport", monthlyReport != null ? monthlyReport : new Relatorio());
        model.addAttribute("relatorios", relatorioRepository.findAll());
        model.addAttribute("newRelatorio", new Relatorio());
        return "relatorio";
    }
}