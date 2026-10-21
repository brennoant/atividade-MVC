package controller;

import java.util.List;

import model.Produto;
import view.ProdutoView;

public class ProdutoController {

    private final ProdutoView view;

    public ProdutoController(ProdutoView view) {
        this.view = view;
    }

    public void iniciar() {
        int opcao;
        do {
            opcao = view.exibirMenu();
            switch (opcao) {
                case 1 -> cadastrar(view.pedirNome(), view.pedirPreco());
                case 2 -> listar();
                case 0 -> view.exibirMensagem("Encerrando o sistema...");
                default -> view.exibirErro("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public void cadastrar(String nome, double preco) {
        try {
            Produto produto = new Produto(nome, preco);
            produto.salvar();
            view.exibirMensagem("Produto cadastrado com sucesso!");
            view.exibirProduto(produto.getId(), produto.getNome(), produto.getPreco());
        } catch (IllegalArgumentException e) {
            view.exibirErro(e.getMessage());
        }
    }

    public void listar() {
        List<Produto> produtos = Produto.listarTodos();
        view.exibirCabecalhoLista();
        if (produtos.isEmpty()) {
            view.exibirListaVazia();
            return;
        }
        for (Produto p : produtos) {
            view.exibirProduto(p.getId(), p.getNome(), p.getPreco());
        }
        view.exibirTotal(produtos.size());
    }
}
