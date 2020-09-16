package com.eeep.biblioteca.repository;

import com.eeep.biblioteca.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RepositoryAluno extends JpaRepository<Aluno, Integer> {
}
