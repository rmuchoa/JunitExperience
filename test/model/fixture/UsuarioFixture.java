package model.fixture;

import java.util.ArrayList;
import java.util.List;

import model.entity.Usuario;

public class UsuarioFixture {

	private Usuario usuario = new Usuario();
	
	public static UsuarioFixture criaUmUsuario() {
		return new UsuarioFixture();
	}

	public Usuario agora() {
		return this.usuario;
	}

	public UsuarioFixture comId(Long id) {
		this.usuario.setId(id);
		return this;
	}

	public UsuarioFixture comNome(String nome) {
		usuario.setNome(nome);
		return this;
	}

	public UsuarioFixture comLogin(String login) {
		this.usuario.setLogin(login);
		return this;
	}

	public UsuarioFixture comSenha(String senha) {
		this.usuario.setSenha(senha);
		return this;
	}

	public UsuarioFixture comEmail(String email) {
		this.usuario.setEmail(email);
		return this;
	}

	public static List<Usuario> criaUmaListaDeUsuarios(Long quantidade) {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		for (long i=0L; i<quantidade; i++)
			usuarios.add(UsuarioFixture.criaUmUsuario().comId(i).comLogin("teste").comSenha("teste").agora());
		return usuarios;
	}

}
