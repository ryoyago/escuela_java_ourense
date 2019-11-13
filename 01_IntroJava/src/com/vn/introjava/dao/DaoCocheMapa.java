/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoche;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pc
 */
public class DaoCocheMapa implements DaoInterface{
    
    private Map<Integer, Coche> MapaCoche;
    private Map<String, Coche> MapaCocheS;
    private int contador = 0;
    
    public DaoCocheMapa (){
        MapaCoche = new HashMap();
        MapaCocheS=  new HashMap();
    }
    
    @Override
    public Coche crear (String marca){
       return crear(FabricaCoche.crear(marca));
    }
    
     @Override
    public Coche crear (Coche coche){
        
        MapaCocheS.put(coche.getMarca(),coche);
        MapaCoche.put(contador,coche /*MapaCocheS.get(coche.getMarca())*/);
        contador++;
        return coche;
    }
    @Override
      public Coche obtenerPorIndice(int index){
        return MapaCoche.get(index);
    }
    @Override
    public Coche ObtenerPorMarca(String marca){
        return MapaCocheS.get(marca);
    } 
 
      
    

    @Override
    public void eliminar(int index) throws Exception {
        
        Coche c= MapaCoche.get(index);
        //Eliminamos por indice(integer)
        MapaCoche.remove(index);
        //Eliminamos por marca (String) 
          MapaCocheS.remove(c.getMarca());
    }

    @Override
    public void eliminar(Coche objExistente) throws Exception {
        
        String keyMarca= objExistente.getMarca();
        MapaCocheS.remove(keyMarca);
        
        int keyIndex=-1;
         if (MapaCoche.containsValue(objExistente)){
             for (Map.Entry<Integer, Coche> parIndexYcoche : MapaCoche.entrySet()) {
                 if (parIndexYcoche.getValue().equals(objExistente)) {
                     keyIndex=parIndexYcoche.getKey();
                 }
             }
         }
         MapaCoche.remove(keyIndex);
         
         
          
    }

    @Override
    public Coche modificar(int index, Coche objExistente) throws Exception {
        Coche cocheAModificar= obtenerPorIndice(index);
        MapaCocheS.remove(cocheAModificar.getMarca());
        MapaCocheS.put(objExistente.getMarca(),cocheAModificar);
        
        
       
        cocheAModificar.setMarca(objExistente.getMarca());
        cocheAModificar.setTipo(objExistente.getTipo());
        cocheAModificar.arrancar(objExistente.isArrancado()? 4:1);
        
        return cocheAModificar;
        
       
    }
    
}
