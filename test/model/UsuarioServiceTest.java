package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;

import model.dao.UsuarioDao;
import model.dao.mock.UsuarioDaoMock;
import model.entity.Usuario;
import model.fixture.UsuarioFixture;

import org.junit.Before;
import org.junit.Test;

public class UsuarioServiceTest {
	
	private UsuarioService servico;
	
	@Before
	public void setUp() {
		UsuarioDao dao = new UsuarioDaoMock();
		this.servico = new UsuarioService(dao);
	}

	@Test
	public void usuarioDeveSeLogarNoSistema() {
		Usuario usuario = UsuarioFixture.criaUmUsuario().comLogin("login").comSenha("senha").agora();
		assertEquals(true, servico.logar(usuario));
	}
	
	@Test
	public void deveCadastrarUmNovoUsuarioNoSistema() {
		Usuario usuario = UsuarioFixture.criaUmUsuario().comId(1L).comNome("nome")
				.comLogin("login").comSenha("senha").comEmail("email").agora();
		assertEquals(true, servico.cadastrar(usuario));
	}
	
	@Test
	public void deveListarTodosOsUsuariosCadastrados() {
		List<Usuario> usuarios = UsuarioFixture.criaUmaListaDeUsuarios(5L); 
		
		servico.cadastrarTodos(usuarios);
		
		assertEquals(usuarios.size(), servico.listar().size());
	}
	
	@Test(expected = RuntimeException.class)
	public void deveLançarUmaExcecaoQuandoIdForInvalido() {
		Usuario usuario = UsuarioFixture.criaUmUsuario().agora();
		servico.validaUsuario(usuario);
	}
	
	@Test
	public void deveValidarUsuarioComSucesso() {
		Usuario usuario = UsuarioFixture.criaUmUsuario().comId(1L).comLogin("login").comSenha("senha").agora();
		try {
			servico.validaUsuario(usuario);
		} catch (RuntimeException e) {
			fail(e.getMessage());
		}
	}
	
}
