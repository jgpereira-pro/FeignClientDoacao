package com.senac.doacao.dto.doacao;

import java.time.LocalDate;

public class DoacaoResponseDTO {
    private int id;
    private int valor;
    private LocalDate data;
    private int doadorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getDoadorId() {
        return doadorId;
    }

    public void setDoadorId(int doadorId) {
        this.doadorId = doadorId;
    }
}
