package br.com.sp.gov.fatec.itu.contacthub_backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.sp.gov.fatec.itu.contacthub_backend.entities.Categoria;
import br.com.sp.gov.fatec.itu.contacthub_backend.repositories.CategoriaRepository;

@Service
public final class CategoriaService {

    private CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o id: " + id));
    }

    public Categoria criar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long id, Categoria categoria) {
        Categoria existente = buscarPorId(id);
        existente.setNome(categoria.getNome());
        return categoriaRepository.save(existente);
    }

    public void deletar(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoria não encontrada com o id: " + id);
        }
        categoriaRepository.deleteById(id);
    }
}
