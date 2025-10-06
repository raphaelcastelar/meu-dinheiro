package br.edu.iff.meu_dinheiro.exception;

public class RecursoNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RecursoNaoEncontradoException(String resourceName, Long id) {
        super(String.format("%s com ID %d não foi encontrado.", resourceName, id));
    }

    public RecursoNaoEncontradoException(String resourceName, Long id, Throwable cause) {
        super(String.format("%s com ID %d não foi encontrado.", resourceName, id), cause);
    }
}