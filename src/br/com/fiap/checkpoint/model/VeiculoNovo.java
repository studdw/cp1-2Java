package br.com.fiap.checkpoint.model;

public class VeiculoNovo extends Veiculo {

    private int garantiaMeses;

    public VeiculoNovo(String placa, String modelo, int ano, double preco, int garantiaMeses) {
        super(placa, modelo, ano, preco);
        this.garantiaMeses = garantiaMeses;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    @Override
    public double calcularValorFinal() {
        // Veículo novo não tem desconto, preço cheio de tabela
        return getPreco();
    }

    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + " | Garantia: " + garantiaMeses + " meses | Tipo: Novo (0km)";
    }
}

