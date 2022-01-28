package br.com.filmesapi.services;

import br.com.filmesapi.entities.Filme;

import java.util.List;

public interface IFilmeService {
  public List<Filme> findAll();

  public Filme findById(final Integer integer);

  public void add(final Filme filme);

  public void update(final Integer id, final Filme filme);

  public void delete(final Integer id);
}
