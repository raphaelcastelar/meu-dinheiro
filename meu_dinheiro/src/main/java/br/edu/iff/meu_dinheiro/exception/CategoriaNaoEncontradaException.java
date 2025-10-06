package br.edu.iff.meu_dinheiro.exception;

public class CategoriaNaoEncontradaException extends RecursoNaoEncontradoException {

    private static final long serialVersionUID = 1L;

    public CategoriaNaoEncontradaException(Long id) {
        super("Categoria", id);
    }

    public CategoriaNaoEncontradaException(Long id, Throwable cause) {
        super("Categoria", id, cause);
    }
}