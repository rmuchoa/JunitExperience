package model.dao.mock;

import java.util.ArrayList;
import java.util.List;

import model.dao.UsuarioDao;
import model.entity.Usuario;

public class UsuarioDaoMock extends UsuarioDao {

	private List<Usuario> usuarios = new ArrayList<Usuario>();

	@Override
	public Usuario salvar(Usuario usuario) {
		this.usuarios.add(usuario);
		return usuario;
	}

	@Override
	public Usuario alterar(Usuario usuario) {
		return usuario;
	}

	
	@Override
	public Usuario remover(Usuario usuario) {
		this.usuarios.remove(usuario);
		return usuario;
	}

	@Override
	public List<Usuario> listar() {
		return getUsuarios();
	}
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
}
