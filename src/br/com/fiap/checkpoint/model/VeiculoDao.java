package br.com.fiap.checkpoint.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VeiculoDao {

    private Map<String, Veiculo> veiculos = new HashMap<>();

    public boolean cadastrar(Veiculo veiculo) {
        if (veiculos.containsKey(veiculo.getPlaca())) {
            return false;
        }
        veiculos.put(veiculo.getPlaca(), veiculo);
        return true;
    }

    public List<Veiculo> listar() {
        return new ArrayList<>(veiculos.values());
    }

    public Veiculo pesquisarPorPlaca(String placa) {
        return veiculos.get(placa);
    }

    public boolean editar(String placa, String novoModelo, double novoPreco) {
        Veiculo veiculo = veiculos.get(placa);
        if (veiculo == null) {
            return false;
        }
        veiculo.setModelo(novoModelo);
        veiculo.setPreco(novoPreco);
        return true;
    }

    public boolean remover(String placa) {
        return veiculos.remove(placa) != null;
    }

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

