package br.edu.up.presistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidades.Emprestimo;

public class EmprestimoPersistencia {
	public static boolean incluir(Emprestimo emprestimo) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(emprestimo);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean editar(Emprestimo emprestimo) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(emprestimo);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean excluir(Emprestimo emprestimo) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(emprestimo);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Emprestimo procurarPorCodigo(Emprestimo emprestimo) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Emprestimo where codigoEmprestimo = :param");
		consulta.setParameter("param", emprestimo.getCodigoEmprestimo());
		List<Emprestimo> emprestimos = consulta.getResultList();
		if(!emprestimos.isEmpty()) {
			return emprestimos.get(0);
		}
		return null;
	}
	
	public static Emprestimo procurarPorID(Emprestimo emprestimo) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Emprestimo where codigoEmprestimo = :param");
		consulta.setParameter("param", emprestimo.getIdEmprestimo());
		List<Emprestimo> emprestimos = consulta.getResultList();
		if(!emprestimos.isEmpty()) {
			return emprestimos.get(0);
		}
		return null;
	}
}
