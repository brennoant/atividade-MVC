package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Produto {

    private static final List<Produto> produtos = new ArrayList<>();
    private static int proximoId = 1;

    private final int id;
    private final String nome;
    private final double preco;

    public Produto(String nome, double preco) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do produto não pode ser vazio.");
        }
        if (preco < 0) {
            throw new IllegalArgumentException("O preço não pode ser negativo.");
        }
        this.id = proximoId++;
        this.nome = nome.trim();
        this.preco = preco;
    }

    public void salvar() {
        produtos.add(this);
    }

    public static List<Produto> listarTodos() {
        return Collections.unmodifiableList(produtos);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}
