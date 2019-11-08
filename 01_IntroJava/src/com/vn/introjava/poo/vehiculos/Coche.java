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
public class Coche /*extends Object*/  extends Vehiculo {

    /*public Coche(){ //Constructor por defecto____________________________________
        
        
    }*/
    private int numRuedas = 4;
    private String marca;
    protected boolean arrancado;

    //En el momento que creamos un constructor, el de por defecto
    //deja de ser implementado por java
    public Coche() {
        numRuedas = 4;
        marca = "Sin marca";
    }

    public Coche(String marca) {
        this.marca = marca;
        marca="SIN MARCA";
        this.arrancado=false;
        tipo=TipoVehiculo.TURISMO;
    }
    
    

    public void arrancar() {
        System.out.println(this.marca + " ha arrancado.");
        arrancado = true;
    }

    //Sobrecarga de método arrancar()
    /** Si la posicion de la llave es 4, el coche arranca
     *  No arranca en cualquier otro caso
     * 
     * @param posicionLlave puede ser un nº del 1 al 4
     * @return              Si se ha arrancado devuelve true
     */
    public void arrancar(int posicionLlave) { //4 pos, la 4º es la que arranca
        if (posicionLlave<1||posicionLlave>4) 
            throw new IllegalArgumentException("La llave ha de valer de 1 a 4");
        
        arrancado = posicionLlave == 4/* ? true : false*/;
        System.out.println(this.marca + (arrancado ? " ha arrancado."
                : " fallo al arrancar"));
        //if (posicionLlave == 4 ) arrancado = true; else arrancado = false; 

    }
    
    public boolean arrancar(String orden) {

        arrancado = "arrancar".equals(orden);
        return arrancado;
    }
    
    /*
    *Simplemente muestra la marca y si esta arrancando
    */

    public void mostrarEstado() {
        System.out.println("Coche " + getMarca() + (arrancado ? " arrancado."
                : " apagado"));
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String nuevaMarca) 
            //Avisamos a quien invoica este m,etodo,
            throws IllegalArgumentException {
        
        if (marca != null && !"".equals(marca)) {
            this.marca = nuevaMarca;
        } else //Lanzamos la excepcion
        {
            throw new IllegalArgumentException("Debes asignar una marca");
        }
        //Cuando existe una variable local obliga a usar this 
        //para acceder a la variable miembro
        //con el mismo nombre
        this.marca = nuevaMarca;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setArrancado(boolean arrancado) {
        this.arrancado = arrancado;
    }

    public boolean isArrancado() {
        return arrancado;
    }

    @Override
    public void avanzar() {
        System.out.println("Ruedo un poco");
    }

    @Override
    public void MostrarEstado() {
        System.out.println(toString());
        
    }

    @Override
    public String toString() {
        String t=""+tipo;
           
           return t;
    }

    @Override
    public void mover(float metros) {
        avanzar();
        System.out.println(metros+ " metros");
    }
    

}
