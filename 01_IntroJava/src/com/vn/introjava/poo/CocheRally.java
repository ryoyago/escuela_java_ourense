/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/**
 * Clase CocheRally para controlar otras caracteristicas especificas de los
 * rallies
 *
 * @author pc
 */
public class CocheRally extends Coche {

    private float rozamiento;

    public CocheRally() {
        super();
        rozamiento=5f;
        
    }
    
    /** Constructor con paramentros
     * Al implementar un constructor, el de por defecto
     * deja de ser implementado por java
     * 
     * @param marca 
     */

    public CocheRally(String marca) {
        super(marca);
        rozamiento=5f;
        tipo=TipoVehiculo.RALLY;
    }

    public CocheRally(float rozamiento, String marca) {
        super(marca);
        this.rozamiento = rozamiento;
    }
    
    
    

    /**
     * Obtener valor de rozamiento
     *
     * @return the value of rozamiento
     */
    public float getRozamiento() {
        return rozamiento;
    }

    /**
     * Establecer valor de rozamiento
     *
     * @param rozamiento new value of rozamiento
     */
    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }

    @Override
    public boolean arrancar(String orden) {
        if (super.arrancar(orden)) {
            return super.arrancado;
        } else {
            if ("arrancar".equalsIgnoreCase(orden)) {
                arrancado = true;
            } else {
                "encender".equals(orden.toLowerCase());
            }
            return arrancado;

        }

    }


//return super.arrancar(orden); //To change body of generated methods, choose Tools | Templates.
//Ejercicio: sobreescribir el metodo mostrarEstado para que
//tambien muestre el rozamiento y que indique que es "coche de rally"
//@Override
public void mostrarEstadoAntiguo() {
        super.mostrarEstado();
        System.out.println(" -Rozamiento " + getRozamiento());

    }

    @Override
        public void mostrarEstado() {

        System.out.println(" Soy un Coche de rally " + getMarca()
                + ", rozam= " + rozamiento
                + (isArrancado() ? " arrancado." : " apagado."));

    }
        
}
