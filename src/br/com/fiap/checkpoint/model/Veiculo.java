package br.com.fiap.checkpoint.model;

public abstract class Veiculo {

    private String placa;
    private String modelo;
    private int ano;
    private double preco;

    public Veiculo(String placa, String modelo, int ano, double preco) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco >= 0) {
            this.preco = preco;
        }
    }

    /**
     * Método abstrato: cada tipo de veículo calcula o valor final
     * de um jeito diferente (usado depois via POLIMORFISMO).
     */
    public abstract double calcularValorFinal();

    /**
     * Método concreto que é sobrescrito pelas subclasses (polimorfismo).
     */
    public String exibirDetalhes() {
        return "Placa: " + placa +
                " | Modelo: " + modelo +
                " | Ano: " + ano +
                " | Preço tabela: R$ " + String.format("%.2f", preco) +
                " | Valor final: R$ " + String.format("%.2f", calcularValorFinal());
    }

    @Override
    public String toString() {
        return exibirDetalhes();
    }
}

