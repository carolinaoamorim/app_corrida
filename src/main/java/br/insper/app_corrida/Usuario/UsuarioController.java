package br.insper.app_corrida.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/usuarios")
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioService.criarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    public Collection<Usuario> getUsuarios() {
        return usuarioService.listarUsuario();
    }

    @GetMapping("/usuarios/{id}")
    public Usuario getUsuarioId(@PathVariable String id) {
        return usuarioService.getUsuario(id);
    }

    @PutMapping("/usuarios/{id}")
    public Usuario atualizarUsuario(@PathVariable String id, @RequestBody Usuario dados) {
        return usuarioService.editarUsuario(id, dados);
    }

    @DeleteMapping("/usuarios/{id}")
    public void deleteUsuario(@PathVariable String id) {
        usuarioService.deletarUsuario(id);
    }

}
