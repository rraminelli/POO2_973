package br.com.ada.first973.aulas.revisaoPOO.collections;

import java.util.HashMap;
import java.util.Map;

public class AulaCollectionsMap {

    public static void main(String[] args) {

        Map<String, Carro> mapCarros = new HashMap<>();

        Carro fiat = new Carro();
        fiat.setMarca("Fiat");
        mapCarros.put("101", fiat);

        Carro volks = new Carro();
        volks.setMarca("Volks");
        mapCarros.put("102", volks);

        Carro fusca = new Carro();
        fusca.setMarca("Volks");
        fusca.setModelo("Fusca");
        mapCarros.put("103", fusca);

        Carro fusca2 = new Carro();
        fusca2.setMarca("Volks");
        fusca2.setModelo("Fusca");
        mapCarros.put("104", fusca2);

        for (String key : mapCarros.keySet()) {
            Carro carro = mapCarros.get(key);
            System.out.println(key + " - " + carro);
        }

        Carro fuscaCodigo104 = mapCarros.get("105");
        System.out.println(fuscaCodigo104);

    }

}
