package prova.quest01;

public class Produto {
    private String nome;
    private String siglaUnidadeDeVenda;
    private double estoqueInicial;
    private double precoUnitarioVenda;
    private double quantidadeDeVendas;

    public Produto(String nome, String siglaUnidadeDeVenda, int estoqueInicial, double precoUnitarioVenda) {
        this.nome = nome;
        this.siglaUnidadeDeVenda = siglaUnidadeDeVenda;
        this.estoqueInicial = estoqueInicial;
        this.precoUnitarioVenda = precoUnitarioVenda;
    }

    public double getEstoqueDisponivel() {
        return estoqueInicial - quantidadeDeVendas;
    }

    public boolean adicionarVenda(int quantidade) {
        if (estoqueInicial >= quantidade) {
            quantidadeDeVendas += quantidade;
            estoqueInicial -= quantidade;
            return true;
        } else {
            return false;
        }
    }

    public double getFaturamentoVenda() {
        return quantidadeDeVendas * precoUnitarioVenda;
    }

    public boolean isDisponivel() {
        if (estoqueInicial > 0) {
            return true;
        } else {
            return false;
        }
    }

    public double getPercentEstoqueDisponivel() {
        return ((estoqueInicial - quantidadeDeVendas) * 100) / estoqueInicial;
    }

    public String getNome() {
        return nome;
    }

    public String getSiglaUnidadeDeVenda() {
        return siglaUnidadeDeVenda;
    }

    public double getEstoqueInicial() {
        return estoqueInicial;
    }

    public double getPrecoUnitarioVenda() {
        return precoUnitarioVenda;
    }

    public double getQuantidadeDeVendas() {
        return quantidadeDeVendas;
    }
}
