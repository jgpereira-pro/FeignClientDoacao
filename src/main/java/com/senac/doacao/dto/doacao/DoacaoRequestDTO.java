package com.senac.doacao.dto.doacao;

import com.senac.doacao.dto.doador.DoadorRequestDTO;

public class DoacaoRequestDTO {
    private int valor;
    private DoadorRequestDTO doador;

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public DoadorRequestDTO getDoador() {
        return doador;
    }

    public void setDoador(DoadorRequestDTO doador) {
        this.doador = doador;
    }
}
