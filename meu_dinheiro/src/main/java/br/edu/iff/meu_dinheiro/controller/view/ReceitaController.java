package br.edu.iff.meu_dinheiro.controller.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import br.edu.iff.meu_dinheiro.entities.Receita;
import br.edu.iff.meu_dinheiro.service.ReceitaService;

@Controller
@RequestMapping("/receita")
public class ReceitaController {

    private final ReceitaService receitaService;

    public ReceitaController(ReceitaService receitaService) {
        this.receitaService = receitaService;
    }

    @GetMapping
    public String listReceipts(@RequestParam(required = false) String nome, Model model) {
        List<Receita> receitas = receitaService.findAll();
        model.addAttribute("pageTitle", "Receitas");
        model.addAttribute("receitas", receitas);
        model.addAttribute("userName", nome != null ? nome : "Usuário");
        return "receita";
    }

    @GetMapping("/delete/{id}")
    public String deleteReceipt(@PathVariable Long id, @RequestParam(required = false) String nome) {
        receitaService.deleteById(id);
        return "redirect:/receitas?nome=" + (nome != null ? nome : "Usuário");
    }

    @PostMapping("/user/receita/update-table")
    public String updateTable(@RequestBody Map<String, Object> payload, Model model) {
        @SuppressWarnings("unchecked")
        List<Map<String, Object>> items = (List<Map<String, Object>>) payload.get("tableItems");
        model.addAttribute("tableRoutePrefix", "receitas");
        model.addAttribute("tableItems", items != null ? items : Collections.emptyList());
        return "receita :: .table-section";
    }
}