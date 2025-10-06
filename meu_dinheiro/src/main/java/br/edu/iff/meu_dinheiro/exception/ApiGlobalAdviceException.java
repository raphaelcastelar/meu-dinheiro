package br.edu.iff.meu_dinheiro.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ApiGlobalAdviceException {

    @ExceptionHandler(RelatorioNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ProblemDetail handleRelatorioNaoEncontradoException(RelatorioNaoEncontradoException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle("Relatório Não Encontrado");
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ProblemDetail handleRecursoNaoEncontradoException(RecursoNaoEncontradoException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle("Recurso Não Encontrado");
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(RegraDeNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ProblemDetail handleRegraDeNegocioException(RegraDeNegocioException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        problem.setTitle("Violação de Regra de Negócio");
        problem.setDetail(ex.getMessage());
        return problem;
    }

    @ExceptionHandler(CategoriaNaoEncontradaException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ProblemDetail handleCategoriaNaoEncontradaException(CategoriaNaoEncontradaException ex) {
        ProblemDetail problem = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
        problem.setTitle("Categoria Não Encontrada");
        problem.setDetail(ex.getMessage());
        return problem;
}}