package br.com.ada.first973.aulas.revisaoPOO.generics;

import br.com.ada.first973.aulas.revisaoPOO.collections.Carro;

import java.util.ArrayList;

public class AulaGenerics {

    public static void main(String[] args) {

        ArrayList<String> cidades = new ArrayList();
        cidades.add("Sao Paulo");
        cidades.add("Rio de Janeiro");
        cidades.add("Campinas");

        for (String c : cidades) {
            System.out.println(c);
        }

        Object[] arrayCarros = new Object[5];
        for (Object c : arrayCarros) {
            Carro carro = (Carro) c;
            System.out.println(carro);
        }

        new Carro().compareTo(new Carro());

    }

}
