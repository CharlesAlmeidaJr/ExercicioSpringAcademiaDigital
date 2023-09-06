package com.funtec.academia.digital.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data serve pra implementar o get e set
//@NoargsContructor cria um contrutor vazio e o hibernate precisa desse contrutor
//@AllArgsConstructor possui todos os atributos
//@Entity para a conexão com o banco, ela precisa de uma chave primaria
//@Table dá nome a tabela
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) - inicialização lenta

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_alunos")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
public class Aluno {
	
	@Id  //chave primária
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	@Column(unique = true) //notacao dizendo que é unico
	private String cpf;
	private String bairro;
	//no java escrevemos com camel case, mas no banco ele ficara Data_de_nascimento
	private LocalDate dataDeNascimento;
	//relacionando com a tabela avaliacaoFisica
	//aluno, tera varias avaliações fisicas
	@OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY) //Retorna as informações de aluno, menos as avaliaçoes (lazy)
	@JsonIgnore
	private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();
	
}
