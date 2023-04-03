package br.com.ada.first973.aulas.revisaoPOO.collections;

import java.util.*;

public class AulaCollectionsSet {

    public static void main(String[] args) {

        HashSet<Carro> carros = new HashSet<>();

        Carro fiat = new Carro();
        fiat.setMarca("Fiat");
        carros.add(fiat);

        Carro volks = new Carro();
        volks.setMarca("Volks");
        carros.add(volks);

        Carro fusca = new Carro();
        fusca.setMarca("Volks");
        fusca.setModelo("Fusca");
        carros.add(fusca);

        Carro fusca2 = new Carro();
        fusca2.setMarca("Volks");
        fusca2.setModelo("Fusca");
        carros.add(fusca2);

        System.out.println(fusca.equals(fusca2));

        System.out.println(fusca.hashCode());
        System.out.println(fusca2.hashCode());


        List<Carro> carrosList = new ArrayList<>();
        for (Carro c : carros) {
            carrosList.add(c);
        }

        Comparator<Carro> comparatorCarro = new Comparator<Carro>() {
            @Override
            public int compare(Carro carro1, Carro carro2) {
                return carro2.getMarca().compareTo(carro1.getMarca());
            }
        };
        Collections.sort(carrosList, comparatorCarro);

        for (Carro carro : carrosList) {
            System.out.println(carro);
        }

        String nome1 = new String("Igor");
        String nome2 = new String("Igor");
        System.out.println(nome1.equals(nome2));

        //System.out.println(carros.get(0));

    }

}
