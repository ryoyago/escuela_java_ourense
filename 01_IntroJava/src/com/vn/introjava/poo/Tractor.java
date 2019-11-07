/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/**
 *
 * @author pc
 */
public class Tractor extends Vehiculo{

    @Override
    public void avanzar() {
        System.out.println("Ruedo y siego. ");
    }

    public Tractor() {
        tipo= TipoVehiculo.TRACTOR;
    }

    @Override
    public void MostrarEstado() {
        System.out.println("SOy un tractor");
    }
    

    

    
    
}
