package br.com.filmesapi.repositories;

import br.com.filmesapi.entities.Filme;

import java.util.List;

public interface IFilmeRepository {
    List<Filme> findAll();

    Filme findById(Integer id);

    void add(Filme filme);

    void update(Integer id, Filme filme);

    void delete(Integer id);

    int getCount();
}
