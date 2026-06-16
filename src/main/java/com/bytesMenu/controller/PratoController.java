package com.bytesMenu.controller;

import com.bytesMenu.entity.Prato;
import com.bytesMenu.dto.PratoRequestDTO;
import com.bytesMenu.service.PratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apipratos")
public class PratoController {

    @Autowired
    private PratoService pratoService;

    @PostMapping
    public ResponseEntity<Prato> criar(Prato dto) {
        Prato prato = pratoService.criar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(prato);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Prato>> listarTodos() {
        return ResponseEntity.ok(pratoService.listarTodos());
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Prato>> listarDisponiveis() {
        return ResponseEntity.ok(pratoService.listarTodos());
    }

    @GetMapping("/{id")
    public ResponseEntity<Prato> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pratoService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prato> atualizar(@PathVariable Long id, @RequestBody Prato prato) {
        return ResponseEntity.ok(pratoService.atualizar(id, prato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prato> deletar(@PathVariable Long id) {
        pratoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
