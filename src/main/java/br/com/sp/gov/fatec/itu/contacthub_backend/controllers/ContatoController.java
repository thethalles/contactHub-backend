package br.com.sp.gov.fatec.itu.contacthub_backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sp.gov.fatec.itu.contacthub_backend.entities.Contato;
import br.com.sp.gov.fatec.itu.contacthub_backend.services.ContatoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("contatos")
@CrossOrigin
public class ContatoController {

    @Autowired
    private ContatoService contatoService;

    @GetMapping
    public ResponseEntity<List<Contato>> pesquisar(
            @RequestParam(required = false) String filtro,
            @RequestParam(required = false) Long categoriaId,
            @RequestParam(required = false) Boolean favorito) {
        return ResponseEntity.ok(contatoService.pesquisar(filtro, categoriaId, favorito));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contato> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(contatoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Contato> criar(@RequestParam Contato contato){
        Contato novo = contatoService.criar(contato);
        return ResponseEntity.created(null).body(novo);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> atualizar(@PathVariable Long id, @RequestBody Contato contato){
        contatoService.atualizar(id, contato);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        contatoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}/favorito")
    public ResponseEntity<Contato> alterarFavorito(@PathVariable Long id) {
        Contato contato = contatoService.alterarFavorito(id);
        return ResponseEntity.ok(contato);
    }
}
