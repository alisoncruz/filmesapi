package br.com.filmesapi.exception;

public class IdExistenteException extends RuntimeException {
  public IdExistenteException(String message) {
    super(message);
  }
}
