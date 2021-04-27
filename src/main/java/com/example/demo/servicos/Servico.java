package com.example.demo.servicos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.dto.DisciplinaDTO;
import com.example.demo.entidades.Disciplina;

@Service
public class Servico {
	
	private List<Disciplina> disciplinas;
	private int proxId = 0;
	
	public Servico() {
		super();
		disciplinas = new ArrayList<Disciplina>();
	}

	public Disciplina addDisciplina(DisciplinaDTO disciplinaDto) {
		Disciplina disciplina = new Disciplina(
				proxId++,
				disciplinaDto.getNome(), 
				disciplinaDto.getNota()
		);
		disciplinas.add(disciplina);
		
		return disciplina;
	}
	
	public List<Disciplina> listarDisciplinas(){
		return this.disciplinas;
	}
	
	public Disciplina visualizarDisciplina(int id) {
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getId() == id) {
				return disciplina;		
			}
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
	}
	public Disciplina atualizarNome(int id, DisciplinaDTO disciplinaDto) {
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getId() == id) {
				disciplina.setNome(disciplinaDto.getNome());
				return disciplina;
			}
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
	}
	public Disciplina atualizarNota(int id, DisciplinaDTO disciplinaDto) {
		for (Disciplina disciplina  : disciplinas) {
			if (disciplina.getId() == id) {
				disciplina.setNota(disciplinaDto.getNota());
				return disciplina;
			}
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
	}
	public Disciplina excluirDisciplina(int id) {
		for (Disciplina disciplina : disciplinas) {
			if (disciplina.getId() == id) {
				disciplinas.remove(disciplina);
				return disciplina;
			}
		}
		throw new HttpClientErrorException(HttpStatus.NOT_FOUND);	
	}
	
	public List<Disciplina> ranking() {
		Collections.sort(disciplinas);
		return disciplinas;
	}
	

}





















