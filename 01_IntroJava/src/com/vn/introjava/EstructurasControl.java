/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

/**
 *
 * @author pc
 */
public class EstructurasControl {
     
    public static void ejecutarBucles() {
        char arraychar[] = {'a', 'B', '8', '*'};
        int index = 0;

        while (index < arraychar.length) {
            System.out.println("Index = " + index + ", char " + arraychar[index]);
            index++;

        }

        for (index = 0; index < arraychar.length; index++) {
            System.out.println("Index = " + index + ", char " + arraychar[index]);
        }

        index = 0;
        do {
            System.out.println("Index = " + index + ", char " + arraychar[index]);
            index++;
        } while (index < arraychar.length);

        for (char caracter : arraychar) {
            System.out.println("char = " + caracter);
        }
    }

    public static void ejecutarCondiciones() {
        if ("Palabra".length() > 5) {  // condicional simple
            System.out.println("Palabra larga");
        }

        //condicionales compuestos
        if ("Texto".length() > 5) {
            //por aqui no entra
        } else {
            System.out.println("Palabra corta");
        }

        if ("En un lugar de la macha".contains("lugar")) {
            System.out.println("Tiene LUGAR");
        } else if ("En un lugar de la mancha...".contains("MANCHA")) {

        } else if ("En un lugar de la mancha...".contains("otro")) {
            System.out.println("Tiene OTRO");
        } else {
            System.out.println("No tiene ninguno por que esta en mayuscula");
        }

        //switch
        int numeroPequeño = 0;
        switch (numeroPequeño + 5 - 5) {
            case 0:
                System.out.println("Num peq vale cero.");
                break;
            case 1:
                System.out.println("Num peq vale 1");
                break;
            case 2:
                System.out.println("Num peq vale 2");
                break;
            default:
                System.out.println("Nun peq vale mucho");
                break;
        }
    }

}
