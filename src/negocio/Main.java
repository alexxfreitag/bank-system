package negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static GerenciadoraClientes gerClientes;
	static GerenciadoraContas gerContas;
	
	public static void main(String[] args) {
		
		inicializaSistemaBancario(); // criando algumas contas e clientes fict�cios
		
		Scanner sc = new Scanner(System.in);
		boolean continua = true;
		
		while (continua){
			
			printMenu();
			
			int opcao = sc.nextInt();
			
			switch (opcao) {
			// Consultar por um cliente
			case 1:
				System.out.print("Digite o ID do cliente: ");
				int idCliente = sc.nextInt();
				Cliente cliente = gerClientes.pesquisaCliente(idCliente);
				
				if(cliente != null)
					System.out.println(cliente.toString());
				else
					System.out.println("Cliente não encontrado!");
				
				pulalinha();
				break;

			// Consultar por uma conta corrente
			case 2:
				System.out.print("Digite o ID da conta: ");
				int idConta = sc.nextInt();
				ContaCorrente conta = gerContas.pesquisaConta(idConta);
				
				if(conta != null)
					System.out.println(conta.toString());
				else
					System.out.println("Conta não encontrado!");
				
				pulalinha();
				break;
			// Sair
			case 5:
				continua = false;
				System.out.println("################# Sistema encerrado #################");
				break;
				
			default:
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				System.out.println();
				break;
				
			} 
			
		}
	
		
	}

	private static void pulalinha() {
		System.out.println("\n");
	}

	/**
	 * Imprime menu de op��es do nosso sistema banc�rio
	 */
	private static void printMenu() {
		
		System.out.println("O que você deseja fazer? \n");
		System.out.println("1) Consultar por um cliente");
		System.out.println("2) Consultar por uma conta corrente");
		System.out.println("5) Sair");
		System.out.println();
		
	}

	/**
	 * M�todo que cria e insere algumas contas e clientes no sistema do banco,
	 * apenas para realiza��o de testes manuais atrav�s do m�todo main acima.
	 */
	private static void inicializaSistemaBancario() {
		// criando lista vazia de contas e clientes
		List<ContaCorrente> contasDoBanco = new ArrayList<>();
		List<Cliente> clientesDoBanco = new ArrayList<>();
		
		// criando e inserindo duas contas na lista de contas correntes do banco
		ContaCorrente conta01 = new ContaCorrente(1, 0, true);
		ContaCorrente conta02 = new ContaCorrente(2, 0, true);
		contasDoBanco.add(conta01);
		contasDoBanco.add(conta02);
		
		// criando dois clientes e associando as contas criadas acima a eles
		Cliente cliente01 = new Cliente(1, "Alex Freitag", 31, "alexefreitag@gmail.com", conta01.getId());
		Cliente cliente02 = new Cliente(2, "Felipe Augusto", 34, "felipeaugusto@gmail.com", conta02.getId());
		// inserindo os clientes criados na lista de clientes do banco
		clientesDoBanco.add(cliente01);
		clientesDoBanco.add(cliente02);
		
		gerClientes = new GerenciadoraClientes(clientesDoBanco);
		gerContas = new GerenciadoraContas(contasDoBanco);
		
	}
	
}

