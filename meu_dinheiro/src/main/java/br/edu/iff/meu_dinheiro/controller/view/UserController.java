package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        return "dashboard.html";
    }
    
    @GetMapping("/receipts")
    public String showReceipts(Model model) {
        return "receipts.html";
    }
    
    @GetMapping("/expenses")
    public String showExpenses(Model model) {
        return "expenses.html";
    }
    
    @GetMapping("/categories")
    public String showCategories(Model model) {
        return "categories.html";
    }
}