package br.edu.up.front;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.up.entidades.Cliente;
import br.edu.up.entidades.Emprestimo;
import br.edu.up.entidades.Funcionario;
import br.edu.up.entidades.ItemEmprestimo;
import br.edu.up.entidades.Livro;
import br.edu.up.negocio.EmprestimoNegocio;
import br.edu.up.persistencia.ClientePersistencia;
import br.edu.up.persistencia.EmprestimoPersistencia;
import br.edu.up.persistencia.FuncionarioPersistencia;
import br.edu.up.persistencia.LivroPersistencia;

public class AppEmprestimo {
	public AppEmprestimo() {
int opcao = 0;
		
		do {
			System.out.println("\n\n***Emprestimo***");
			System.out.println("\n1 - Incluir");
			System.out.println("2 - Editar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Localizar");
			System.out.println("5 - Devolução");
			System.out.println("6 - Voltar");
			opcao = Console.readInt("Informe a opção: ");
			
			switch(opcao) {
			case 1:
				incluirEmprestimo();
				break;
			case 2:
				editarEmprestimo();
				break;
			case 3:
				excluirEmprestimo();
				break;
			case 4:
				localizarEmprestimo();
				break;
			case 5:
				devolucaoEmprestimo();
				break;
			}
		}while(opcao != 6);
	}
	
	private void incluirEmprestimo() {		
		String dataEmp, resp, resp2;
		Date dataConvert;
		Emprestimo emprestimo = new Emprestimo(false);
		System.out.println("\n\n***Registrar Emprestimo***");
		emprestimo.setCodigoEmprestimo(Console.readInt("\nInforme o codigo do emprestimo: "));
		if(EmprestimoPersistencia.procurarPorCodigo(emprestimo) == null) {
			do {
				dataEmp = Console.readString("Informe a data do emprestimo: ");
				dataConvert = EmprestimoNegocio.converterData(dataEmp);
				if(dataConvert != null) {
					emprestimo.setDataEmprestimo(dataConvert);
				}else {
					System.out.println("Data invalida!");
				}
			}while(dataConvert == null);
			Cliente cliente = new Cliente();
			cliente.setCpf(Console.readString("Informe o CPF do Cliente: "));
			cliente = ClientePersistencia.procurarPorCPF(cliente);
			if(cliente != null) {
				emprestimo.setCliente(cliente);
				System.out.println("---Cliente---");
				System.out.println("ID: " + cliente.getIdCliente());
				System.out.println("CPF: " + cliente.getCpf());
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("-------------");
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(Console.readString("Informe o CPF do Funcionario: "));
				funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
				if(funcionario != null) {
					emprestimo.setFuncionario(funcionario);
					System.out.println("---Funcionario---");
					System.out.println("ID: " + funcionario.getIdFuncionario());
					System.out.println("CPF: " + funcionario.getCpf());
					System.out.println("Nome: " + funcionario.getNome());
					System.out.println("-----------------");
					do {
						Livro livro = new Livro();
						ItemEmprestimo itemEmprestimo = new ItemEmprestimo();
						livro.setIdLivro(Console.readInt("Informe o ID do Livro: "));
						livro = LivroPersistencia.procurarPorID(livro);
						if(livro != null) {
							if(livro.getEmprestado() == false) {
								itemEmprestimo.setLivro(livro);
								System.out.println("---Livro---");
								System.out.println("ID: " + livro.getIdLivro());
								System.out.println("Titulo: " + livro.getTitulo());
								System.out.println("-----------");
								livro.setEmprestado(true);
								LivroPersistencia.editar(livro);
								emprestimo.getItens().add(itemEmprestimo);
								System.out.println("Livro incluso com sucesso!");	
							}else {
								System.out.println("Livro ja possui emprestimo em aberto!");
							}
						}else {
							System.out.println("Livro não cadastrado!");
						}
						resp = Console.readString("Deseja incluir mais livros? ");
					}while((resp.equals("S")) || (resp.equals("s")));
					resp2 = Console.readString("Deseja confirmar a operação? ");
					if((resp2.equals("S")) || (resp2.equals("s"))){
						if(EmprestimoPersistencia.incluir(emprestimo) == true) {	
							System.out.println("\nEmprestimo registrado com sucesso!");
						}else {
							for(ItemEmprestimo itemLivro: emprestimo.getItens()) {
								Livro livro = new Livro();
								livro = itemLivro.getLivro();
								livro.setEmprestado(false);
								LivroPersistencia.editar(livro);
							}
							System.out.println("\nEmprestimo não pode ser registrado no momento!");
						}
					}else {
						for(ItemEmprestimo itemLivro: emprestimo.getItens()) {
							Livro livro = new Livro();
							livro = itemLivro.getLivro();
							livro.setEmprestado(false);
							LivroPersistencia.editar(livro);
						}
						System.out.println("\nEmprestimo não pode ser registrado no momento!");
					}					
				}else {
					System.out.println("\nFuncionario não cadastrado!");
				}
			}else {
				System.out.println("\nCliente não cadastrado!");
			}
		}else {
			System.out.println("\nEmprestimo ja realizado!");
		}
	}
	
	private void editarEmprestimo() {
		String dataEmp, resp;
		Date dataConvert;
		Emprestimo emprestimo = new Emprestimo();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Editar Emprestimo***");
		emprestimo.setCodigoEmprestimo(Console.readInt("\nInforme o codigo do emprestimo: "));
		emprestimo = EmprestimoPersistencia.procurarPorCodigo(emprestimo);
		if(emprestimo != null) {
			System.out.println("\n-------------------");
			System.out.println("ID: " + emprestimo.getIdEmprestimo());
			System.out.println("Codigo: " + emprestimo.getCodigoEmprestimo());
			System.out.println("Data emprestimo: " + formato.format(emprestimo.getDataEmprestimo()));
			System.out.println("Cliente: " + emprestimo.getCliente().getNome());
			System.out.println("Funcionario: " + emprestimo.getFuncionario().getNome());
			System.out.println("---Livros---");
			for(ItemEmprestimo itemLivro: emprestimo.getItens()) {
				Livro livro = new Livro();
				livro = itemLivro.getLivro();
				System.out.println("ID Livro: " + livro.getIdLivro());
				System.out.println("Titulo: " + livro.getTitulo());
			}
			if(emprestimo.getDevolvido() == true) {
				System.out.println("Situação: Devolvido");
				System.out.println("Data devolução: " + formato.format(emprestimo.getDataDevolucao()));
			}else {
				System.out.println("Situação: Em aberto");
			}
			System.out.println("-------------------");
			do {
				dataEmp = Console.readString("\nInforme a data do emprestimo: ");
				dataConvert = EmprestimoNegocio.converterData(dataEmp);
				if(dataConvert != null) {
					emprestimo.setDataEmprestimo(dataConvert);
				}else {
					System.out.println("Data invalida!");
				}
			}while(dataConvert == null);
			Cliente cliente = new Cliente();
			cliente.setCpf(Console.readString("Informe o CPF do Cliente: "));
			cliente = ClientePersistencia.procurarPorCPF(cliente);
			if(cliente != null) {
				emprestimo.setCliente(cliente);
				System.out.println("---Cliente---");
				System.out.println("ID: " + cliente.getIdCliente());
				System.out.println("CPF: " + cliente.getCpf());
				System.out.println("Nome: " + cliente.getNome());
				System.out.println("-------------");
				Funcionario funcionario = new Funcionario();
				funcionario.setCpf(Console.readString("Informe o CPF do Funcionario: "));
				funcionario = FuncionarioPersistencia.procuraPorCPF(funcionario);
				if(funcionario != null) {
					emprestimo.setFuncionario(funcionario);
					System.out.println("---Funcionario---");
					System.out.println("ID: " + funcionario.getIdFuncionario());
					System.out.println("CPF: " + funcionario.getCpf());
					System.out.println("Nome: " + funcionario.getNome());
					System.out.println("-----------------");					
					resp = Console.readString("Deseja confirmar a operação? ");
					if((resp.equals("S")) || (resp.equals("s"))){
						if(EmprestimoPersistencia.editar(emprestimo) == true) {	
							System.out.println("\nEmprestimo editado com sucesso!");
						}else {
							System.out.println("\nEmprestimo não pode ser editado no momento!");
						}
					}else {						
						System.out.println("\nEmprestimo não pode ser editado no momento!");
					}					
				}else {
					System.out.println("\nFuncionario não cadastrado!");
				}
			}else {
				System.out.println("\nCliente não cadastrado!");
			}
		}else {
			System.out.println("\nEmprestimo não registrado!");
		}
	}
	
	private void excluirEmprestimo() {
		
		Emprestimo emprestimo = new Emprestimo();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Excluir Emprestimo***");
		emprestimo.setCodigoEmprestimo(Console.readInt("\nInforme o codigo do emprestimo: "));
		emprestimo = EmprestimoPersistencia.procurarPorCodigo(emprestimo);
		if(emprestimo != null) {
			System.out.println("\n-------------------");
			System.out.println("ID: " + emprestimo.getIdEmprestimo());
			System.out.println("Codigo: " + emprestimo.getCodigoEmprestimo());
			System.out.println("Data emprestimo: " + formato.format(emprestimo.getDataEmprestimo()));
			System.out.println("Cliente: " + emprestimo.getCliente().getNome());
			System.out.println("Funcionario: " + emprestimo.getFuncionario().getNome());
			System.out.println("---Livros---");
			for(ItemEmprestimo itemLivro: emprestimo.getItens()) {
				Livro livro = new Livro();
				livro = itemLivro.getLivro();
				System.out.println("ID Livro: " + livro.getIdLivro());
				System.out.println("Titulo: " + livro.getTitulo());
			}
			if(emprestimo.getDevolvido() == true) {
				System.out.println("Situação: Devolvido");
				System.out.println("Data devolução: " + formato.format(emprestimo.getDataDevolucao()));
			}else {
				System.out.println("Situação: Em aberto");
			}
			System.out.println("-------------------");
			String resp = Console.readString("Deseja realmente excluir o emprestimo localizado? ");
			if((resp.equals("S")) || (resp.equals("s"))) {
				for(ItemEmprestimo itemLivro: emprestimo.getItens()) {
					Livro livro = new Livro();
					livro = itemLivro.getLivro();
					livro.setEmprestado(false);
					LivroPersistencia.editar(livro);
				}
				if(EmprestimoPersistencia.excluir(emprestimo) == true) {
					System.out.println("\nEmprestimo excluido com sucesso!");
				}else {
					System.out.println("\nNão foi possivel excluir o Emprestimo no momento!");
				}
			}else {
				System.out.println("\nNão foi possivel excluir o Emprestimo no momento!");
			}
		}else {
			System.out.println("\nEmprestimo não registrado!");
		}
	}
	
	private void localizarEmprestimo() {

		Emprestimo emprestimo = new Emprestimo();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Localizar Emprestimo***");
		emprestimo.setCodigoEmprestimo(Console.readInt("\nInforme o codigo do emprestimo: "));
		emprestimo = EmprestimoPersistencia.procurarPorCodigo(emprestimo);
		if(emprestimo != null) {
			System.out.println("\n-------------------");
			System.out.println("ID: " + emprestimo.getIdEmprestimo());
			System.out.println("Codigo: " + emprestimo.getCodigoEmprestimo());
			System.out.println("Data emprestimo: " + formato.format(emprestimo.getDataEmprestimo()));
			System.out.println("Cliente: " + emprestimo.getCliente().getNome());
			System.out.println("Funcionario: " + emprestimo.getFuncionario().getNome());
			System.out.println("---Livros---");
			for(ItemEmprestimo itemLivro: emprestimo.getItens()) {
				Livro livro = new Livro();
				livro = itemLivro.getLivro();
				System.out.println("ID Livro: " + livro.getIdLivro());
				System.out.println("Titulo: " + livro.getTitulo());
			}
			if(emprestimo.getDevolvido() == true) {
				System.out.println("Situação: Devolvido");
				System.out.println("Data devolução: " + formato.format(emprestimo.getDataDevolucao()));
			}else {
				System.out.println("Situação: Em aberto");
			}
			System.out.println("-------------------");
		}else {
			System.out.println("\nEmprestimo não registrado!");
		}
	}
	
	private void devolucaoEmprestimo() {
		String dataEmp;
		Date dataConvert;
		Emprestimo emprestimo = new Emprestimo();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Registrar Devolução***");
		emprestimo.setCodigoEmprestimo(Console.readInt("\nInforme o codigo do emprestimo: "));
		emprestimo = EmprestimoPersistencia.procurarPorCodigo(emprestimo);
		if(emprestimo != null) {
			System.out.println("\n-------------------");
			System.out.println("ID: " + emprestimo.getIdEmprestimo());
			System.out.println("Codigo: " + emprestimo.getCodigoEmprestimo());
			System.out.println("Data emprestimo: " + formato.format(emprestimo.getDataEmprestimo()));
			System.out.println("Cliente: " + emprestimo.getCliente().getNome());
			System.out.println("Funcionario: " + emprestimo.getFuncionario().getNome());
			System.out.println("---Livros---");
			for(ItemEmprestimo itemLivro: emprestimo.getItens()) {
				Livro livro = new Livro();
				livro = itemLivro.getLivro();
				System.out.println("ID Livro: " + livro.getIdLivro());
				System.out.println("Titulo: " + livro.getTitulo());
			}
			if(emprestimo.getDevolvido() == true) {
				System.out.println("Situação: Devolvido");
				System.out.println("Data devolução: " + formato.format(emprestimo.getDataDevolucao()));
			}else {
				System.out.println("Situação: Em aberto");
			}
			System.out.println("-------------------");
			do {
				dataEmp = Console.readString("\nInforme a data da devolução: ");
				dataConvert = EmprestimoNegocio.converterData(dataEmp);
				if(dataConvert != null) {
					emprestimo.setDataDevolucao(dataConvert);
				}else {
					System.out.println("Data invalida!");
				}
			}while(dataConvert == null);
			String resp = Console.readString("Deseja confirmar a operação? ");
			if((resp.equals("S") || resp.equals("s"))) {
				emprestimo.setDevolvido(true);
				for(ItemEmprestimo itemLivro: emprestimo.getItens()) {
					Livro livro = new Livro();
					livro = itemLivro.getLivro();
					livro.setEmprestado(false);
					LivroPersistencia.editar(livro);
				}
				if(EmprestimoPersistencia.editar(emprestimo) == true) {
					System.out.println("\nDevolução realizada com sucesso!");
				}else {
					System.out.println("\nImpossivel realizar devolução no momento!");
				}
			}else {
				System.out.println("\nImpossivel realizar devolução no momento!");
			}			
		}else {
			System.out.println("\nEmprestimo não registrado!");
		}
	}
}
