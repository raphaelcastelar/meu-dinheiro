package br.edu.iff.meu_dinheiro.controller.view;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.iff.meu_dinheiro.service.RelatorioService;
import br.edu.iff.meu_dinheiro.entities.MonthlyReport;

@Controller
@RequestMapping("/relatorio")
public class RelatorioController {

    private final RelatorioService relatorioService;

    //@Autowired
    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping
    public String showReport(@RequestParam(required = false) String mesAno, Model model) {
        MonthlyReport monthlyReport = relatorioService.generateReport(mesAno != null ? mesAno : 
                java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM")));
        if (monthlyReport == null) {
            monthlyReport = new MonthlyReport(); // Fallback
            monthlyReport.setMesAno(java.time.LocalDate.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM")));
            monthlyReport.setTotalReceitas(0.0);
            monthlyReport.setTotalDespesas(0.0);
            monthlyReport.setSaldo(0.0);
        }
        System.out.println("MonthlyReport: " + monthlyReport); // Depuração
        model.addAttribute("pageTitle", "Relatório");
        model.addAttribute("monthlyReport", monthlyReport);
        return "relatorio";
    }
}