package br.com.ada.first973.aulas.revisaoPOO;

public class TesteOverflowInt {

    public static void main(String[] args) {

        //-2147483648 .. 2147483647

        int i= 2147483647;
        System.out.println(i);
        System.out.println(i++);
        System.out.println(i++);
        System.out.println(i++);
        System.out.println(i++);

    }

}
