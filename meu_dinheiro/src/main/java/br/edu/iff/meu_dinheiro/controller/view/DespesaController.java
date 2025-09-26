package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.edu.iff.meu_dinheiro.entities.Despesa;
import br.edu.iff.meu_dinheiro.repository.DespesaRepository;

@Controller
@RequestMapping("/user/despesa")
public class DespesaController {

    private final DespesaRepository despesaRepository;

    @Autowired
    public DespesaController(DespesaRepository despesaRepository) {
        this.despesaRepository = despesaRepository;
    }

    @GetMapping
    public String showDespesasPage(Model model) {
        model.addAttribute("despesas", despesaRepository.findAll());
        model.addAttribute("newDespesa", new Despesa());
        return "despesa";
    }

    @GetMapping(params = "data")
    public String updateMonth(@RequestParam String data, Model model) {
        Despesa monthlyDespesa = despesaRepository.findByDataAndDescricao(data, null); // Ajuste conforme necessário
        model.addAttribute("monthlyDespesa", monthlyDespesa != null ? monthlyDespesa : new Despesa());
        model.addAttribute("despesas", despesaRepository.findAll());
        model.addAttribute("newDespesa", new Despesa());
        return "despesa";
    }
}