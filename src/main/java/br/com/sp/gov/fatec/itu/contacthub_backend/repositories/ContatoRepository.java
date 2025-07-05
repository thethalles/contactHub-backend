package br.com.sp.gov.fatec.itu.contacthub_backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.sp.gov.fatec.itu.contacthub_backend.entities.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>, JpaSpecificationExecutor<Contato> {
    
}
