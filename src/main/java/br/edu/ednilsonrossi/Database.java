package br.edu.ednilsonrossi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Database {
	private static Database instance;
	
	private List<Aluno> alunos;
	
	private Database() {
		alunos = new LinkedList<Aluno>();
	}
	
	public static Database getInstance() {
		if (instance == null) {
			instance = new Database();
		}
		return instance;
	}
	
	public void insert(Aluno aluno) {
		if (aluno != null) {
			alunos.add(aluno);
		}
	}
	
	public List<Aluno> findAll() {
		return new ArrayList<Aluno>(alunos);
	}
	
	public List<Aluno> findByCurso(String curso) {
		return alunos.stream()
				.filter(a -> a.getCursos().contains(curso))
				.collect(Collectors.toList());
	}
	
}
