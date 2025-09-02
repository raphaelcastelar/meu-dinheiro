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
@RequestMapping("/despesa")
public class DespesaController {
    private final DespesaService despesaService;

    public DespesaController(DespesaService despesaService) {
        this.despesaService = despesaService;
    }

    @GetMapping
    public String listExpenses(@RequestParam(required = false) String nome, Model model) {
        model.addAttribute("pageTitle", "Despesas");
        model.addAttribute("userName", nome != null ? nome : "João");
        model.addAttribute("item", new Despesa()); // Usando "item" como nome do atributo
        model.addAttribute("despesa", despesaService.findAll());
        return "despesa";
    }

    @GetMapping("/new")
    public String showNewExpenseForm(@RequestParam(required = false) String nome, Model model) {
        model.addAttribute("pageTitle", "Nova Despesa");
        model.addAttribute("userName", nome != null ? nome : "João");
        model.addAttribute("item", new Despesa()); // Usando "item" como nome do atributo
        return "despesa";
    }

    @PostMapping
    public String saveExpense(@Validated @ModelAttribute("item") Despesa item, BindingResult result, @RequestParam(required = false) String nome, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("userName", nome != null ? nome : "João");
            model.addAttribute("despesa", despesaService.findAll());
            return "despesa"; // Retorna para a mesma página com erros
        }
        despesaService.save(item);
        return "redirect:/despesa?nome=" + (nome != null ? nome : "João");
    }

    @GetMapping("/delete/{id}")
    public String deleteExpense(@PathVariable Long id, @RequestParam(required = false) String nome) {
        despesaService.deleteById(id);
        return "redirect:/despesa?nome=" + (nome != null ? nome : "João");
    }
}