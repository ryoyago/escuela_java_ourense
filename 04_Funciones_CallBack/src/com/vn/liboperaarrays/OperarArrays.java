/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.liboperaarrays;

import java.util.function.Function;

/**
 *
 * @author pc
 */
public class OperarArrays {
    
    //Esquivalente a decir que estructura tendran las funciones callback
    @FunctionalInterface
    public interface FunCallbackOperarArrays{
        double operar(double x, double y);
    }
    
    public static double[] operarArrays(double [] arrX , double[] arrY,FunCallbackOperarArrays operarCllbk ){
          double [] arrayResult = null;
        if (arrX.length == arrY.length) {
           arrayResult=new double[arrX.length];
            for (int i = 0; i < arrX.length; i++) {
                arrayResult[i]=operarCllbk.operar(arrX[i],arrY[i] );
            }
        }
        return arrayResult;
    }
    
 
    
}
