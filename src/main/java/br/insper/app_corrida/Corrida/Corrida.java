package br.insper.app_corrida.Corrida;

import br.insper.app_corrida.Motorista.Motorista;
import br.insper.app_corrida.Usuario.Usuario;

import java.time.LocalDateTime;

public class Corrida {

    private String id;
    private LocalDateTime data; // escolhi fazer com LocalDateTime
    private Usuario usuario;
    private Motorista motorista;
    private boolean ativo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

}
