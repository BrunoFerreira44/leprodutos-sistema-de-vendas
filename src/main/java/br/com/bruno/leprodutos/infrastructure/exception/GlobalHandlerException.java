package br.com.bruno.leprodutos.infrastructure.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalHandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handleMethodArgumentNotValidException (MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(Map.of(ex.getFieldErrors().get(0).getField(), ex.getFieldErrors().get(0).getDefaultMessage()));
    }

    @ExceptionHandler(VendaNaoExistente.class)
    public ResponseEntity handleVendaNaoExistente (VendaNaoExistente ex) {
        return ResponseEntity.badRequest().body(Map.of("error", ex.getMessage()));
    }
}
