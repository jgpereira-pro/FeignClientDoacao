package com.senac.doacao.service;

import com.senac.doacao.client.DoadorClient;
import com.senac.doacao.dto.doacao.DoacaoRequestDTO;
import com.senac.doacao.dto.doacao.DoacaoResponseDTO;
import com.senac.doacao.dto.doador.DoadorResponseDTO;
import com.senac.doacao.entity.Doacao;
import com.senac.doacao.repository.DoacaoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoacaoService {

    private final DoacaoRepository doacaoRepository;
    private final DoadorClient doadorClient;

    public DoacaoService(DoacaoRepository doacaoRepository, DoadorClient doadorClient) {
        this.doacaoRepository = doacaoRepository;
        this.doadorClient = doadorClient;
    }

    public DoacaoResponseDTO criarDoacao(DoacaoRequestDTO requestDTO) {
        DoadorResponseDTO doadorResponse = doadorClient.cadastrarDoador(requestDTO.getDoador());

        Doacao doacao = new Doacao();
        doacao.setValor(requestDTO.getValor());
        doacao.setDataDoacao(LocalDate.now());
        doacao.setDoadorId(doadorResponse.getId());
        doacao.setStatus(1);

        Doacao doacaoSalva = doacaoRepository.save(doacao);

        return converterParaResponseDTO(doacaoSalva);
    }

    public List<DoacaoResponseDTO> listarDoacoesPorDoador(int doadorId) {
        List<Doacao> doacoes = doacaoRepository.findByDoadorId(doadorId);

        // Mapeamento manual da lista
        return doacoes.stream()
                .map(this::converterParaResponseDTO)
                .collect(Collectors.toList());
    }

    // Método auxiliar para conversão manual
    private DoacaoResponseDTO converterParaResponseDTO(Doacao doacao) {
        DoacaoResponseDTO dto = new DoacaoResponseDTO();
        dto.setId(doacao.getId());
        dto.setValor(doacao.getValor());
        dto.setData(doacao.getDataDoacao());
        dto.setDoadorId(doacao.getDoadorId());
        return dto;
    }
}