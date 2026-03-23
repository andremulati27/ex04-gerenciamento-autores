package com.pm.gerenciamento_autores.controllers;

import com.pm.gerenciamento_autores.models.AutoresModel;
import com.pm.gerenciamento_autores.services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autor")
public class AutoresController {

    @Autowired
    private AutoresService autoresService;

    @GetMapping
    public ResponseEntity<List<AutoresModel>> findAll() {
        List<AutoresModel> autoresModels = autoresService.findAll();
        return ResponseEntity.status(200).body(autoresModels);
    }

    @PostMapping
    public ResponseEntity<AutoresModel> criarAutor(@RequestBody AutoresModel autoresModel) {
        AutoresModel autoresModel1 = autoresService.criarAutor(autoresModel);
        return ResponseEntity.status(201).body(autoresModel1);
    }

    @GetMapping("/{id}")
    public ResponseEntity <Optional<AutoresModel>> findById(@PathVariable Long id) {
        Optional<AutoresModel> model = autoresService.buscarId(id);

        return ResponseEntity.status(200).body(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutoresModel> atualizarAutor(@PathVariable Long id, @RequestBody AutoresModel autoresModel) {
        AutoresModel model = autoresService.atualizarAutor(id, autoresModel);
        return ResponseEntity.status(200).body(model);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAutor(@PathVariable Long id) {
        autoresService.deletarAutor(id);
        return ResponseEntity.status(204).build();
    }
}
