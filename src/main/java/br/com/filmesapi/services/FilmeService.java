package br.com.filmesapi.services;

import br.com.filmesapi.entities.Filme;
import br.com.filmesapi.exception.FilmeExistenteException;
import br.com.filmesapi.exception.IdExistenteException;
import br.com.filmesapi.exception.NotaInvalidaException;
import br.com.filmesapi.exception.RecursoNaoEncontradoException;
import br.com.filmesapi.repositories.IFilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Predicate;

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
    ehNotaInvalida(filme);

    existeFilmeId(filme.getId());

    existeNomeAnoDiretor(filme);

    this.iFilmeRepository.add(filme);
  }

  private void ehNotaInvalida(Filme filme) {
    if (filme.getNota() < 1 || filme.getNota() > 5)
      throw new NotaInvalidaException("Nota Inválida");
  }

  private void existeNomeAnoDiretor(Filme filme) {

    boolean existe =
        this.iFilmeRepository.findAll().stream()
            .anyMatch(
                f -> {
                  return f.getNome().equals(filme.getNome())
                      && f.getAno().equals(filme.getAno())
                      && f.getNomeDiretor().equals(filme.getNomeDiretor());
                });
    if (existe)
      throw new FilmeExistenteException(
          String.format(
              "Já existe filme com o nome: %s, diretor: %s e ano: %s",
              filme.getNome(), filme.getNomeDiretor(), filme.getAno()));
  }

  private void existeFilmeId(Integer id) {
    boolean existe = this.iFilmeRepository.findAll().stream().anyMatch(f -> f.getId().equals(id));
    if (existe) throw new IdExistenteException("Já existe filme com o id: " + id);
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
