package br.com.filmesapi.exception;

public class FilmeExistenteException extends RuntimeException {
    public FilmeExistenteException(String message) {
        super(message);
    }
}
