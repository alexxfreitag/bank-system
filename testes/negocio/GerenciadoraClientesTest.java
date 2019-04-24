package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;

public class GerenciadoraClientesTest {

	private GerenciadoraClientes gerClientes;
	private int idCLiente01 = 1;
	private int idCLiente02 = 2;
	
	
	@Rule
    public Timeout globalTimeout = Timeout.seconds(2);
	
	//executa antes de todos os testes serem realizados
	@Before
	public void criaCenario() {

		// criando dois clientes
		Cliente cliente01 = new Cliente(1, "Alex Freitag", 31, "alexefreitag@gmail.com", 1);
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", 2);
		
		// inserindo os clientes criados na lista de clientes do banco
		List<Cliente> clientesDoBanco = new ArrayList<>();
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		
	}
	
	//executa depois de todos os testes serem realizados
	@After
	public void excluiCenario() {
		gerClientes.limpa();
	}
	
	@Test
	public void testRemoveCliente() {
			
		boolean clienteRemovido = gerClientes.removeCliente(idCLiente02);
		
		//espera que o clienteRemovido seja true, ou seja, que o cliente tenha sido removido
		assertTrue(clienteRemovido);
		//espera que a lista dos clientes no banco tenha o tamanho 1
		assertThat(gerClientes.getClientesDoBanco().size(), is(1));
		//espera que, ao pesquisar pelo id do cliente removido, retorne null
		assertNull(gerClientes.pesquisaCliente(idCLiente02));
		
	}
	
	@Test(expected=IdadeNaoPermitidaException.class)
	public void testInsereIdadeCorreta() throws IdadeNaoPermitidaException {

		//adiciona cliente novo	
		Cliente cliente = new Cliente(3, "Leonardo", 17, "leonardo@gmail.com", 1);

		//valida a idade do cliente novo
		gerClientes.validaIdade(cliente.getIdade());
	}
}
