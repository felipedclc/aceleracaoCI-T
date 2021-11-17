package br.com.codenation.livro.controller;

import br.com.codenation.controller.advice.ResourceNotFoundException;
import br.com.codenation.livro.model.Livro;
import br.com.codenation.livro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;
import java.util.List;

@RestController // rest controller serializa a responsta da api
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping
    // java bean validation - so aceita livros que sejam válidos(@Valid)
    public ResponseEntity<Livro> create(@Valid @RequestBody Livro livro) {
        return new ResponseEntity<Livro>(this.livroService.save(livro), HttpStatus.CREATED);
    }

    @PutMapping
    // ResponseEntity - tipo de resposta(res)
    public ResponseEntity<Livro> update(@Valid @RequestBody Livro livro) {
        return new ResponseEntity<Livro>(this.livroService.save(livro), HttpStatus.ACCEPTED);
    }

    @GetMapping
    public Iterable<Livro> findAll(@PathParam("nome") String nome, Pageable pageable) {
        // pageable(paginação) -> /livro?page=0&size=2 [array] - size(opcional)
        // pesquisar os 2 -> /livro?nome=Mindset&page=0
        if (nome != null) {
            // consigo filtrar pelo param "nome" -> /livro?nome=Mindset
            return this.livroService.findByNome(nome.toString(), pageable);
        }
        return this.livroService.findAll(pageable);
    }

    @GetMapping("/{id}") // param
    public ResponseEntity<Livro> findById(@PathVariable("id") Long id) {
        return new ResponseEntity<Livro>(this.livroService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Livro")),HttpStatus.OK);
        // orElseThrow(Optional) retorna um status error
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.livroService.deleteById(id);
    }

    @GetMapping("/byCategoria/{id}")
    public List<Livro> findByCategoria(@PathVariable("id") Long idCategoria) {
        return this.livroService.findByCategoria(idCategoria);
    }

    @GetMapping("/byNomeCategoria/{nome}")
    public List<Livro> findByNomeCategoria(@PathVariable("nome") String nomeCategoria) {
        return this.livroService.findByNomeCategoria(nomeCategoria);
    }

    @GetMapping("/comCategorias")
    public List<Livro> findComCategoria() {
        return this.livroService.findComCategorias();
    }

    @GetMapping("/testException")
    public void testException() {
        Integer x = 2 / 0;
    }

}
