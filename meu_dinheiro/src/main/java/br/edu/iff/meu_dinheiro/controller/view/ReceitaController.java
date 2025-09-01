package br.edu.iff.meu_dinheiro.controller.view;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String listReceipts(@RequestParam(required = false) String nome, @RequestParam(required = false) Long userId, 
                              @RequestParam(required = false) Boolean isAdmin, Model model) {
        List<Receita> receitas = receitaService.findAll();
        model.addAttribute("pageTitle", "Receitas");
        model.addAttribute("receitas", receitas);
        model.addAttribute("userName", nome != null ? nome : "Usuário");
        model.addAttribute("userId", userId != null ? userId : 0L); // Valor padrão, ajuste conforme necessário
        model.addAttribute("isAdmin", isAdmin != null ? isAdmin : false); // Valor padrão
        return "receita";
    }

    @GetMapping("/excluir/{id}")
    public String deleteReceipt(@PathVariable Long id, @RequestParam(required = false) String nome, 
                               @RequestParam(required = false) Long userId, @RequestParam(required = false) Boolean isAdmin) {
        receitaService.deleteById(id);
        return "redirect:/receitas?nome=" + (nome != null ? nome : "Usuário") + 
               "&userId=" + (userId != null ? userId : 0) + 
               "&isAdmin=" + (isAdmin != null ? isAdmin : false);
    }
}