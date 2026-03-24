package br.insper.app_corrida.Corrida;

import br.insper.app_corrida.Motorista.Motorista;
import br.insper.app_corrida.Motorista.MotoristaService;
import br.insper.app_corrida.Usuario.Usuario;
import br.insper.app_corrida.Usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class CorridaService {

    private HashMap<String, Corrida> corridas = new HashMap<>();

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MotoristaService motoristaService;

    public Corrida criarCorrida(Corrida corrida, String idUsuario) {
        if (corrida.getUsuario() == null || corrida.getMotorista() == null) {
            throw new RuntimeException("Corrida inválida");
        }

        Usuario usuario = usuarioService.getUsuario(idUsuario);
        if (!usuario.isAtivo()) {
            throw new RuntimeException("Usuario inválido");
        } else {
            corrida.setUsuario(usuario);
        }

        Motorista motorista = motoristaService.getMotorista(corrida.getMotorista().getId());
        if (!motorista.isAtivo()) {
            throw new RuntimeException("Motorista inválido");
        } else {
            corrida.setMotorista(motorista);
        }

        corrida.setId(UUID.randomUUID().toString());
        corrida.setData(LocalDateTime.now());
        motorista.setAtivo(true);
        corridas.put(corrida.getId(), corrida);
        return corrida;
    }

    public Collection<Corrida> listarCorrida() {
        // checa se a corrida está válida
        return corridas.values().stream().filter(Corrida::isAtivo).toList();
    }

    public Corrida getCorrida(String id) {
        Corrida corrida = corridas.get(id);
        if (corrida == null || !corrida.isAtivo()) {
            throw new RuntimeException("Corrida invalida");
        }
        return corrida;
    }

    public Corrida editarCorrida(String id, Corrida c) {
        Corrida corrida = corridas.get(id);
        corrida.setData(c.getData());
        corrida.setUsuario(c.getUsuario());
        corrida.setMotorista(c.getMotorista());
        return corrida;
    }

    public void deletarCorrida(String id) {
        Corrida corrida = corridas.get(id);
        corrida.setAtivo(false);
    }

}
