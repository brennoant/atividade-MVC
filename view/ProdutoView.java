package view;

import java.util.List;
import java.util.Scanner;

import model.Produto;

public class ProdutoView {

    private final Scanner scanner = new Scanner(System.in);

    public int exibirMenu() {
        System.out.println();
        System.out.println("===== CADASTRO DE PRODUTOS =====");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = lerInteiro();
        System.out.println();
        return opcao;
    }

    public String pedirNome() {
        System.out.print("Nome do produto: ");
        return scanner.nextLine();
    }

    public double pedirPreco() {
        while (true) {
            System.out.print("Preço do produto: ");
            String entrada = scanner.nextLine().trim().replace(",", ".");
            try {
                double preco = Double.parseDouble(entrada);
                System.out.println();
                return preco;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido (ex.: 59.90).");
            }
        }
    }

    public void exibirProduto(int id, String nome, double preco) {
        System.out.printf("#%d | Produto: %s | Preço: R$ %.2f%n", id, nome, preco);
    }

    public void exibirLista(List<Produto> produtos) {
        System.out.println("----- PRODUTOS CADASTRADOS -----");
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }
        for (Produto p : produtos) {
            exibirProduto(p.getId(), p.getNome(), p.getPreco());
        }
        System.out.println("Total: " + produtos.size() + " produto(s).");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirErro(String erro) {
        System.out.println("Erro: " + erro);
    }

    private int lerInteiro() {
        if (!scanner.hasNextLine()) {
            return 0;
        }
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
