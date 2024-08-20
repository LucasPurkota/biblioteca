package br.edu.up.front;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.up.entidades.Endereco;
import br.edu.up.entidades.Funcionario;
import br.edu.up.negocio.FuncionarioNegocio;
import br.edu.up.negocio.ValidaCPF;
import br.edu.up.persistencia.EnderecoPersistencia;
import br.edu.up.persistencia.FuncionarioPersistencia;

public class AppFuncionario {
	public AppFuncionario() {
		int opcao = 0;
		
		do {
			System.out.println("\n\n***Funcioanrio***");
			System.out.println("\n1 - Incluir");
			System.out.println("2 - Editar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Localizar");
			System.out.println("5 - Voltar");
			opcao = Console.readInt("Informe a opção: ");
			switch(opcao) {
			case 1:
				incluirFuncionario();
				break;
			case 2:
				editarFuncionario();
				break;
			case 3:
				excluirFuncionario();
				break;
			case 4:
				localizarFuncionario();
				break;
			}
		}while(opcao != 5);
	}
	
	private void incluirFuncionario() {
		String dataNasc;
		Date dataConvert;
		Funcionario funcionario = new Funcionario();
		System.out.println("\n\n***Incluir Funcionario***");
		funcionario.setCpf(Console.readString("\nInforme o CPF:"));
		if(ValidaCPF.isCPF(funcionario.getCpf())) {
			if(FuncionarioPersistencia.procuraPorCPF(funcionario) == null) {
				funcionario.setNome(Console.readString("Informe o nome: "));
				funcionario.setRg(Console.readString("Informe o RG: "));
				funcionario.setTelefone(Console.readString("Informe o telefone: "));
				do {
					dataNasc = Console.readString("Informe a data de nascimento: ");
					dataConvert = FuncionarioNegocio.converterData(dataNasc);
					if(dataConvert != null) {
						funcionario.setDataNascimento(dataConvert);
					}else {
						System.out.println("Data invalida.");
					}
				}while(dataNasc == null);
				Endereco endereco = new Endereco();
				endereco.setCep(Console.readString("Informe o CEP: "));
				endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
				if(endereco != null) {
					funcionario.setEndereco(endereco);
					funcionario.setComplemento(Console.readString("Informe o complemento: "));
					funcionario.setNumero(Console.readInt("Informe o número: "));
					String resp = Console.readString("Deseja confirmar a operação? ");
					if((resp.equals("S")) || (resp.equals("s"))) {
						if(FuncionarioPersistencia.incluir(funcionario) == true) {
							System.out.println("\nFuncionario cadastrado com sucesso!");
						}else {
							System.out.println("\nFuncionario não pode ser incluso no momento!");
						}
					}else {
						System.out.println("\nFuncionario não pode ser incluso no momento!");
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
	
	private void editarFuncionario() {
		String dataNasc;
		Date dataConvert;
		Funcionario funcionario = new Funcionario();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Editar Funcionario***");
		funcionario.setCpf(Console.readString("\nInforme o CPF do cliente que deseja editar: "));
		funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
		if(funcionario != null) {
			System.out.println("\n------------------");
			System.out.println("ID: " + funcionario.getIdFuncionario());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("RG: " + funcionario.getRg());
			System.out.println("Telefone: " + funcionario.getTelefone());
			System.out.println("Data Nascimento: " + formato.format(funcionario.getDataNascimento()));
			System.out.println("Endereço: " + funcionario.getEndereco().getCep());
			System.out.println("Complemento: " + funcionario.getComplemento());
			System.out.println("Numero: " + funcionario.getNumero());
			System.out.println("------------------");
			funcionario.setNome(Console.readString("\nInforme o nome: "));
			funcionario.setTelefone(Console.readString("Informe o telefone"));
			do {
				dataNasc = Console.readString("Informe a data de nascimento: ");
				dataConvert = FuncionarioNegocio.converterData(dataNasc);
				if(dataConvert != null) {
					funcionario.setDataNascimento(dataConvert);
				}else {
					System.out.println("Data invalida.");
				}
			}while(dataNasc == null);
			Endereco endereco = new Endereco();
			endereco.setCep(Console.readString("Informe o CEP: "));
			endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
			if(endereco != null) {
				funcionario.setEndereco(endereco);
				funcionario.setComplemento(Console.readString("Informe o complemento: "));
				funcionario.setNumero(Console.readInt("Informe o número: "));
				String resp = Console.readString("Deseja confirmar a operação? ");
				if((resp.equals("S")) || (resp.equals("s"))) {
					if(FuncionarioPersistencia.editar(funcionario) == true) {
						System.out.println("\nFuncionario editado com sucesso!");
					}else {
						System.out.println("\nFuncionarioa não pode ser editado no momento!");
					}
				}else {
					System.out.println("\nFuncionarioa não pode ser editado no momento!");
				}
			}else {
				System.out.println("\nEndereco não cadastrado!");
			}
		}else {
			System.out.println("\nFuncionario não cadastrado!");
		}
	}
	
	private void excluirFuncionario() {
		Funcionario funcionario = new Funcionario();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Excluir Funcionario***");
		funcionario.setCpf(Console.readString("\nInforme o CPF do Funcionario que deseja excluir: "));
		funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
		if(funcionario != null) {
			System.out.println("\n---------------------");
			System.out.println("ID: " + funcionario.getIdFuncionario());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("RG: " + funcionario.getRg());
			System.out.println("Telefone: " + funcionario.getTelefone());
			System.out.println("Data Nascimento: " + formato.format(funcionario.getDataNascimento()));
			System.out.println("CEP: " + funcionario.getEndereco().getCep());
			System.out.println("Logradouro: " + funcionario.getEndereco().getLogradouro());
			System.out.println("Bairro: " + funcionario.getEndereco().getBairro());
			System.out.println("Cidade: " + funcionario.getEndereco().getCidade());
			System.out.println("Estado: " + funcionario.getEndereco().getEstado());
			System.out.println("Pais: " + funcionario.getEndereco().getPais());
			System.out.println("Complemento: " + funcionario.getComplemento());
			System.out.println("Numero: " + funcionario.getNumero());
			System.out.println("---------------------");
			String resp = Console.readString("Deseja realmente excluir o Funcionario localizado? ");
			if((resp.equals("S")) || (resp.equals("s"))) {
				if(FuncionarioPersistencia.excluir(funcionario) == true) {
					System.out.println("\nFuncionario excluido com sucesso!");
				}else {
					System.out.println("\nNão foi possivel excluir o Funcionario no momento!");
				}
			}else {
				System.out.println("\nNão foi possivel excluir o Funcionario no momento!");
			}
		}else {
			System.out.println("\nFuncionario não cadastrado!");
		}
	}
	
	private void localizarFuncionario() {
		Funcionario funcionario = new Funcionario();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Localizar Funcioanrio***");
		funcionario.setCpf(Console.readString("\nInforme o CPF do Funcionario que deseja localizar: "));
		funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
		if(funcionario != null) {
			System.out.println("\n---------------------");
			System.out.println("ID: " + funcionario.getIdFuncionario());
			System.out.println("CPF: " + funcionario.getCpf());
			System.out.println("Nome: " + funcionario.getNome());
			System.out.println("RG: " + funcionario.getRg());
			System.out.println("Telefone: " + funcionario.getTelefone());
			System.out.println("Data Nascimento: " + formato.format(funcionario.getDataNascimento()));
			System.out.println("CEP: " + funcionario.getEndereco().getCep());
			System.out.println("Logradouro: " + funcionario.getEndereco().getLogradouro());
			System.out.println("Bairro: " + funcionario.getEndereco().getBairro());
			System.out.println("Cidade: " + funcionario.getEndereco().getCidade());
			System.out.println("Estado: " + funcionario.getEndereco().getEstado());
			System.out.println("Pais: " + funcionario.getEndereco().getPais());
			System.out.println("Complemento: " + funcionario.getComplemento());
			System.out.println("Numero: " + funcionario.getNumero());
			System.out.println("---------------------");
		}else {
			System.out.println("\nFuncionario não cadastrado!");
		}
	}
}
