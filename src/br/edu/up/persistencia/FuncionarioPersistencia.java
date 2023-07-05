package br.edu.up.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.entidades.Funcionario;

public class FuncionarioPersistencia {
	public static boolean incluir(Funcionario funcionario) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(funcionario);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean editar(Funcionario funcionario) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(funcionario);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
	public static boolean excluir(Funcionario funcionario) {
		try {
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(funcionario);
			manager.getTransaction().commit();
			return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	
	public static Funcionario procuraPorCPF(Funcionario funcionario) {
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Funcionario where cpf = :param");
		consulta.setParameter("param", funcionario.getCpf());
		List <Funcionario> funcionarios = consulta.getResultList();
		if(!funcionarios.isEmpty()) {
			return funcionarios.get(0);
		}
		return null;
	}
}
