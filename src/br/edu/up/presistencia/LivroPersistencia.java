package br.edu.up.presistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidades.Funcionario;
import br.edu.up.entidades.Livro;

public class LivroPersistencia {
	public static boolean incluir(Livro livro) {
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(livro);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean editar(Livro livro) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(livro);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean excluir(Livro livro) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(livro);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Livro procurarPorTitulo(Livro livro) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Livro where titulo = :param");
		consulta.setParameter("param", livro.getTitulo());
		List<Livro> livros = consulta.getResultList();
		if(!livros.isEmpty()) {
			return livros.get(0);
		}
		return null;
	}
	
	public static Livro procurarPorID(Livro livro) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Livro where id = :param");
		consulta.setParameter("param", livro.getIdLivro());
		List<Livro> livros = consulta.getResultList();
		if(!livros.isEmpty()) {
			return livros.get(0);
		}
		return null;
	}
	
	public static Livro procurarPorCodigo(Livro livro) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Livro where codigo = :param");
		consulta.setParameter("param", livro.getCodigo());
		List<Livro> livros = consulta.getResultList();
		if(!livros.isEmpty()) {
			return livros.get(0);
		}
		return null;
	}
	
	public static List<Livro> listarLivro() {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Livro");
		List<Livro> livros = consulta.getResultList();
		return livros;	
	}
}
