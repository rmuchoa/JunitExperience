package model;

import java.util.List;

import model.dao.UsuarioDao;
import model.entity.Usuario;

public class UsuarioService {

	private UsuarioDao dao;
	
	public UsuarioService(UsuarioDao dao) {
		this.dao = dao;
	}
	
	public void cadastrarTodos(List<Usuario> usuarios) {
		for (Usuario usuario : usuarios) {
			cadastrar(usuario);
		}
	}

	public boolean cadastrar(Usuario usuario) {
		validaUsuario(usuario);
		if (dao.salvar(usuario) != null)
			return true;
		return false;
	}
	
	public List<Usuario> listar() {
		return dao.listar();
	}
	
	public boolean logar(Usuario usuario) {
		if (usuario.getLogin().equals("login") && usuario.getSenha().equals("senha"))
			return true;
		return false;
	}

	protected void validaUsuario(Usuario usuario) {
		validaId(usuario);
		validaLogin(usuario);
		validaSenha(usuario);
	}
	
	private void validaId(Usuario usuario) {
		if (usuario.getId() == null)
			throw new RuntimeException("Erro: id inv‡lido!");
		verificaIdUsado(usuario);
	}

	private void verificaIdUsado(Usuario usuario) {
		for (Usuario usuarioSalvo : dao.listar())
			if (usuarioSalvo.getId().equals(usuario.getId()))
				throw new RuntimeException("Erro: id j‡ est‡ sendo usado!");
	}

	private void validaLogin(Usuario usuario) {
		if (usuario.getLogin() == null && usuario.getLogin().equals(""))
			throw new RuntimeException("Erro: login inv‡lido!");
	}

	private void validaSenha(Usuario usuario) {
		if (usuario.getSenha() == null && usuario.getSenha().equals(""))
			throw new RuntimeException("Erro: senha inv‡lida!");
	}
	
}
