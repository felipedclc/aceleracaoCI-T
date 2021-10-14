package br.com.codenation.livro.repository;


import br.com.codenation.categoria.model.Categoria;
import br.com.codenation.livro.model.Livro;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// não há necessida de colocar a annotation @Repository porque já extende o CrudRepository
public interface LivroRepository extends CrudRepository<Livro, Long> {

    List<Livro> findAll();

    List<Livro> findByTitulo(String titulo); // findByTitulo(spring procura o atributo Titulo)

    List<Livro> findByTituloContaining(String titulo);

    List<Livro> findByCategorias(Categoria categoria);

    @Query("from Livro livro where livro.categorias is not empty") // HQL
    List<Livro> findComCategoria();


    @Query(value = "select * from LIVRO livro " +
            "INNER JOIN LIVRO_CATEGORIA cl " +
            "ON livro.id = cl.id_livro " +
            "INNER JOIN categoria c " +
            "ON c.id = cl.id_categoria " +
            "where c.nome like %:nomeCategoria%", nativeQuery = true) // criando uma query nativa
    List<Livro> findByNomeCategoria(@Param("nomeCategoria") String nomeCategoria);
    //                              @Param - indica para o spring o parâmetro(deve estar igual)
}
