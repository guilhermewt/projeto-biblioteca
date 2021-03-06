package com.biblioteca.requests;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.biblioteca.entities.Livro;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@Data
@SuperBuilder
public class AutorPostRequestBody implements Serializable{
	/////mapstruct do autor,editora,usuario
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "the autor name cannot be empty")
	private String nome;

	@Builder.Default
	private Set<Livro> livros = new HashSet<>();

	public AutorPostRequestBody(String nome) {
		super();
		this.nome = nome;
	}
}
