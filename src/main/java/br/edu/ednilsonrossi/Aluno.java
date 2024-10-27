package br.edu.ednilsonrossi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Aluno {
	private String prontuario;
	private String nome;
	private List<String> emails;
	private List<String> cursos;
	
	public Aluno(String prontuario, String nome) {
		this.prontuario = prontuario.toUpperCase();
		this.nome = nome.toUpperCase();
	}
	
	public Aluno(String prontuario, String nome, List<String> emails, List<String> cursos) {
		this(prontuario, nome);
		this.emails = new LinkedList<String>(emails);
		this.cursos = new LinkedList<String>(cursos);
	}

	public String getProntuario() {
		return prontuario;
	}

	public String getNome() {
		return nome;
	}

	public List<String> getEmails() {
		return new ArrayList<String>(emails);
	}

	public List<String> getCursos() {
		return new ArrayList<String>(cursos);
	}
	
}
