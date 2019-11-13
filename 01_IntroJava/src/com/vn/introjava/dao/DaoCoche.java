/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoche;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class DaoCoche implements DaoInterface{
    
    private List<Coche> listaCoches;
    
    public DaoCoche(){
        listaCoches= new ArrayList<>();
    }
    @Override
    public Coche crear (Coche nuevoCoche){
        
        listaCoches.add(nuevoCoche);
        return nuevoCoche;
    }
     
    public Coche crear (String marca){
        Coche c = FabricaCoche.crear(marca);
        listaCoches.add(c);
        return c;
    }
    @Override
    public Coche obtenerPorIndice(int index){
        if (index<listaCoches.size()) {
        return listaCoches.get(index);   
        }
        return null;
    }
    @Override
    public Coche ObtenerPorMarca(String marca){
        for (Coche coche : listaCoches) {
            if (coche.getMarca().equals(marca)) {
                return coche;
            }
            
        }
        return null;
    }
    @Override
   public Coche modificar (int index, Coche objExistente){ 
        Coche cocheAModificar=listaCoches.get(index);
        cocheAModificar.setMarca(objExistente.getMarca());
        cocheAModificar.setTipo(objExistente.getTipo());
        cocheAModificar.arrancar(objExistente.isArrancado()? 4:1);
        return cocheAModificar;
    }
   


    @Override
    public void eliminar(int index) throws Exception {
        this.listaCoches.remove(index);
    }

    @Override
    public void eliminar(Coche objExistente) throws Exception {
         this.listaCoches.remove(objExistente);
    }
    
}
