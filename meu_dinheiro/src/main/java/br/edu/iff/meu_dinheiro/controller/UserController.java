package br.edu.iff.meu_dinheiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    
    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        return "user/dashboard";
    }
    
    @GetMapping("/receipts")
    public String showReceipts(Model model) {
        return "user/receipts";
    }
    
    @GetMapping("/expenses")
    public String showExpenses(Model model) {
        return "user/expenses";
    }
    
    @GetMapping("/categories")
    public String showCategories(Model model) {
        return "user/categories";
    }
}