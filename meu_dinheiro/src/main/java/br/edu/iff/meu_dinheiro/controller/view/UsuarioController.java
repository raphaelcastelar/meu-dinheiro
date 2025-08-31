package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/user")
public class UsuarioController {
    
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        return "dashboard.html";
    }
    
    @GetMapping("/receita")
    public String showReceipts(Model model) {
        return "receita.html";
    }
    
    @GetMapping("/despesa")
    public String showExpenses(Model model) {
        return "despesa.html";
    }
    
    @GetMapping("/categoria")
    public String showCategories(Model model) {
        return "categoria.html";
    }
}