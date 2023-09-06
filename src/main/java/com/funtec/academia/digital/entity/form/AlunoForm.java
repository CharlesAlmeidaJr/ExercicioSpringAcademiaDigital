package com.funtec.academia.digital.entity.form;

import java.time.LocalDate;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {
	
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max = 80, message = "'${valitadedValue}' precisa ter entre {min} e {max} caracteres.")
	private String nome;
	@NotEmpty(message = "Preencha o campo corretamente.")
	private String cpf;
	@NotEmpty(message = "Preencha o campo corretamente.")
	@Size(min = 3, max = 80, message = "'${valitadedValue}' precisa ter entre {min} e {max} caracteres.")
	private String bairro;
	@NotNull(message = "Preencha o campo corretamente.")
	@Past(message = "Data '${valitadedValue}' é inválida.")
	private LocalDate dataDeNascimento;
}
