package com.senac.doacao.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "doacao")
public class Doacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "doador_id", nullable = false)
    private int doadorId;

    @Column(name = "valor_doacao", nullable = false)
    private int valor;

    @Column(nullable = false)
    private int status;

    @Column(name = "data_doacao")
    private LocalDate dataDoacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDoadorId() {
        return doadorId;
    }

    public void setDoadorId(int doadorId) {
        this.doadorId = doadorId;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDate getDataDoacao() {
        return dataDoacao;
    }

    public void setDataDoacao(LocalDate dataDoacao) {
        this.dataDoacao = dataDoacao;
    }
}
