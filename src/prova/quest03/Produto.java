package prova.quest03;

public class Produto {
    private String nome;
    private String siglaUnidadeDeVenda;
    private double estoqueInicial;
    private double precoUnitarioVenda;
    private double quantidadeDeVendas;

    public Produto(String nome, String siglaUnidadeDeVenda, int estoqueInicial, double precoUnitarioVenda) throws Exception {
        this.nome = nome;
        this.siglaUnidadeDeVenda = siglaUnidadeDeVenda;
        if (estoqueInicial < 0) {
            throw new Exception("Valores incorretos, evite números negativos!");

        } else {
            this.estoqueInicial = estoqueInicial;
        }
        if (precoUnitarioVenda < 0) {
            throw new Exception("Valores incorretos, evite números negativos!");
        } else {
            this.precoUnitarioVenda = precoUnitarioVenda;
        }

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
