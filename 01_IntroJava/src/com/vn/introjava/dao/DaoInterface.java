/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;

/**
 *
 * @author pc
 */
public interface DaoInterface extends IGenericDao<Coche>{

    public Coche crear(String marca);

    public Coche obtenerPorIndice(int index);

    public Coche ObtenerPorMarca(String marca);
}
