package br.insper.app_corrida.Corrida;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class CorridaController {

    @Autowired
    private CorridaService corridaService;

    @PostMapping("/corridas/{idUsuario}")
    public Corrida criarCorrida(@RequestBody Corrida corrida, @PathVariable String idUsuario) {
        return corridaService.criarCorrida(corrida, idUsuario);
    }

    @GetMapping("/corridas")
    public Collection<Corrida> getCorridas() {
        return corridaService.listarCorrida();
    }

    @GetMapping("/corridas/{id}")
    public Corrida getCorridaId(@PathVariable String id) {
        return corridaService.getCorrida(id);
    }

    @PutMapping("/corridas/{id}")
    public Corrida atualizarCorrida(@PathVariable String id, @RequestBody Corrida dados) {
        return corridaService.editarCorrida(id, dados);
    }

    @DeleteMapping("/corridas/{id}")
    public void deleteCorrida(@PathVariable String id) {
        corridaService.deletarCorrida(id);
    }

}
