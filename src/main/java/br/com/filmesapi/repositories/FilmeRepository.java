package br.com.filmesapi.repositories;

import br.com.filmesapi.entities.Filme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FilmeRepository implements IFilmeRepository {

  private final List<Filme> filmes;

  public FilmeRepository() {
    this.filmes = new ArrayList<>();
  }

  @Override
  public List<Filme> findAll() {
    return this.filmes;
  }

  @Override
  public Filme findById(final Integer id) {
    Filme filme = this.filmes.stream().filter(f -> f.getId().equals(id)).findFirst().orElse(null);
    return filme;
  }

  @Override
  public void add(final Filme filme) {
    this.filmes.add(filme);
  }

  @Override
  public void update(final Integer id, final Filme filme) {
    this.filmes.stream()
        .filter(f -> f.getId().equals(id))
        .forEach(
            f -> {
              f.setNome(filme.getNome());
              f.setNomeDiretor(filme.getNomeDiretor());
              f.setAno(filme.getAno());
              f.setNota(filme.getNota());
            });
  }

  @Override
  public void delete(final Integer id) {
    this.filmes.removeIf(f -> f.getId().equals(id));
  }

  @Override
  public int getCount() {
    return this.filmes.size();
  }
}
