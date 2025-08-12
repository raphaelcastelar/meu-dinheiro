package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.ui.Model;




@Controller
@RequestMapping(path = "/principal")
public class MainViewController {
    
    @GetMapping("/{id}")
    public String getHomePage(@PathVariable("id") String id,@RequestParam ("nome") String nome, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("nome", nome);
        model.addAttribute("saldo", 100.00);
        model.addAttribute("gastos", 400.00);
        model.addAttribute("metaEconomia", 500.00);
        
        return "index.html";
    }}
    

