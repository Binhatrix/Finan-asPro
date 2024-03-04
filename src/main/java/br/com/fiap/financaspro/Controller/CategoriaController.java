package br.com.fiap.financaspro.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.fiap.financaspro.model.Categoria;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {
 
    Logger log = LoggerFactory.getLogger(getClass());
    List<Categoria> repository = new ArrayList<>();
 
    @GetMapping
    public List<Categoria> listarCategorias() {
        return repository;
    }
 
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria) {
        log.info("Cadastrando categoria: {}", categoria);
        repository.add(categoria);
        return categoria;
    }
   
    @GetMapping("{id}")
    public ResponseEntity<Categoria> mostraCategoria(@PathVariable Long id){
        log.info("Buscando categoria por id {}", id);
 
        for (Categoria categoria : repository) {
            if (categoria.id().equals(id)) 
                return ResponseEntity.ok(categoria);
        }

        //TODO refatorar com stream 
 
        return ResponseEntity.notFound().build();
    }
 
}