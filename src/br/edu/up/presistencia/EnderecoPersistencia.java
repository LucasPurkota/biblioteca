package br.edu.up.presistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidades.Endereco;

public class EnderecoPersistencia {
	public static boolean incluir(Endereco endereco) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(endereco);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean editar(Endereco endereco) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(endereco);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean excluir(Endereco endereco) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(endereco);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static Endereco pequisarPorCEP(Endereco endereco) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Endereco where CEP = :param");
		consulta.setParameter("param", endereco.getCep());
		List<Endereco> enderecos = consulta.getResultList();
		if(!enderecos.isEmpty()) {
			return enderecos.get(0);
		}
		return null;
	}
}
