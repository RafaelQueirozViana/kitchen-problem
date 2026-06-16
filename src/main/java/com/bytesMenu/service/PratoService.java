package com.bytesMenu.service;

import com.bytesMenu.dto.PratoRequestDTO;
import com.bytesMenu.entity.Prato;
import com.bytesMenu.repository.PratoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PratoService {

    private final PratoRepository pratoRepository;

    public Prato criar(PratoRequestDTO dto) {

        Prato prato = new Prato();

        prato.setNome(dto.getName());
        prato.setDescricao(dto.getDescription());
        prato.setPreco(dto.getPrice());
        prato.setDisponivel(dto.getAvailable());

        return pratoRepository.save(prato);
    }

    public List<Prato> listarTodos() {
        return pratoRepository.findAll();
    }

    public List<Prato> listarDisponiveis() {
        return pratoRepository.findByDisponivelTrue();
    }

    public Prato buscarPorId(Long id) {

        return pratoRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Prato não encontrado com id: " + id));
    }

    public Prato atualizar(Long id, PratoRequestDTO dto) {

        Prato prato = buscarPorId(id);

        prato.setNome(dto.getName());
        prato.setDescricao(dto.getDescription());
        prato.setPreco(dto.getPrice());
        prato.setDisponivel(dto.getAvailable());

        return pratoRepository.save(prato);
    }

    public Prato alterarDisponibilidade(Long id) {

        Prato prato = buscarPorId(id);

        prato.setDisponivel(!prato.getDisponivel());

        return pratoRepository.save(prato);
    }

    public void deletar(Long id) {

        if (!pratoRepository.existsById(id)) {
            throw new RuntimeException("Prato não encontrado com id: " + id);
        }

        pratoRepository.deleteById(id);
    }
}