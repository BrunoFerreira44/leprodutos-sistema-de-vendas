package br.com.bruno.leprodutos.infrastructure.exception;

public class VendaNaoExistente extends RuntimeException {
    public VendaNaoExistente(String message) {
        super(message);
    }
}