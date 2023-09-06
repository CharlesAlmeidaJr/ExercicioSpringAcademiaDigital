package com.funtec.academia.digital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.funtec.academia.digital.entity.Aluno;
import com.funtec.academia.digital.entity.form.AlunoForm;
import com.funtec.academia.digital.service.impl.AlunoServiceImpl;

@RestController
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired //chamando o service
	private AlunoServiceImpl service;
	
	@PostMapping
	public Aluno create(@RequestBody AlunoForm form) {
		return service.create(form);
	}
	
	@GetMapping
	public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento){
		return service.getAll(dataDeNascimento);
	}
	
}
