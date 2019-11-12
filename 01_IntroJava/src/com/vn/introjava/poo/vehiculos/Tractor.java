/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo.vehiculos;

/**
 *
 * @author pc
 */
public class Tractor extends Vehiculo {

    @Override
    public void avanzar() {
        System.out.println("Ruedo y siego. ");
    }

    public Tractor() {
        tipo = TipoVehiculo.TRACTOR;
    }
    @Override
    public void MostrarEstado() {
        System.out.println(toString());

    }

    @Override
    public String toString() {
        String t = "" + tipo;
        return t;
    }

    @Override
    public void mover(float metros) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
