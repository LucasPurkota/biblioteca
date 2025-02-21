package br.edu.up.entidades;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Emprestimo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEmprestimo;
	private String codigoEmprestimo;
	private Date dataEmprestimo;
	@OneToOne
	private Cliente cliente;
	@OneToOne
	private Funcionario funcionario;
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<ItemEmprestimo> itens = new ArrayList<ItemEmprestimo>();
	private Date dataDevolucao;
	private boolean devolvido;
	
	public Emprestimo(boolean devolvido) {
		this.devolvido = devolvido;
	}
	
	public Emprestimo() {
	}
	
	public int getIdEmprestimo() {
		return idEmprestimo;
	}
	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}
	public String getCodigoEmprestimo() {
		return codigoEmprestimo;
	}
	public void setCodigoEmprestimo(String codigoEmprestimo) {
		this.codigoEmprestimo = codigoEmprestimo;
	}
	public Date getDataEmprestimo() {
		return dataEmprestimo;
	}
	public void setDataEmprestimo(Date dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
//	public List<ItemEmprestimo> getItens() {
//		return itens;
//	}
//	public void setItens(List<ItemEmprestimo> itens) {
//		this.itens = itens;
//	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public boolean getDevolvido() {
		return devolvido;
	}
	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}
}
