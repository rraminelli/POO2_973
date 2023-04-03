package br.com.ada.first973.aulas.revisaoPOO.collections;

import java.util.Objects;

public class Carro implements Comparable<Carro> {

    /*public enum TipoCarro {
        PASSEIO,
        MOTO,
        CAMINHAO
    }*/

    private String codigo;
    private String marca;
    private String modelo;
    private Double preco;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(marca, carro.marca) && Objects.equals(modelo, carro.modelo) && Objects.equals(preco, carro.preco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, preco);
    }

    @Override
    public int compareTo(Carro carro) {
        return carro.marca.compareTo(this.marca);
    }

}
