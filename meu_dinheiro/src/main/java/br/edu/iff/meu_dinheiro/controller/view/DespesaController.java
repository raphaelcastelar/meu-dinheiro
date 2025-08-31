package br.edu.iff.meu_dinheiro.controller.view;

import br.edu.iff.meu_dinheiro.entities.Despesa;
import br.edu.iff.meu_dinheiro.service.DespesaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/expenses")
public class DespesaController {
    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @GetMapping
    public String listExpenses(@RequestParam(required = false) String nome, Model model) {
        model.addAttribute("pageTitle", "Despesas");
        model.addAttribute("expenses", despesaService.findAll());
        model.addAttribute("userName", nome != null ? nome : "Usuário");
        return "despesa";
    }

    @GetMapping("/new")
    public String showNewExpenseForm(@RequestParam(required = false) String nome, Model model) {
        model.addAttribute("pageTitle", "Nova Despesa");
        model.addAttribute("expense", new Despesa());
        model.addAttribute("userName", nome != null ? nome : "Usuário");
        return "despesa";
    }

    @PostMapping
    public String saveExpense(@Validated @ModelAttribute("expense") Despesa expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "despesa";
        }
        despesaService.save(expense);
        return "redirect:/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id, @RequestParam(required = false) String nome) {
        despesaService.deleteById(id);
        return "redirect:/expenses?nome=" + (nome != null ? nome : "Usuário");
    }
}