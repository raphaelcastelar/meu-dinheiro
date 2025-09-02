package br.edu.iff.meu_dinheiro.service;

import br.edu.iff.meu_dinheiro.entities.Usuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    private List<Usuario> usuarios = new ArrayList<>();
    private Long nextId = 1L;

    public UsuarioService() {
        // Dados mockados
        usuarios.add(new Usuario(1L, "Raphael", "USUARIO"));
        usuarios.add(new Usuario(2L, "João Pedro", "ADMIN"));
    }

    public List<Usuario> findAll() { return new ArrayList<>(usuarios); }
    public void save(Usuario usuario) {
        if (usuario.getId() == null) {
            usuario.setId(nextId++);
            usuarios.add(usuario);
        }
    }
}