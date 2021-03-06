package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.biblioteca.entities.Editora;

@Repository
public interface RepositorioEditora extends JpaRepository<Editora, Long>{

}
