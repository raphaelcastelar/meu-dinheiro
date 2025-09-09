package br.edu.iff.meu_dinheiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiGlobalAdviceException {

    @ExceptionHandler(RelatorioNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public String handleRelatorioNaoEncontradoException(RelatorioNaoEncontradoException ex) {
        return ex.getMessage(); // Retorna a mensagem da exceção, ex.: "Relatório para o período 2025-08 não foi encontrado."
    }

    // Outros handlers de exceção podem ser adicionados aqui
}