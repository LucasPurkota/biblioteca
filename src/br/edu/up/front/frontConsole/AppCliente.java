package br.edu.up.front;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.up.entidades.Cliente;
import br.edu.up.entidades.Endereco;
import br.edu.up.negocio.FuncionarioNegocio;
import br.edu.up.negocio.ValidaCPF;
import br.edu.up.persistencia.ClientePersistencia;
import br.edu.up.persistencia.EnderecoPersistencia;

public class AppCliente {
	public AppCliente() {
		int opcao = 0;
		
		do {
			System.out.println("\n\n***Cliente***");
			System.out.println("\n1 - Incluir");
			System.out.println("2 - Editar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Localizar");
			System.out.println("5 - Voltar");
			opcao = Console.readInt("Informe a opção: ");
			
			switch(opcao) {
			case 1:
				incluirCliente();
				break;
			case 2:
				editarCliente();
				break;
			case 3:
				excluirCliente();
				break;
			case 4:
				localizarCliente();
				break;
			}
		}while(opcao != 5);
	}
	
	private void incluirCliente() {
		String dataNasc;
		Date dataConvert;
		Cliente cliente = new Cliente();
		System.out.println("\n\n***Incluit Cliente***");
		cliente.setCpf(Console.readString("\nInforme o CPF: "));
		if(ValidaCPF.isCPF(cliente.getCpf())) {
			if(ClientePersistencia.procurarPorCPF(cliente) == null) {
				cliente.setNome(Console.readString("Informe o nome: "));
				cliente.setRg(Console.readString("Informe o RG: "));
				cliente.setTelefone(Console.readString("Informe o telefone: "));
				do {
					dataNasc = Console.readString("Informe a data de nascimento: ");
					dataConvert = FuncionarioNegocio.converterData(dataNasc);
					if(dataConvert != null) {
						cliente.setDataNascimento(dataConvert);
					}else {
						System.out.println("Data inválida.");
					}
				}while(dataNasc == null);
				Endereco endereco = new Endereco();
				endereco.setCep(Console.readString("Informe o CEP: "));
				endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
				if(endereco != null) {
					cliente.setEndereco(endereco);
					cliente.setComplemento(Console.readString("Informe o Complemento: "));
					cliente.setNumero(Console.readInt("Informe o número: "));
					String resp = Console.readString("Deseja confirmar a operação?");
					if((resp.equals("S"))|| (resp.equals("s"))) {
						if(ClientePersistencia.incluir(cliente) == true) {
							System.out.println("\nCliente Cadastrado com sucesso!");
						}else {
							System.out.println("\nCliente não pode ser incluso no momento!");
						}
					}else {
						System.out.println("\nCliente não pode ser incluso no momento!");
					}
				}else {
					System.out.println("\nEndereco não cadastrado!");
				}
			}else {
				System.out.println("\nCliente já cadastrado!");
			}
		}else {
			System.out.println("\nCPF invalido!");
		}
	}
	
	private void editarCliente() {
		String dataNasc;
		Date dataConvert;
		Cliente cliente = new Cliente();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Editar Cliente***");
		cliente.setCpf(Console.readString("\nInforme o CPF do cliente que deseja editar: "));
		cliente = ClientePersistencia.procurarPorCPF(cliente);
		if(cliente != null) {
			System.out.println("\n------------------");
			System.out.println("ID: " + cliente.getIdCliente());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("RG: " + cliente.getRg());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Data Nascimento: " + formato.format(cliente.getDataNascimento()));
			System.out.println("Endereço: " + cliente.getEndereco().getCep());
			System.out.println("Complemento: " + cliente.getComplemento());
			System.out.println("Numero: " + cliente.getNumero());
			System.out.println("------------------");
			cliente.setNome(Console.readString("\nInforme o nome: "));
			cliente.setTelefone(Console.readString("Informe o telefone: "));
			do {
				dataNasc = Console.readString("Informe a data de nascimento: ");
				dataConvert = FuncionarioNegocio.converterData(dataNasc);
				if(dataConvert != null) {
					cliente.setDataNascimento(dataConvert);
				}else {
					System.out.println("Data inválida.");
				}
			}while(dataNasc == null);
			Endereco endereco = new Endereco();
			endereco.setCep(Console.readString("Informe o CEP: "));
			endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
			if(endereco != null) {
				cliente.setEndereco(endereco);
				cliente.setComplemento(Console.readString("Informe o Complemento: "));
				cliente.setNumero(Console.readInt("Informe o número: "));
				String resp = Console.readString("Deseja confirmar a operação?");
				if((resp.equals("S"))|| (resp.equals("s"))) {
					if(ClientePersistencia.editar(cliente) == true) {
						System.out.println("\nCliente editado com sucesso!");
					}else {
						System.out.println("\nImpossivel editar o Cliente no momento!");
					}
				}else {
					System.out.println("\nImpossivel editar o Cliente no momento!");
				}			
			}else {
				System.out.println("\nEndereco não cadastrado!");
			}
		}else {
			System.out.println("\nCliente não cadastrado!");
		}
	}
	
	private void excluirCliente() {
		Cliente cliente = new Cliente();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Excluir Cliente***");
		cliente.setCpf(Console.readString("\nInforme o CPF do cliente que deseja excluir"));
		cliente = ClientePersistencia.procurarPorCPF(cliente);
		if(cliente != null) {
			System.out.println("\n------------------");
			System.out.println("ID: " + cliente.getIdCliente());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("RG: " + cliente.getRg());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Data Nascimento: " + formato.format(cliente.getDataNascimento()));
			System.out.println("CEP: " + cliente.getEndereco().getCep());
			System.out.println("Logradouro: " + cliente.getEndereco().getLogradouro());
			System.out.println("Bairro: " + cliente.getEndereco().getBairro());
			System.out.println("Cidade: " + cliente.getEndereco().getCidade());
			System.out.println("Estado: " + cliente.getEndereco().getEstado());
			System.out.println("Pais: " + cliente.getEndereco().getPais());
			System.out.println("Complemento: " + cliente.getComplemento());
			System.out.println("Numero: " + cliente.getNumero());
			System.out.println("------------------");
			String resp = Console.readString("Deseja realmente excluir o cliente localizado? ");
			if((resp.equals("S")) || (resp.equals("s"))) {
				if(ClientePersistencia.excluir(cliente) == true) {
					System.out.println("\nCliente excluido com sucesso!");
				}else {
					System.out.println("\nNão foi possivel excluir o cliente no momento!");
				}
			}else {
				System.out.println("\nNão foi possivel excluir o cliente no momento!");
			}
		}else {
			System.out.println("\nCliente não cadastrado!");
		}
	}
	
	private void localizarCliente() {
		Cliente cliente = new Cliente();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Localizar Cliente***");
		cliente.setCpf(Console.readString("\nInforme o CPF do cliente que deseja localizar: "));
		cliente = ClientePersistencia.procurarPorCPF(cliente);
		if(cliente != null) {
			System.out.println("\n------------------");
			System.out.println("ID: " + cliente.getIdCliente());
			System.out.println("CPF: " + cliente.getCpf());
			System.out.println("Nome: " + cliente.getNome());
			System.out.println("RG: " + cliente.getRg());
			System.out.println("Telefone: " + cliente.getTelefone());
			System.out.println("Data Nascimento: " + formato.format(cliente.getDataNascimento()));
			System.out.println("CEP: " + cliente.getEndereco().getCep());
			System.out.println("Logradouro: " + cliente.getEndereco().getLogradouro());
			System.out.println("Bairro: " + cliente.getEndereco().getBairro());
			System.out.println("Cidade: " + cliente.getEndereco().getCidade());
			System.out.println("Estado: " + cliente.getEndereco().getEstado());
			System.out.println("Pais: " + cliente.getEndereco().getPais());
			System.out.println("Complemento: " + cliente.getComplemento());
			System.out.println("Numero: " + cliente.getNumero());
			System.out.println("------------------");
		}else {
			System.out.println("\nCliente não cadastrado!");
		}
	}
}
