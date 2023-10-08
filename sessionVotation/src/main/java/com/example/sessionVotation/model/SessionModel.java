package com.example.sessionVotation.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_SESSION")
public class SessionModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idAssociado;
    @ValidVote
    private String voto;
    private String pauta;


    //Getters and Setters


    public UUID getIdAssociado() {
        return idAssociado;
    }

    public void setIdAssociado(UUID idAssociado) {
        this.idAssociado = idAssociado;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }
}
