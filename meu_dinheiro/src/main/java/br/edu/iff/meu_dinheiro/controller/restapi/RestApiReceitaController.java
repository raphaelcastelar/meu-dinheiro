package br.edu.iff.meu_dinheiro.controller.restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.iff.meu_dinheiro.entities.Receita;
import br.edu.iff.meu_dinheiro.repository.ReceitaRepository;
import br.edu.iff.meu_dinheiro.service.RelatorioService;

@RestController
@RequestMapping("/api/v1/receita")
public class RestApiReceitaController {

    private final ReceitaRepository receitaRepository;
    private final RelatorioService relatorioService;

    @Autowired
    public RestApiReceitaController(ReceitaRepository receitaRepository, RelatorioService relatorioService) {
        this.receitaRepository = receitaRepository;
        this.relatorioService = relatorioService;
    }

    @PostMapping
    public ResponseEntity<Receita> createReceita(@RequestBody Receita receita) {
        if (receita.getData() == null || !receita.getData().matches("\\d{4}-\\d{2}") || receita.getDescricao() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Receita savedReceita = receitaRepository.save(receita);
        relatorioService.atualizarAposAdicionarReceita(savedReceita);
        return new ResponseEntity<>(savedReceita, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Receita>> getAllReceitas() {
        return new ResponseEntity<>(receitaRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> updateReceita(@PathVariable Long id, @RequestBody Receita receitaDetails) {
        return receitaRepository.findById(id)
                .map(receita -> {
                    if (receitaDetails.getDescricao() != null && !receitaDetails.getDescricao().isEmpty()) {
                        receita.setDescricao(receitaDetails.getDescricao());
                    }
                    receita.setValor(receitaDetails.getValor());
                    if (receitaDetails.getData() != null && receitaDetails.getData().matches("\\d{4}-\\d{2}")) {
                        receita.setData(receitaDetails.getData());
                    }
                    Receita updatedReceita = receitaRepository.save(receita);
                    relatorioService.atualizarRelatorioDoMes(updatedReceita.getData()); // Atualiza relatório
                    return new ResponseEntity<>(updatedReceita, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReceita(@PathVariable Long id) {
        if (receitaRepository.existsById(id)) {
            Receita receita = receitaRepository.findById(id).get();
            receitaRepository.deleteById(id);
            relatorioService.atualizarRelatorioDoMes(receita.getData()); // Atualiza relatório
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}