package com.bytesMenu.service;

import com.bytesMenu.entity.Prato;
import com.bytesMenu.repository.PratoRepository;
import com.bytesMenu.dto.PratoRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PratoService {

    private final PratoRepository pratoRepository;

    public Prato criar(Prato dto) {
        Prato prato = new Prato();
        prato.setNome(dto.getNome());
        prato.setDescricao(dto.getDescricao());
        prato.setPreco(dto.getPreco());
        prato.setDisponivel(dto.getDisponivel() != null ? dto.getDisponivel() : true);

        return pratoRepository.save(prato);
    }

    public List<Prato> listarTodos() {
        return pratoRepository.findAll();
    }

    public Prato buscarPorId(Long id) {
        return pratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prato não encontrado com id: " + id));
    }

    public Prato atualizar(Long id, Prato dto) {
        Prato prato = buscarPorId(id);

        prato.setNome(dto.getNome());
        prato.setDescricao(dto.getDescricao());
        prato.setPreco(dto.getPreco());
        prato.setDisponivel(dto.getDisponivel() != null ? dto.getDisponivel() : prato.getDisponivel());

        return pratoRepository.save(prato);
    }

    public void deletar(Long id) {
        if (!pratoRepository.existsById(id)) {
            throw new RuntimeException("Prato não encontrado com id: " + id);
        }
        pratoRepository.deleteById(id);
    }
}
