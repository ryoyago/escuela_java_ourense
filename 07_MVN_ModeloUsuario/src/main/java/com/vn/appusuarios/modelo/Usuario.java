/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.appusuarios.modelo;

import java.io.Serializable;

/**
 * Clase POJO para modelar usuario con constructor y getter y setter
 * Ahora el usuario puede ser un BEAN por implementar Serializable
 *
 * @author grupo-4
 */
public class Usuario implements Serializable {

    private int id;

    private String nombre;

    private String email;

    private String password;

    private int age;

    public Usuario(int id, String email, String password, String nombre, int age) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    public Usuario(String email, String password, String nombre, int age) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
        this.age = age;
    }

    /**
     * Get the value of id
     *
     * @return the value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the value of id
     *
     * @param id new value of id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get the value of age
     *
     * @return the value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + ", age=" + age + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        } else {
            if (obj == null) {
                return false;
            }
            Usuario usu = (Usuario) obj;
            return usu.getId() == this.getId()
                    && (usu.getEmail() == null ? this.getEmail() == null
                    : usu.getEmail().equals(this.getEmail()));
        }
    }

}
