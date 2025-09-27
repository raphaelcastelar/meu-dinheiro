package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.meu_dinheiro.entities.Receita;
import br.edu.iff.meu_dinheiro.repository.ReceitaRepository;

@Controller
@RequestMapping("/user/receita")
public class ReceitaController {

    private final ReceitaRepository receitaRepository;

    @Autowired
    public ReceitaController(ReceitaRepository receitasRepository) {
        this.receitaRepository = receitasRepository;
    }

    @GetMapping
    public String showReceitasPage(Model model) {
        model.addAttribute("receitas", receitaRepository.findAll());
        model.addAttribute("newReceita", new Receita());
        return "receita";
    }

    @GetMapping(params = "data")
    public String updateMonth(@RequestParam String data, Model model) {
        Receita monthlyReceita = receitaRepository.findByDataAndDescricao(data, null); // Ajuste conforme necessário
        model.addAttribute("monthlyReceita", monthlyReceita != null ? monthlyReceita : new Receita());
        model.addAttribute("receitas", receitaRepository.findAll());
        model.addAttribute("newReceita", new Receita());
        return "receita";
    }
}