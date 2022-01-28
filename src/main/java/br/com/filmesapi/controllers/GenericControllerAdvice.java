package br.com.filmesapi.controllers;

import br.com.filmesapi.exception.FilmeExistenteException;
import br.com.filmesapi.exception.IdExistenteException;
import br.com.filmesapi.exception.NotaInvalidaException;
import br.com.filmesapi.exception.RecursoNaoEncontradoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GenericControllerAdvice {
  private Logger LOGGER = LoggerFactory.getLogger(GenericControllerAdvice.class);

  @ExceptionHandler({RecursoNaoEncontradoException.class})
  public ResponseEntity<String> recursoNaoEncontradoExceptionHandler(
      final RecursoNaoEncontradoException recursoNaoEncontradoException) {
    LOGGER.info(recursoNaoEncontradoException.getMessage());
    return new ResponseEntity<>(recursoNaoEncontradoException.getMessage(), HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({IdExistenteException.class})
  public ResponseEntity<String> idExistenteExceptionHandler(
          final IdExistenteException idExistenteException) {
    LOGGER.info(idExistenteException.getMessage());
    return new ResponseEntity<>(idExistenteException.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({NotaInvalidaException.class})
  public ResponseEntity<String> notaInvalidaExceptionHandler(
          final NotaInvalidaException notaInvalidaException) {
    LOGGER.info(notaInvalidaException.getMessage());
    return new ResponseEntity<>(notaInvalidaException.getMessage(), HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({FilmeExistenteException.class})
  public ResponseEntity<String> filmeExistenteExceptionHandler(
          final FilmeExistenteException filmeExistenteException) {
    LOGGER.info(filmeExistenteException.getMessage());
    return new ResponseEntity<>(filmeExistenteException.getMessage(), HttpStatus.BAD_REQUEST);
  }
}
