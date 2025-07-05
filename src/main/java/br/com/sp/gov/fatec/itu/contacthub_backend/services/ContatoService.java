package br.com.sp.gov.fatec.itu.contacthub_backend.services;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import br.com.sp.gov.fatec.itu.contacthub_backend.entities.Contato;
import br.com.sp.gov.fatec.itu.contacthub_backend.repositories.ContatoRepository;
import br.com.sp.gov.fatec.itu.contacthub_backend.repositories.spec.ContatoSpecs;

@Service
public class ContatoService {
    
    private ContatoRepository contatoRepository;

    public ContatoService(ContatoRepository contatoRepository) {
        this.contatoRepository = contatoRepository;
    }
    
    public List<Contato> pesquisar(String filtro, Long categoriaId, Boolean favorito) {
        // Cria uma especificação base que não filtra nada
        Specification<Contato> spec = (root, query, builder) -> builder.conjunction();

        // Adiciona o filtro de texto dinâmico se ele for fornecido
        if (filtro != null && !filtro.isBlank()) {
            spec = spec.and(ContatoSpecs.comFiltroDinamico(filtro));
        }

        // Adiciona o filtro por categoria se o ID for fornecido
        if (categoriaId != null) {
            spec = spec.and(ContatoSpecs.porCategoria(categoriaId));
        }
        
        // Adiciona o filtro de favoritos se for solicitado
        if (favorito != null && favorito) {
            spec = spec.and(ContatoSpecs.isFavorito());
        }

        return contatoRepository.findAll(spec);
    }

    public Contato buscarPorId(Long id){
        return contatoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contato não encontrado a partir do id: " + id));
    }

    public Contato criar(Contato contato){
        return contatoRepository.save(contato);
    }

    public Contato atualizar(Long id, Contato contato){
        Contato contatoExistente = buscarPorId(id);

        contatoExistente.setNome(contato.getNome());
        contatoExistente.setFotoUrl(contato.getFotoUrl());
        contatoExistente.setEmailPrincipal(contato.getEmailPrincipal());
        contatoExistente.setTelefonePrincipal(contato.getTelefonePrincipal());
        contatoExistente.setEmpresa(contato.getEmpresa());
        contatoExistente.setCargo(contato.getCargo());
        contatoExistente.setAniversario(contato.getAniversario());
        contatoExistente.setEndereco(contato.getEndereco());
        contatoExistente.setNotas(contato.getNotas());
        contatoExistente.setCategoria(contato.getCategoria());
        contatoExistente.setFavorito(contato.isFavorito());

        return contatoRepository.save(contatoExistente);
    }

    public void deletar(Long id){
        if(!contatoRepository.existsById(id)){
            throw new RuntimeException("Contato não encontrado com o ID: " + id);
        }
        contatoRepository.deleteById(id);
    }

    public Contato alterarFavorito(Long id){
        Contato contato = buscarPorId(id);
        contato.setFavorito(!contato.isFavorito());
        return contatoRepository.save(contato);
    }
}
