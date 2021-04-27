package com.example.demo.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DisciplinaDTO;
import com.example.demo.entidades.Disciplina;
import com.example.demo.servicos.Servico;

@RestController
public class Controlador {
	
	@Autowired
	private Servico servico;
	

	public Controlador(Servico servico) {
		super();
		this.servico = servico;
	}

	@PostMapping("/v1/api/disciplinas")
	public ResponseEntity<Disciplina> addDisciplina(@RequestBody DisciplinaDTO disciplinaDto){		
		return new ResponseEntity<Disciplina>(servico.addDisciplina(disciplinaDto),
				HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/api/disciplinas")
	public ResponseEntity<List<Disciplina>> listarDisciplinas(){
		return new ResponseEntity<List<Disciplina>> (servico.listarDisciplinas(), HttpStatus.OK);
		
	}
	
	@GetMapping("/v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> visualizarDisciplina(@PathVariable int id){
		try {
			return new ResponseEntity<Disciplina> (servico.visualizarDisciplina (id), HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<Disciplina> (HttpStatus.NOT_FOUND);
			
		}	
	}
	
	@PatchMapping("/v1/api/disciplinas/{id}/nome")
	public ResponseEntity<Disciplina> atualizarNome(@PathVariable int id, @RequestBody DisciplinaDTO disciplinaDto){
		try {
			return new ResponseEntity<Disciplina> (servico.atualizarNome(id, disciplinaDto), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Disciplina> (HttpStatus.NOT_FOUND);
		}
	}
	
	@PatchMapping("/v1/api/disciplinas/{id}/nota")
	public ResponseEntity<Disciplina> atualizarNota(@PathVariable int id, @RequestBody DisciplinaDTO disciplinaDto){
		try {
			return new ResponseEntity<Disciplina> (servico.atualizarNota(id, disciplinaDto), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Disciplina> (HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("v1/api/disciplinas/{id}")
	public ResponseEntity<Disciplina> excluirDisciplina(@PathVariable int id) {
		try {
			return new ResponseEntity<Disciplina> (servico.excluirDisciplina(id), HttpStatus.OK);
		}catch(Exception e) {
				return new ResponseEntity<Disciplina>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/v1/api/disciplinas/ranking")
	public ResponseEntity<List<Disciplina>> ranking() {
		return new ResponseEntity<List<Disciplina>> (servico.ranking(), HttpStatus.OK);
	}
}























