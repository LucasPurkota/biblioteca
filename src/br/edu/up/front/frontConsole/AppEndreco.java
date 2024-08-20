package br.edu.up.front;

import br.edu.up.entidades.Endereco;
import br.edu.up.persistencia.EnderecoPersistencia;

public class AppEndreco {
	public AppEndreco() {
		int opcao = 0;
		do {
			System.out.println("\n\n***Endereço***");
			System.out.println("\n1 - Incluir");
			System.out.println("2 - Editar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Localizar");
			System.out.println("5 - Voltar");
			opcao = Console.readInt("Informe a opção: ");
			
			switch(opcao) {
			case 1:
				incluirEndereco();
				break;
			case 2:
				editarEndereco();
				break;
			case 3:
				excluirEndereco();
				break;
			case 4:
				localizarEndereco();
				break;
			}
		}while(opcao != 5);
	}
	
	public void incluirEndereco() {
		Endereco endereco = new Endereco();
		System.out.println("\n\n***Incluir Endereço***");
		endereco.setCep(Console.readString("\nInforme o CEP: "));
		if(EnderecoPersistencia.pequisarPorCEP(endereco) == null) {
			endereco.setLogradouro(Console.readString("Informe o logradouro: "));
			endereco.setBairro(Console.readString("Informe o bairro: "));
			endereco.setCidade(Console.readString("Informe a cidade: "));
			endereco.setEstado(Console.readString("Informe o estado: "));
			endereco.setPais(Console.readString("Informe o pais: "));
			String resp = Console.readString("Deseja confirmar a operação? ");
			if((resp.equals("S")) || (resp.equals("s"))) {
				if(EnderecoPersistencia.incluir(endereco) == true) {
					System.out.println("\nEndereço cadastrado com sucesso!");
				}else {
					System.out.println("\nEndereço não pode ser incluso no momento!");
				}
			}else {
				System.out.println("\nEndereço não pode ser incluso no momento!");
			}
		}else {
			System.out.println("\nEndereço já cadastrado!");
		}
	}
	
	public void editarEndereco() {
		Endereco endereco = new Endereco();
		System.out.println("\n\n***Editar Endereço***");
		endereco.setCep(Console.readString("\nInforme o CEP que deseja editar: "));
		endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
		if(endereco != null) {
			System.out.println("\n-------------------");
			System.out.println("CEP: " + endereco.getCep());
			System.out.println("Logradouro: " + endereco.getLogradouro());
			System.out.println("Bairro: " + endereco.getBairro());
			System.out.println("Cidade: " + endereco.getCidade());
			System.out.println("Estado: " + endereco.getEstado());
			System.out.println("Pais: " + endereco.getPais());
			System.out.println("-------------------");
			endereco.setLogradouro(Console.readString("\nInforme o logradouro: "));
			endereco.setBairro(Console.readString("Informe o bairro: "));
			endereco.setCidade(Console.readString("Informe a cidade: "));
			endereco.setEstado(Console.readString("Informe o estado: "));
			endereco.setPais(Console.readString("Informe o pais: "));
			String resp = Console.readString("Deseja confirmar a operação? ");
			if((resp.equals("S")) || (resp.equals("s"))) {
				if(EnderecoPersistencia.editar(endereco) == true) {
					System.out.println("\nEndereço editado com sucesso!");
				}else {
					System.out.println("\nEndereço não pode ser editado no momento!");
				}
			}else {
				System.out.println("\nEndereço não pode ser editado no momento!");
			}
		}else {
			System.out.println("\nEndereço não cadastrado!");
		}
	}
	
	public void excluirEndereco() {
		Endereco endereco = new Endereco();
		System.out.println("\n\n***Excluir Endereço***");
		endereco.setCep(Console.readString("\nInforme o CEP que deseja excluir: "));
		endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
		if(endereco != null) {
			System.out.println("\n-------------------");
			System.out.println("CEP: " + endereco.getCep());
			System.out.println("Logradouro: " + endereco.getLogradouro());
			System.out.println("Bairro: " + endereco.getBairro());
			System.out.println("Cidade: " + endereco.getCidade());
			System.out.println("Estado: " + endereco.getEstado());
			System.out.println("Pais: " + endereco.getPais());
			System.out.println("-------------------");
			String resp = Console.readString("\nDeseja realmente excluir o Endereço localizado? ");
			if((resp.equals("S")) || (resp.equals("s"))){
				if(EnderecoPersistencia.excluir(endereco) == true) {
					System.out.println("\nEndereço excluido com sucesso!");
				}else {
					System.out.println("\nNão foi possivel excluir o Endereço no momento!");
				}
			}else {
				System.out.println("\nNão foi possivel excluir o Endereço no momento!");
			}
		}else {
			System.out.println("\nEndereço não cadastrado!");
		}
	}
	
	public void localizarEndereco() {
		Endereco endereco = new Endereco();
		System.out.println("\n\n***Localizar Endereço***");
		endereco.setCep(Console.readString("\nInforme o CEP que deseja localizar: "));
		endereco = EnderecoPersistencia.pequisarPorCEP(endereco);
		if(endereco != null) {
			System.out.println("\n-------------------");
			System.out.println("CEP: " + endereco.getCep());
			System.out.println("Logradouro: " + endereco.getLogradouro());
			System.out.println("Bairro: " + endereco.getBairro());
			System.out.println("Cidade: " + endereco.getCidade());
			System.out.println("Estado: " + endereco.getEstado());
			System.out.println("Pais: " + endereco.getPais());
			System.out.println("-------------------");
		}else {
			System.out.println("\nEndereço não cadastrado!");
		}
	}
}
