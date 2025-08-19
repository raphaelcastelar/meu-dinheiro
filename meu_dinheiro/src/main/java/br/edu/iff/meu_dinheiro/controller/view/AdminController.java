package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping(path = "/admin")
public class AdminController {
    
    @GetMapping("/dashboard")
    public String showAdminDashboard(Model model) {
        return "dashboardAdmin.html";
    }
    
    @GetMapping("/manage-users")
    public String manageUsers(Model model) {
        return "manage_users.html";
    }
    
    @GetMapping("/reports")
    public String showReports(Model model) {
        return "reports.html";
    }
}