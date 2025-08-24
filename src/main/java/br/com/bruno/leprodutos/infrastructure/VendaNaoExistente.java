package br.com.bruno.leprodutos.infrastructure;

public class VendaNaoExistente extends RuntimeException {
    public VendaNaoExistente(String message) {
        super(message);
    }
}