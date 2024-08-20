package br.edu.up.front;

import java.text.SimpleDateFormat;
import java.util.Date;

import br.edu.up.entidades.Livro;
import br.edu.up.negocio.LivroNegocio;
import br.edu.up.persistencia.LivroPersistencia;

public class AppLivro {
	public AppLivro() {
		int opcao = 0;
		
		do {
			System.out.println("\n\n***Livro***");
			System.out.println("\n1 - Incluir");
			System.out.println("2 - Editar");
			System.out.println("3 - Excluir");
			System.out.println("4 - Localizar");
			System.out.println("5 - Voltar");
			opcao = Console.readInt("Informe a opção: ");
			
			switch(opcao) {
			case 1:
				incluirLivro();
				break;
			case 2:
				editarLivro();
				break;
			case 3:
				excluirLivro();
				break;
			case 4:
				localizarLivro();
				break;
			}
		}while(opcao != 5);
	}
	
	private void incluirLivro() {
		String dataLanc;
		Date dataConvert;
		Livro livro = new Livro(false);
		System.out.println("\n\n***Incluir Livro***");
		livro.setTitulo(Console.readString("\nInforme o titulo: "));
		if(LivroPersistencia.procurarPorTitulo(livro) == null) {
			livro.setGenero(Console.readString("Informe o genero: "));
			livro.setAutor(Console.readString("Informe o autor: "));
			livro.setEditora(Console.readString("Informe a editora: "));
			do {
				dataLanc = Console.readString("Informe a data do lançamento: ");
				dataConvert = LivroNegocio.converterData(dataLanc);
				if(dataConvert != null) {
					livro.setLancamento(dataConvert);
				}else {
					System.out.println("Data invalida!");
				}
			}while(dataConvert == null);
			String resp = Console.readString("Deseja confirmar a operação? ");
			if((resp.equals("S")) || (resp.equals("s"))) {
				if(LivroPersistencia.incluir(livro) == true) {
					System.out.println("\nLivro cadastrado com sucesso!");
				}else {
					System.out.println("\nLivro não pode ser incluso no momento!");
				}
			}else {
				System.out.println("\nLivro não pode ser incluso no momento!");
			}
		}else {
			System.out.println("\nLivro já cadastrado");
		}
	}
	
	private void editarLivro() {
		String dataLanc;
		Date dataConvert;
		Livro livro = new Livro();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Editar Livro***");
		livro.setIdLivro(Console.readInt("\nInforme o ID do Livro que deseja editar: "));
		livro = LivroPersistencia.procurarPorID(livro);
		if(livro != null) {
			System.out.println("\n-------------------");
			System.out.println("ID: " + livro.getIdLivro());
			System.out.println("Titulo: " + livro.getTitulo());
			System.out.println("Genero: " + livro.getGenero());
			System.out.println("Autor: " + livro.getAutor());
			System.out.println("Editora: " + livro.getEditora());
			System.out.println("Data Lançamento: " + formato.format(livro.getLancamento()));
			if(livro.getEmprestado() == true) {
				System.out.println("Situação: Emprestado");
			}else {
				System.out.println("Situação: Biblioteca");
			}
			System.out.println("-------------------");
			livro.setTitulo(Console.readString("\nInforme o titulo: "));
			livro.setGenero(Console.readString("Informe o genero: "));
			livro.setAutor(Console.readString("Informe o autor: "));
			livro.setEditora(Console.readString("Informe a editora: "));
			do {
				dataLanc = Console.readString("Informe a data do lançamento: ");
				dataConvert = LivroNegocio.converterData(dataLanc);
				if(dataConvert != null) {
					livro.setLancamento(dataConvert);
				}else {
					System.out.println("Data invalida!");
				}
			}while(dataConvert == null);
			String resp = Console.readString("Deseja confirmar a operação? ");
			if((resp.equals("S")) || (resp.equals("s"))) {
				if(LivroPersistencia.editar(livro) == true) {
					System.out.println("\nLivro editado com sucesso!");
				}else {
					System.out.println("\nLivro não pode ser editado no momento!");
				}
			}else {
				System.out.println("\nLivro não pode ser editado no momento!");
			}			
		}else {
			System.out.println("\nLivro não cadastrado!");
		}
	}
	
	private void excluirLivro() {
		Livro livro = new Livro();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Excluir Livro***");
		livro.setIdLivro(Console.readInt("\nInforme o ID do produto que deseja excluir: "));
		livro = LivroPersistencia.procurarPorID(livro);
		if(livro != null) {
			System.out.println("\n-------------------");
			System.out.println("ID: " + livro.getIdLivro());
			System.out.println("Titulo: " + livro.getTitulo());
			System.out.println("Genero: " + livro.getGenero());
			System.out.println("Autor: " + livro.getAutor());
			System.out.println("Editora: " + livro.getEditora());
			System.out.println("Data Lançamento: " + formato.format(livro.getLancamento()));
			if(livro.getEmprestado() == true) {
				System.out.println("Situação: Emprestado");
			}else {
				System.out.println("Situação: Biblioteca");
			}
			System.out.println("-------------------");
			String resp = Console.readString("Deseja realmente excluir o Livro localizado? ");
			if((resp.equals("S")) || (resp.equals("s"))){
				if(LivroPersistencia.excluir(livro) == true) {
					System.out.println("\nLivro excluido com sucesso!");
				}else {
					System.out.println("\nNão foi possivel excluir o Livro no momento!");
				}
			}else {
				System.out.println("\nNão foi possivel excluir o Livro no momento!");
			}
		}else {
			System.out.println("\nLivro não cadastrado!");
		}
	}
	
	private void localizarLivro() {
		Livro livro = new Livro();
		SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
		System.out.println("\n\n***Localizar Livro***");
		livro.setIdLivro(Console.readInt("\nInforme o ID do produto que deseja localizar: "));
		livro = LivroPersistencia.procurarPorID(livro);
		if(livro != null) {
			System.out.println("\n-------------------");
			System.out.println("ID: " + livro.getIdLivro());
			System.out.println("Titulo: " + livro.getTitulo());
			System.out.println("Genero: " + livro.getGenero());
			System.out.println("Autor: " + livro.getAutor());
			System.out.println("Editora: " + livro.getEditora());
			System.out.println("Data Lançamento: " + formato.format(livro.getLancamento()));
			if(livro.getEmprestado() == true) {
				System.out.println("Situação: Emprestado");
			}else {
				System.out.println("Situação: Biblioteca");
			}
			System.out.println("-------------------");
		}else {
			System.out.println("\nLivro não cadastrado!");
		}
	}
}
