package com.funtec.academia.digital.service;

import java.util.List;

import com.funtec.academia.digital.entity.Aluno;
import com.funtec.academia.digital.entity.form.AlunoForm;
import com.funtec.academia.digital.entity.form.AlunoUpdateForm;

public interface IAlunoService {
	public Aluno create(AlunoForm form);
	public Aluno get(Long id);
	public List<Aluno> getAll(String dataDeNascimento);
	public Aluno update(Long id, AlunoUpdateForm formUpdate);
	public void delete(Long id);
}
