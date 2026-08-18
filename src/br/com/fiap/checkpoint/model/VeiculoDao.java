package br.com.fiap.checkpoint.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VeiculoDao {

    private Map<String, Veiculo> veiculos = new HashMap<>();

    // Cadastrar
    public boolean cadastrar(Veiculo veiculo) {
        if (veiculos.containsKey(veiculo.getPlaca())) {
            return false; // já existe um veículo com essa placa
        }
        veiculos.put(veiculo.getPlaca(), veiculo);
        return true;
    }

    // Listar todos
    public List<Veiculo> listar() {
        return new ArrayList<>(veiculos.values());
    }

    // Pesquisar por placa
    public Veiculo pesquisarPorPlaca(String placa) {
        return veiculos.get(placa);
    }

    // Editar (atualiza modelo e preço de um veículo já existente)
    public boolean editar(String placa, String novoModelo, double novoPreco) {
        Veiculo veiculo = veiculos.get(placa);
        if (veiculo == null) {
            return false;
        }
        veiculo.setModelo(novoModelo);
        veiculo.setPreco(novoPreco);
        return true;
    }

    // Remover
    public boolean remover(String placa) {
        return veiculos.remove(placa) != null;
    }

    // Pesquisar por modelo (outro atributo, como pede o enunciado)
    public List<Veiculo> pesquisarPorModelo(String modelo) {
        List<Veiculo> encontrados = new ArrayList<>();
        for (Veiculo veiculo : veiculos.values()) {
            if (veiculo.getModelo().toLowerCase().contains(modelo.toLowerCase())) {
                encontrados.add(veiculo);
            }
        }
        return encontrados;
    }
}

