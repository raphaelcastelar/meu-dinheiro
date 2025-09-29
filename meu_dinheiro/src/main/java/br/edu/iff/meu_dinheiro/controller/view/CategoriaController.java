package br.edu.iff.meu_dinheiro.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.iff.meu_dinheiro.entities.Categoria;
import br.edu.iff.meu_dinheiro.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping
    public String showCategoriesPage(Model model) {
        model.addAttribute("categorias", categoriaRepository.findAll());
        model.addAttribute("newCategoria", new Categoria()); // Adiciona o objeto para o formulário
        return "categoria"; // Retorna o template categoria.html
    }

    @PostMapping
    public String createCategoria(Categoria categoria, Model model) {
        try {
            if (categoria.getNome() == null || categoria.getNome().isEmpty() || categoria.getTipo() == null) {
                throw new IllegalArgumentException("Nome e tipo são obrigatórios.");
            }
            categoriaRepository.save(categoria); // Persiste a categoria
            return "redirect:/categoria"; // Redireciona para recarregar a página
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("categorias", categoriaRepository.findAll());
            model.addAttribute("newCategoria", new Categoria());
            return "categoria"; // Retorna ao template com mensagem de erro
        }
    }

    @PostMapping("/update/{id}")
    public String updateCategoria(Long id, @ModelAttribute Categoria categoriaDetails) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    if (categoriaDetails.getDescricao() != null) {
                        categoria.setDescricao(categoriaDetails.getDescricao());
                    }
                    if (categoriaDetails.getTipo() != null) {
                        categoria.setTipo(categoriaDetails.getTipo());
                    }
                    categoriaRepository.save(categoria);
                    return "redirect:/categoria"; // Redireciona após a atualização
                })
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
    }

    @PostMapping("/delete/{id}")
    public String deleteCategoria(Long id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
            return "redirect:/categoria"; // Redireciona após a exclusão
        }
        throw new IllegalArgumentException("Categoria não encontrada");
    }
}