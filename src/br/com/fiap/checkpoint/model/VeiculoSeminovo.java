package br.com.fiap.checkpoint.model;

public class VeiculoSeminovo extends Veiculo {

    private int quilometragem;
    private int proprietariosAnteriores;

    public VeiculoSeminovo(String placa, String modelo, int ano, double preco,
                           int quilometragem, int proprietariosAnteriores) {
        super(placa, modelo, ano, preco);
        this.quilometragem = quilometragem;
        this.proprietariosAnteriores = proprietariosAnteriores;
    }

    public int getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem) {
        this.quilometragem = quilometragem;
    }

    public int getProprietariosAnteriores() {
        return proprietariosAnteriores;
    }

    public void setProprietariosAnteriores(int proprietariosAnteriores) {
        this.proprietariosAnteriores = proprietariosAnteriores;
    }

    @Override
    public double calcularValorFinal() {
        // 3% por dono anterior - maximo 15%
        double percentualDesconto = Math.min(proprietariosAnteriores * 0.03, 0.15);
        return getPreco() - (getPreco() * percentualDesconto);
    }

    @Override
    public String exibirDetalhes() {
        return super.exibirDetalhes() + " | KM: " + quilometragem +
                " | Donos anteriores: " + proprietariosAnteriores + " | Tipo: Seminovo";
    }
}

