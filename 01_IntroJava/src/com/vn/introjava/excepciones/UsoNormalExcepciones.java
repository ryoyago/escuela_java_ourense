/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.excepciones;

/**
 *
 * @author pc
 */
public class UsoNormalExcepciones {
    
    public void metodoPeligroso(){
        int [] arrayDosElementos = new int [2];
        
        for (int i = 0; i < 10/* > Length */; i++) {
            arrayDosElementos[i]=i*9; //cualquier valor
            
            
        }
        
    }
    
}
