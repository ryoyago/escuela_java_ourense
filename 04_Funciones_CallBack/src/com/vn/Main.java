/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn;

import com.vn.liboperaarrays.OperarArrays;
import java.io.PrintStream;
import java.util.Arrays;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double[] array_A = {1,2,3,4,5};
        double[] array_B = {2,3,4,5,6};
         Double[] array_A1 = {1.0,2.0,3.0,4.0,5.0};
        Double[] array_B1 = {2.,3.,4.,5.,6.};
        double[] arraySumaAB = OperarArrays.operarArrays(array_A, array_B,Main::suma);
        arrayEnTabla(System.out, arraySumaAB);
        //System.out.println("Suma : " + Arrays.toString(arraySumaAB));
        
        double [] arrayRestaAB= OperarArrays.operarArrays(array_A, array_B,(double x, double y) ->{ return x-y;});
        arrayEnTabla(System.out, arrayRestaAB);
        
        double [] arrayMulAB=OperarArrays.operarArrays(array_A, array_B,Main::mult);
        arrayEnTabla(System.out, arrayMulAB);
        //System.out.println("Multiplicacion: " + Arrays.toString(arrayMulAB));
        
        double [] arrayDivAB=OperarArrays.operarArrays(array_A, array_B,Main::div);
        arrayEnTabla(System.out, arrayDivAB);
       // System.out.println("Division: " + Arrays.toString(arrayDivAB));
        
       
        
    }
    
    public static double suma (double x, double y){
        return x + y;    }
    
    
    public static double mult(double x, double y){
        return x * y;
    }
    
    public static double div(double x, double y){
        return x/y;
    }
    
    
    
    public static void arrayEnTabla (PrintStream salida, double [] array){
        String tabla ="<table border=2><tr>\n";
        for (int index = 0; index < array.length; index++) {
            final double element = array[index];
            tabla += "<td>&nbsp;" + element + " &nbsp;</td>\n";
        }
        salida.println(tabla + "</tr></table>");
    }
}
