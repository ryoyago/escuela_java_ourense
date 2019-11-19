/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.liboperaarrays;

import com.vn.liboperaarrays.OperarArrays.FunCallbackOperarArrays;

/**
 *
 * @author pc
 */
public class OperarArraysObject {
    
       @FunctionalInterface
    public interface FunCallbackOperarArrays{
        Object operar(Object x, Object y);
    }
     public static Object[] operarArrays(Object [] arrX , Object[] arrY,FunCallbackOperarArrays operarCllbk ){
          Object [] arrayResult = null;
        if (arrX.length == arrY.length) {
           arrayResult=new Object[arrX.length];
            for (int i = 0; i < arrX.length; i++) {
                arrayResult[i]=operarCllbk.operar(arrX[i],arrY[i] );
            }
        }
        return arrayResult;
    }
    
}
