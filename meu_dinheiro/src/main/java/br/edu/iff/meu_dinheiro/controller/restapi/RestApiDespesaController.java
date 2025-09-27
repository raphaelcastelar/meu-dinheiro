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

import br.edu.iff.meu_dinheiro.entities.Despesa;
import br.edu.iff.meu_dinheiro.repository.DespesaRepository;
import br.edu.iff.meu_dinheiro.service.RelatorioService;

@RestController
@RequestMapping("/api/v1/despesa")
public class RestApiDespesaController {

    private final DespesaRepository despesaRepository;
    private final RelatorioService relatorioService;

    @Autowired
    public RestApiDespesaController(DespesaRepository despesasRepository, RelatorioService relatorioService) {
        this.despesaRepository = despesasRepository;
        this.relatorioService = relatorioService;
    }

    @PostMapping
    public ResponseEntity<Despesa> createDespesa(@RequestBody Despesa despesa) {
        if (despesa.getData() == null || !despesa.getData().matches("\\d{4}-\\d{2}") || despesa.getDescricao() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Despesa savedDespesa = despesaRepository.save(despesa);
        relatorioService.atualizarAposAdicionarDespesa(savedDespesa); // Atualiza relatório
        return new ResponseEntity<>(savedDespesa, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Despesa>> getAllDespesas() {
        return new ResponseEntity<>(despesaRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> updateDespesa(@PathVariable Long id, @RequestBody Despesa despesaDetails) {
        return despesaRepository.findById(id)
                .map(despesa -> {
                    if (despesaDetails.getDescricao() != null && !despesaDetails.getDescricao().isEmpty()) {
                        despesa.setDescricao(despesaDetails.getDescricao());
                    }
                    despesa.setValor(despesaDetails.getValor());
                    if (despesaDetails.getData() != null && despesaDetails.getData().matches("\\d{4}-\\d{2}")) {
                        despesa.setData(despesaDetails.getData());
                    }
                    return new ResponseEntity<>(despesaRepository.save(despesa), HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespesa(@PathVariable Long id) {
        if (despesaRepository.existsById(id)) {
            despesaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}