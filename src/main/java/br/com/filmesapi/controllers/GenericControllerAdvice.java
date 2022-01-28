package br.com.filmesapi.controllers;

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
}
