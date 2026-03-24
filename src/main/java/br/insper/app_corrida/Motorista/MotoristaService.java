package br.insper.app_corrida.Motorista;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class MotoristaService {

    private HashMap<String, Motorista> motoristas = new HashMap<>();

    public Motorista criarMotorista(Motorista motorista) {
        if (motorista.getPlacaCarro() == null || motorista.getCpf() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        motorista.setId(UUID.randomUUID().toString());
        motorista.setAtivo(true);
        motoristas.put(motorista.getId(), motorista);
        return motorista;
    }

    public Collection<Motorista> listarMotorista() {
        // checa se o motorista não esta deletado
        return motoristas.values().stream().filter(Motorista::isAtivo).toList();
    }

    public Motorista getMotorista(String id) {
        Motorista motorista = motoristas.get(id);
        if (motorista == null || !motorista.isAtivo()) {
            throw new RuntimeException("Motorista invalido");
        }
        return motorista;
    }

    public Motorista editarMotorista(String id, Motorista m) {
        Motorista motorista = motoristas.get(id);
        motorista.setPlacaCarro(m.getPlacaCarro());
        motorista.setCpf(m.getCpf());
        motorista.setNome(m.getNome());
        motorista.setEmail(m.getEmail());
        return motorista;
    }

    public void deletarMotorista(String id) {
        Motorista motorista = motoristas.get(id);
        motorista.setAtivo(false);
    }

}
