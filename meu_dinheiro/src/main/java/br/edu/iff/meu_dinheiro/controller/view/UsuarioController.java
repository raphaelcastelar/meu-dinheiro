package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/user")
public class UsuarioController {

    //@GetMapping("/receita")
    //public String showReceipts(Model model) {
        //return "receita"; // Retorna receita.html
    //}

    //@GetMapping("/despesa")
    //public String showExpenses(Model model) {
        //return "despesa"; // Retorna despesa.html
    //}

    @GetMapping("/categoria")
    public String showCategories(Model model) {
        return "categoria"; // Retorna categoria.html
    }

    // Opcional: Redirecionar /user/relatorio para o RelatorioController
    //@GetMapping("/relatorio")
    //public String redirectToRelatorio() {
        //return "redirect:/user/relatorio"; // Redireciona para o RelatorioController
    //}
}