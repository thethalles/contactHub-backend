package br.com.sp.gov.fatec.itu.contacthub_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sp.gov.fatec.itu.contacthub_backend.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
