package com.senac.doacao.controller;

import com.senac.doacao.dto.doacao.DoacaoRequestDTO;
import com.senac.doacao.dto.doacao.DoacaoResponseDTO;
import com.senac.doacao.service.DoacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/doacoes")
@CrossOrigin("*")
public class DoacaoController {

    private final DoacaoService doacaoService;

    public DoacaoController(DoacaoService doacaoService) {
        this.doacaoService = doacaoService;
    }

    @PostMapping("/criar")
    public ResponseEntity<DoacaoResponseDTO> criarDoacao(@RequestBody DoacaoRequestDTO requestDTO) {
        DoacaoResponseDTO response = doacaoService.criarDoacao(requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/obterdoacoesdousuarioporid/{doadorId}")
    public ResponseEntity<List<DoacaoResponseDTO>> obterDoacoesDoUsuario(@PathVariable int doadorId) {
        List<DoacaoResponseDTO> doacoes = doacaoService.listarDoacoesPorDoador(doadorId);
        return ResponseEntity.ok(doacoes);
    }
}