package br.com.desafiodio.controller;

import br.com.desafiodio.model.Midia;
import br.com.desafiodio.service.BibliotecaFacade;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/midias")
public class MidiaController {

    private final BibliotecaFacade biblioteca;

    public MidiaController(BibliotecaFacade biblioteca) {
        this.biblioteca = biblioteca;
    }

    @GetMapping
    public List<Midia> listar() {
        return biblioteca.listar();
    }

    @GetMapping("/{id}")
    public Midia buscar(@PathVariable Long id) {
        return biblioteca.buscar(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Midia adicionar(@RequestBody Midia midia) {
        return biblioteca.adicionar(midia);
    }

    @PutMapping("/{id}")
    public Midia atualizar(@PathVariable Long id, @RequestBody Midia midia) {
        return biblioteca.atualizar(id, midia);
    }

    @PatchMapping("/{id}/iniciar")
    public Midia iniciar(@PathVariable Long id) {
        return biblioteca.iniciar(id);
    }

    @PatchMapping("/{id}/finalizar")
    public Midia finalizar(@PathVariable Long id) {
        return biblioteca.finalizar(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long id) {
        biblioteca.remover(id);
    }
}
