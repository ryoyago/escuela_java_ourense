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
public class OrdenamientoBurbuja {

    public static int[] ordenarArray(int []numerosarray) {
        //Declarar un array de enteros y programar como ordenarlo

        /*int numerosarray[]= {3,1,4,2,5};
       // TRAMPOSO :-D
       sort(numerosarray);
       // DESPEDIDO
       for (int i = 0; i < 10; i++) {
                  System.out.println("Numeros: "+ numerosarray[i]);
       }*/
       // int numerosarray[] = {4, 2, 3, 1};
        if (numerosarray.length<=0 || numerosarray==null)
            return numerosarray;
        
        for (int i = 0; i < (numerosarray.length); i++) {
            for (int j = i + 1; j < numerosarray.length; j++) {
                if (numerosarray[i] > numerosarray[j]) {
                    int auxiliar = numerosarray[i];
                    numerosarray[i] = numerosarray[j];
                    numerosarray[j] = auxiliar;

                }

            }
            System.out.println(numerosarray[i]);
        }
        return numerosarray;
    }

    public static void OrdenarArray2() {
        int[] array = {4, 2, 3, 1};
        int[] arrOrd = new int[array.length];

        int inicio = 0;
        int menor, posMenor;
        do {
            posMenor=inicio;
            menor = array[inicio];
            for (int i = inicio; i < array.length; i++) {
                if (array[i] < menor) {
                    menor = array[i];
                    posMenor = i;
                }
            }

            array[posMenor] = Integer.MAX_VALUE;

            arrOrd[inicio] = menor;
            inicio++;
           
            
            System.out.println("  \nOriginal;");
            for (int i = inicio; i < array.length; i++) {
                System.out.print(array[i] + ", ");
            }
            for (int i = 0; i < array.length; i++) {
                
            }
        } while (inicio < array.length);

    }
    
    public static int[] insercionDirecta(int A[]){
    int p, j;
    int aux;
    for (p = 1; p < A.length; p++){ // desde el segundo elemento hasta
              aux = A[p]; // el final, guardamos el elemento y
              j = p - 1; // empezamos a comprobar con el anterior
              while ((j >= 0) && (aux < A[j])){ // mientras queden posiciones y el
                                                                    // valor de aux sea menor que los
                             A[j + 1] = A[j];       // de la izquierda, se desplaza a
                             j--;                   // la derecha
              }
              A[j + 1] = aux; // colocamos aux en su sitio
    }
    return A;
}
}
