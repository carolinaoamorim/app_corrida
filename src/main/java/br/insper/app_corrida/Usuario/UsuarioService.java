package br.insper.app_corrida.Usuario;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

@Service
public class UsuarioService {

    private HashMap<String, Usuario> usuarios = new HashMap<>();

    public Usuario criarUsuario(Usuario usuario) {
        if (usuario.getNome() == null || usuario.getCpf() == null) {
            throw new RuntimeException("Dados inválidos");
        }
        usuario.setId(UUID.randomUUID().toString());
        usuario.setAtivo(true);
        usuarios.put(usuario.getId(), usuario);
        return usuario;
    }

    public Collection<Usuario> listarUsuario() {
        // checa se o usuario não esta deletado
        return usuarios.values().stream().filter(Usuario::isAtivo).toList();
    }

    public Usuario getUsuario(String id) {
        Usuario usuario = usuarios.get(id);
        if (usuario == null || !usuario.isAtivo()) {
            throw new RuntimeException("Usuário invalido");
        }
        return usuario;
    }

    public Usuario editarUsuario(String id, Usuario u) {
        Usuario usuario = usuarios.get(id);
        usuario.setNome(u.getNome());
        usuario.setEmail(u.getEmail());
        usuario.setDataNascimento(u.getDataNascimento());
        usuario.setCpf(u.getCpf());
        // não possui o de ativo aqui porque isso é feito só na função de deletar mesmo
        return usuario;
    }

    public void deletarUsuario(String id) {
        Usuario usuario = usuarios.get(id);
        usuario.setAtivo(false);
    }


}
