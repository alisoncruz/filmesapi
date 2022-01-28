package br.com.filmesapi.services;

import br.com.filmesapi.entities.Filme;
import br.com.filmesapi.exception.RecursoNaoEncontradoException;
import br.com.filmesapi.repositories.IFilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService implements IFilmeService {

  @Autowired IFilmeRepository iFilmeRepository;

  public List<Filme> findAll() {
    return this.iFilmeRepository.findAll();
  }

  public Filme findById(final Integer integer) {
    Filme filme = this.iFilmeRepository.findById(integer);
    if (filme == null) {
      throw new RecursoNaoEncontradoException("Filme não encontrado");
    }
    return filme;
  }

  public void add(final Filme filme) {
    if (filme.getId() == null) {
      filme.setId(this.iFilmeRepository.getCount() + 1);
    }
    this.iFilmeRepository.add(filme);
  }

  public void update(final Integer id, final Filme filme) {
    findById(id);
    this.iFilmeRepository.update(id, filme);
  }

  public void delete(final Integer id) {
    findById(id);
    this.iFilmeRepository.delete(id);
  }
}
