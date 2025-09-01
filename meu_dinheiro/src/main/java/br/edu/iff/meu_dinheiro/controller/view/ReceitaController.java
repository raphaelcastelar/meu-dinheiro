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
import br.edu.iff.meu_dinheiro.entities.Receita;
import br.edu.iff.meu_dinheiro.service.ReceitaService;

@Controller
@RequestMapping("/receitas")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @GetMapping
    public String listReceipts(Model model) {
        List<Receita> receitas = receitaService.findAll();
        model.addAttribute("receitas", receitas);
        return "receita";
    }

    @GetMapping("/new")
    public String showNewReceiptForm(Model model) {
        model.addAttribute("receita", new Receita());
        return "receita"; // Reutiliza o mesmo template com formulário embutido
    }

    @PostMapping
    public String saveReceipt(@Validated @ModelAttribute("receita") Receita receita, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("receitas", receitaService.findAll());
            return "receita";
        }
        receitaService.save(receita);
        return "redirect:/receitas";
    }

    @GetMapping("/delete/{id}")
    public String deleteReceipt(@PathVariable Long id) {
        receitaService.deleteById(id); // Método a ser adicionado no ReceitaService
        return "redirect:/receitas";
    }
}
