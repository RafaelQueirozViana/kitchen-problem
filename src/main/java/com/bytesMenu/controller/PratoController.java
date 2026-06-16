package com.bytesMenu.controller;

import com.bytesMenu.dto.PratoRequestDTO;
import com.bytesMenu.entity.Prato;
import com.bytesMenu.service.PratoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pratos")
@RequiredArgsConstructor
public class PratoController {

    private final PratoService pratoService;

    @PostMapping
    public ResponseEntity<Prato> criar(@RequestBody PratoRequestDTO dto) {

        Prato prato = pratoService.criar(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(prato);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<Prato>> listarTodos() {

        return ResponseEntity.ok(
                pratoService.listarTodos()
        );
    }

    @GetMapping("/disponiveis")
    public ResponseEntity<List<Prato>> listarDisponiveis() {

        return ResponseEntity.ok(
                pratoService.listarDisponiveis()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prato> buscarPorId(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                pratoService.buscarPorId(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prato> atualizar(
            @PathVariable Long id,
            @RequestBody PratoRequestDTO dto) {

        return ResponseEntity.ok(
                pratoService.atualizar(id, dto)
        );
    }

    @PatchMapping("/{id}/disponivel")
    public ResponseEntity<Prato> alterarDisponibilidade(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                pratoService.alterarDisponibilidade(id)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(
            @PathVariable Long id) {

        pratoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}