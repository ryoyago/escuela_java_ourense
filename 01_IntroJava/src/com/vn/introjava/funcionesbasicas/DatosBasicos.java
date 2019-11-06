/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.funcionesbasicas;

/**
 *
 * @author pc
 */
public class DatosBasicos {
     public static void mostrarTiposDatos() {

        byte unByte = -128;
        int unEntero = 200000000; // 4 bytes
        System.out.println("Byte: " + unByte);
        System.out.println("Entero: " + unEntero);
        long enteroLargo = 300000000000000L; // 8 bytes
        System.out.println("Entero largo: " + enteroLargo);
        float unDecimal = 3.3f;//4 bytes 7 u 8 cifras decimales
        System.out.println("Float: " + unDecimal);
        double decimalDoblePrec = 1.2345678901234567890; //8 byte, aprox. 15 o 16 cifras mantisa
        System.out.println("double: " + decimalDoblePrec);
        boolean condicion = true; // 1 byte
        char unCaracter = 'A';//2 bytes por el formato unicode
        System.out.println("char: " + unCaracter);
        char unCharEntero = 123;
        System.out.println("char en char: " + unCharEntero);
        System.out.println("char en nº: " + (int) unCharEntero);
        String unTexto = "Que esto es un texto";
        System.out.println("string: " + unTexto);
        System.out.println("Eb mayusculas: " + unTexto.concat("AÑADIDO"));
        System.out.println("Eb mayusculas: " + unTexto.toUpperCase());
    }

   
    public static void probarOperadores() {
        //operadores unarios:
        System.out.println("Negacion: " + !true);
        System.out.println("Negativo: " + -(10 + 5));
        int contador;
        contador = 10;

        System.out.println("Casting: " + (float) 3.34343434); // conversiones explicitas
        System.out.println("Incremento: " + contador++);
        System.out.println("Incremento: " + ++contador);

        //Operadores binarios: (dos operandos)
        //Conversion implicita
        System.out.println("Suma y mult: " + (6 + 5F) * 2);
        System.out.println("Resto div: " + 11 % 3);
        //operadores booleanos
        System.out.println("Es cierto?: " + (true && false)); //operador AND  
        System.out.println("Es cierto?: " + (true || false)); //operador OR
        //igualdad y similares:
        System.out.println("Es cierto?: " + (5 == 5 || 5 > 9));
        System.out.println("Es cierto?: " + (5 != 5 && 5 <= 9));
        //Opradores bit a bit
        //00010101=21
        //00000111=7
        //00000101=5 AND
        //00010111=23 OR
        //00010010=18 XOR (OR exclusivo, como el or, pero 1&1=0)

        System.out.println("Op. binario 21 AND 7= " + (21 & 7));
        System.out.println("Op. binario 21 OR 7= " + (21 | 7));
        System.out.println("Op. binario 21 AND 7= " + (21 ^ 7));
    }
    
    
    public static void arrayAleatroio (){
        int [] array = new int [1000];
        for (int i = 0; i < array.length; i++) {
            array[i]=(int)(Math.random()*120)+1;
            System.out.println(array[i]);
        }
    }
}
