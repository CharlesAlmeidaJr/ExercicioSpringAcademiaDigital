package com.funtec.academia.digital.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.funtec.academia.digital.entity.Aluno;
import com.funtec.academia.digital.entity.form.AlunoForm;
import com.funtec.academia.digital.entity.form.AlunoUpdateForm;
import com.funtec.academia.digital.repository.AlunoRepository;
import com.funtec.academia.digital.service.IAlunoService;

@Service
public class AlunoServiceImpl implements IAlunoService{
	
	@Autowired //chamando repository
	private AlunoRepository repository;

	@Override
	public Aluno create(AlunoForm form) { //aqui com o metodo save iremos salvar no banco de dados
		Aluno aluno = new Aluno();
		aluno.setNome(form.getNome());
		aluno.setCpf(form.getCpf());
		aluno.setBairro(form.getBairro());
		aluno.setDataDeNascimento(form.getDataDeNascimento());
		return repository.save(aluno);
	}

	@Override
	public Aluno get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> getAll(String dataDeNascimento) { //retorna a lista de alunos
		if(dataDeNascimento == null) {
			return repository.findAll();
		} else {
			LocalDate localDate = LocalDate.parse(dataDeNascimento, DateTimeFormatter.ISO_LOCAL_DATE);
		    return repository.findByDataDeNascimento(localDate);
		}
	}

	@Override
	public Aluno update(Long id, AlunoUpdateForm formUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}
	
}
