/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.sistdeplaz;

import com.vn.introjava.poo.interfaces.Desplazable;

/**
 *
 * @author pc
 */
public class Monopatin implements Desplazable{
    
    @Override
    public void mover(float metros) {
        if (metros > 10) {
            saltar(metros);
        } else {
            rodar(metros);
        }

    }

    public void saltar(float m) {
        System.out.println("Monopatin salta" + m + "!");
    }

    public void rodar(float m) {
        System.out.println("Avión vuela vuela " + m + "!");
    }
}
