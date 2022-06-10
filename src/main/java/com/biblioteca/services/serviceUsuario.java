package com.biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.entities.Usuario;
import com.biblioteca.repository.RepositorioUsuario;

@Service
public class serviceUsuario {
	
	@Autowired
	private RepositorioUsuario service;
	
	
	public List<Usuario> findAll(){
		return service.findAll();
	}
	
	public Usuario findById(long id) {
		return service.findById(id).get();
	}
	
	public Usuario insert(Usuario obj) {
		return service.save(obj);
	}
	
	public void delete(long id) {
		findById(id);
		service.deleteById(id);
	}
	
	public Usuario update(Usuario obj) {
		Usuario usuario = service.findById(obj.getId()).get();
		updateData(usuario,obj);
		return service.save(usuario);
	}

	private void updateData(Usuario usuario, Usuario obj) {
		usuario.setNome(obj.getNome());
		usuario.setEmail(obj.getEmail());
		usuario.setLogin(obj.getLogin());
		usuario.setSenha(obj.getSenha());
	}
}