package br.insper.app_corrida.Motorista;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @PostMapping("/motoristas")
    public Motorista criarMotorista(@RequestBody Motorista motorista) {
        return motoristaService.criarMotorista(motorista);
    }

    @GetMapping("/motoristas")
    public Collection<Motorista> getMotoristas() {
        return motoristaService.listarMotorista();
    }

    @GetMapping("/motoristas/{id}")
    public Motorista getMotoristaId(@PathVariable String id) {
        return motoristaService.getMotorista(id);
    }

    @PutMapping("/motoristas/{id}")
    public Motorista atualizarMotorista(@PathVariable String id, @RequestBody Motorista dados) {
        return motoristaService.editarMotorista(id, dados);
    }

    @DeleteMapping("/motoristas/{id}")
    public void deleteMotorista(@PathVariable String id) {
        motoristaService.deletarMotorista(id);
    }
}
