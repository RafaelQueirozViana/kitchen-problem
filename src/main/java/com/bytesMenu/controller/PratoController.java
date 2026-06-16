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

    // Endpoint que o frontend chama ao carregar a página
    @GetMapping
    public ResponseEntity<List<Prato>> listarTodos() {
        return ResponseEntity.ok(pratoService.listarTodos());
    }

    // Cardápio público
    @GetMapping("/disponiveis")
    public ResponseEntity<List<Prato>> listarDisponiveis() {
        return ResponseEntity.ok(pratoService.listarDisponiveis());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Prato> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pratoService.buscarPorId(id));
    }

    // Criar prato
    @PostMapping
    public ResponseEntity<Prato> criar(@RequestBody PratoRequestDTO dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(pratoService.criar(dto));
    }

    // Atualizar prato
    @PutMapping("/{id}")
    public ResponseEntity<Prato> atualizar(
            @PathVariable Long id,
            @RequestBody PratoRequestDTO dto) {

        return ResponseEntity.ok(
                pratoService.atualizar(id, dto)
        );
    }

    // Alternar disponível/indisponível
    @PatchMapping("/{id}/disponivel")
    public ResponseEntity<Prato> alterarDisponibilidade(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                pratoService.alterarDisponibilidade(id)
        );
    }

    // Deletar prato
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {

        pratoService.deletar(id);

        return ResponseEntity.noContent().build();
    }
}