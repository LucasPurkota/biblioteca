package br.edu.up.entidades;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Livro {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idLivro;
	private String codigo;
	private String titulo;
	private String genero;
	private String autor;
	private String editora;
	private Date lancamento;
	private boolean emprestado;
	private boolean inativo;

	public Livro(boolean emprestado) {
		this.emprestado = emprestado;
	}
	
	public Livro() {
		
	}
	
	public int getIdLivro() {
		return idLivro;
	}
	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public Date getLancamento() {
		return lancamento;
	}
	public void setLancamento(Date lancamento) {
		this.lancamento = lancamento;
	}
	public boolean getEmprestado() {
		return emprestado;
	}
	public void setEmprestado(boolean emprestado) {
		this.emprestado = emprestado;
	}
	public boolean getInativo() {
		return inativo;
	}
	public void setInativo(boolean inativo) {
		this.inativo = inativo;
	}
	
	@Override
    public String toString() {
        return this.titulo;
    }
}

