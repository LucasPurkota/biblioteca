package br.edu.up.entidades;

import javax.persistence.*;

@Entity
public class ItemEmprestimo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idItemEmprestimo;
	@OneToOne
	private Livro livro;
	
	public int getIdItemEmprestimo() {
		return idItemEmprestimo;
	}
	public void setIdItemEmprestimo(int idItemEmprestimo) {
		this.idItemEmprestimo = idItemEmprestimo;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
