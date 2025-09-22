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

import br.edu.iff.meu_dinheiro.entities.Relatorio;
import br.edu.iff.meu_dinheiro.repository.relatorioRepository;

@RestController
@RequestMapping("/api/v1/relatorio")
public class RestApiRelatorioController {

    private final relatorioRepository relatorioRepository;

    @Autowired
    public RestApiRelatorioController(relatorioRepository relatorioRepository) {
        this.relatorioRepository = relatorioRepository;
    }

    @PostMapping
    public ResponseEntity<Relatorio> createRelatorio(@RequestBody Relatorio relatorio) {
        if (relatorio.getMesAno() == null || !relatorio.getMesAno().matches("\\d{4}-\\d{2}")) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Relatorio savedRelatorio = relatorioRepository.save(relatorio);
        return new ResponseEntity<>(savedRelatorio, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Iterable<Relatorio>> getAllRelatorios() {
        Iterable<Relatorio> relatorios = relatorioRepository.findAll();
        return new ResponseEntity<>(relatorios, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Relatorio> updateRelatorio(@PathVariable Long id, @RequestBody Relatorio relatorioDetails) {
        if (relatorioRepository.existsById(id)) {
            relatorioDetails.setId(id);
            Relatorio updatedRelatorio = relatorioRepository.save(relatorioDetails);
            return new ResponseEntity<>(updatedRelatorio, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelatorio(@PathVariable Long id) {
        if (relatorioRepository.existsById(id)) {
            relatorioRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}