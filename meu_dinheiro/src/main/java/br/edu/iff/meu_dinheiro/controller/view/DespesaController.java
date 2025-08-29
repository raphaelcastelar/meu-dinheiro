package br.edu.iff.meu_dinheiro.controller.view;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.validation.annotation.Validated;

import br.edu.iff.meu_dinheiro.entities.Despesa;
import br.edu.iff.meu_dinheiro.service.DespesaService;

@Controller
@RequestMapping("/expenses")
public class DespesaController {

    private final DespesaService expensesService;

    public DespesaController(DespesaService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping
    public String listExpenses(Model model) {
        List<Despesa> expenses = expensesService.findAll(); // ✅ usa instância injetada
        model.addAttribute("expenses", expenses);
        return "expenses/list";
    }

    @GetMapping("/new")
    public String showNewExpenseForm(Model model) {
        model.addAttribute("expense", new Despesa());
        return "expenses/form";
    }

    @PostMapping
    public String saveExpense(@Validated @ModelAttribute("expense") Despesa expense,
                              BindingResult result,
                              Model model) {
        if (result.hasErrors()) {
            return "expenses/form";
        }
        expensesService.save(expense); // ✅ usa instância injetada
        return "redirect:/expenses";
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expensesService.deleteById(id);
        return "redirect:/expenses";
    }
}
