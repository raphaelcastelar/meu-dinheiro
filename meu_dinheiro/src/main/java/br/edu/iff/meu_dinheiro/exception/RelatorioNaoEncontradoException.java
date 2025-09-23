package br.edu.iff.meu_dinheiro.exception;

public class RelatorioNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RelatorioNaoEncontradoException(String mesAno) {
        super("Relatório para o período " + mesAno + " não foi encontrado.");
    }

    public RelatorioNaoEncontradoException(String mesAno, Throwable cause) {
        super("Relatório para o período " + mesAno + " não foi encontrado.", cause);
    }
}