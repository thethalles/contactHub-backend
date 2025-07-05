package br.com.sp.gov.fatec.itu.contacthub_backend.repositories.spec;

import org.springframework.data.jpa.domain.Specification;

import br.com.sp.gov.fatec.itu.contacthub_backend.entities.Contato;

public class ContatoSpecs {
    public static Specification<Contato> comFiltroDinamico(String filtro) {
       if (filtro == null || filtro.isEmpty()){
        return null; // se o filtro for null retorna todos os contatos
       } 
       String filtroLike = "%" + filtro.toLowerCase() + "%"; // toLowerCase() transforma o texto do filtro em letras minúsculas
       return (root, query, builder) -> builder.or(
        builder.like(builder.lower(root.get("nome")), filtroLike),
        builder.like(builder.lower(root.get("emailPrincipal")), filtroLike),
        builder.like(builder.lower(root.get("telefonePrincipal")), filtroLike),
        builder.like(builder.lower(root.get("empresa")), filtroLike)
       );
    }

    public static Specification<Contato> porCategoria(Long categoriaId){
        if (categoriaId == null){
            return null;
        }
        return (root, query, builder) -> builder.equal(root.get("categoria"), categoriaId);
    }

    public static Specification<Contato> isFavorito(){
        return (root, query, builder) -> builder.isTrue(root.get("favorito"));
    }
}
