package br.edu.up.presistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidades.ItemEmprestimo;

public class ItemEmprestimoPersistencia {
	public static boolean incluir(ItemEmprestimo item) {
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(item);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean excluir(ItemEmprestimo item) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(item);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static List<ItemEmprestimo> listarItens(ItemEmprestimo item) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from ItemEmprestimo where emprestimo_idEmprestimo = :param");
		consulta.setParameter("param", item.getEmprestimo().getIdEmprestimo());
		List<ItemEmprestimo> itens = consulta.getResultList();
		return itens;	
	}

}
