package model.dao;

import java.util.ArrayList;
import java.util.List;

import model.entity.Usuario;

public class UsuarioDao {

	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Usuario salvar(Usuario usuario) {
		usuarios.add(usuario);
		return usuario;
	}
	
	public Usuario alterar(Usuario usuario) {
		for (Usuario usuarioSalvo : usuarios) {
			if (usuarioSalvo.getId() == usuario.getId()) {
				usuarioSalvo.setNome(usuario.getNome());
				usuarioSalvo.setLogin(usuario.getLogin());
				usuarioSalvo.setSenha(usuario.getSenha());
				usuarioSalvo.setEmail(usuario.getEmail());
				return usuarioSalvo;
			}
		}
		return usuario;
	}
	
	public Usuario remover(Usuario usuario) {
		for (Usuario usuarioSalvo : usuarios) {
			if (usuarioSalvo.getId() == usuario.getId()) {
				usuarios.remove(usuarioSalvo);
				return usuarioSalvo;
			}
		}
		return null;
	}
	
	public List<Usuario> listar() {
		return usuarios;
	}
	
}
