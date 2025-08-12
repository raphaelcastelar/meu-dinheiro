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
import br.edu.iff.meu_dinheiro.entities.expenses;
import br.edu.iff.meu_dinheiro.service.ExpensesService;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {

    private final ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping
    public String listExpenses(Model model) {
        List<expenses> expenses = expensesService.findAll();
        model.addAttribute("expenses", expenses);
        return "expenses/list";
    }

    @GetMapping("/new")
    public String showNewExpenseForm(Model model) {
        model.addAttribute("expense", new expenses());
        return "expenses/form";
    }

    @PostMapping
    public String saveExpense(@Validated @ModelAttribute("expense") expenses expense, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "expenses/form";
        }
        expensesService.save(expense);
        return "redirect:/expenses";
    }


    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id) {
        expensesService.deleteById(id);
        return "redirect:/expenses";
    }
}