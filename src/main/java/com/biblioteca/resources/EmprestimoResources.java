package com.biblioteca.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.entities.Emprestimo;
import com.biblioteca.requests.EmprestimosPostRequestBody;
import com.biblioteca.requests.EmprestimosPutRequestBody;
import com.biblioteca.services.serviceEmprestimo;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/emprestimos")
@RequiredArgsConstructor
public class EmprestimoResources {

	private final serviceEmprestimo serviceEmprestimo;
	
	@GetMapping
	public ResponseEntity<List<Emprestimo>> findAll(){
		return ResponseEntity.ok(serviceEmprestimo.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Emprestimo> findById(@PathVariable long id){
		return ResponseEntity.ok(serviceEmprestimo.findByIdOrElseThrowResourceNotFoundException(id));
	}
	
	//http://localhost:8080/emprestimos/2/2
	@PostMapping(path = "/{idUsuario}/{idLivro}")
	public ResponseEntity<Emprestimo> insert(@PathVariable long idUsuario,  @RequestBody @Valid EmprestimosPostRequestBody emprestimosPostRequestBody, @PathVariable long idLivro){
		return new ResponseEntity<Emprestimo>(serviceEmprestimo.insert(idUsuario,emprestimosPostRequestBody,idLivro), HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id){
		serviceEmprestimo.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	
	
	@PutMapping
	public ResponseEntity<Void> update(@RequestBody EmprestimosPutRequestBody emprestimosPutRequestBody){
		serviceEmprestimo.update(emprestimosPutRequestBody);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}

//so inserir livro se o livro for do usuario colocar livro e emprestimo no cascade all para ver o que acontece
