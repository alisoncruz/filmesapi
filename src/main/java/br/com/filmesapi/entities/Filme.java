package br.com.filmesapi.entities;

public class Filme {
  private Integer id;
  private String nome;
  private String nomeDiretor;
  Integer ano;
  Integer nota;

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return id;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNomeDiretor(String nomeDiretor) {
    this.nomeDiretor = nomeDiretor;
  }

  public String getNomeDiretor() {
    return nomeDiretor;
  }

  public void setAno(Integer ano) {
    this.ano = ano;
  }

  public Integer getAno() {
    return ano;
  }

  public void setNota(Integer nota) {
    this.nota = nota;
  }

  public Integer getNota() {
    return nota;
  }

}
