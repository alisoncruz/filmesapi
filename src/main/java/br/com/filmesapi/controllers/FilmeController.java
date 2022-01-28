package br.com.filmesapi.controllers;

import br.com.filmesapi.entities.Filme;
import br.com.filmesapi.services.IFilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

  @Autowired private IFilmeService iFilmeService;

  @GetMapping
  public ResponseEntity<List<Filme>> findAll() {
    List<Filme> filmes = this.iFilmeService.findAll();
    return ResponseEntity.ok(filmes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Filme> findById(@PathVariable("id") final Integer id) {
    Filme filme = this.iFilmeService.findById(id);
    return ResponseEntity.ok(filme);
  }

  @PostMapping
  public ResponseEntity create(@RequestBody final Filme filme) {
    this.iFilmeService.add(filme);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity update(
      @PathVariable("id") final Integer id, @RequestBody final Filme filme) {
    this.iFilmeService.update(id, filme);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") final Integer id) {
    this.iFilmeService.delete(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
