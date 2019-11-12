/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;


import com.vn.introjava.excepciones.UsoNormalExcepciones;
import com.vn.introjava.funcionesbasicas.DatosBasicos;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoche;
import java.util.Arrays;
import static java.util.Arrays.sort;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;

/**
 * Clase principal del proyecto Ejemplos java
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {
        
        System.out.println("Hola que pasa\u0000");
        
        /*Error no capturado, se detiene el programa
        while(args.length > -1)
            ((Object) null).equals(args);*/
        try {
            //Primera excepcion
            Coche c = FabricaCoche.crear("Seat en main");
            c.mostrarEstado();
           // return;
           // c = FabricaCoche.crear(null); IllegalArgumentException
           c = FabricaCoche.crear("un coche");
            c.mostrarEstado();

            //Segunda
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
           // unObj.metodoPeligroso(); RuntimeException 
           
           throw new TransformerException("Optimus prime se ha quedado sin bateria.");

            //Tercera NullPointerException
            //Object objNulo = null;
            //System.out.println("Fallara: " + objNulo.toString());
        } catch (IllegalArgumentException ex) {

            //Captura cualquier exception cuyo tipo sea el indicado
            //el catch ocualquiera de sus clases hijas
            System.out.println("Argumento invalido: Decirle al usuario lo que:: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }catch (RuntimeException ex) {

            //Captura cualquier exception cuyo tipo sea el indicado
            //el catch ocualquiera de sus clases hijas
            System.out.println("Cualquier tipo de rumetimeexception: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }//se pueden anidar
        catch (Exception ex) {

            //Captura cualquier exception cuyo tipo sea el indicado
            //el catch ocualquiera de sus clases hijas
            System.out.println("Cualquier tipo de exception: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally {//siempre se ejecuta
            //incluso antes del return;
            System.out.println(">>>>> FIN DEL TRY - CATCH");
        }
        //System.out.println("******FIN DEL PROGRAMA");
    }

    /**
     * Funcion que se ejecuta al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void mainS(String[] args) {
        System.out.println("Tipos de datos");
//        DatosBasicos.mostrarTiposDatos();
//        EstructurasControl.ejecutarBucles();
//        EstructurasControl.ejecutarCondiciones();
//        DatosBasicos.probarOperadores();
        //OrdenamientoBurbuja.ordenarArray();
        //        OrdenamientoBurbuja.OrdenarArray2();

        //DatosBasicos.arrayAleatroio();
        try {
            Coche c = FabricaCoche.crear("Seat en main");
            c.mostrarEstado();
           
           
            FabricaCoche.crear("un coche");
            c.mostrarEstado();

        } catch (Exception ex) {
            //Logger.getLogger()
        }

    }

    public void gestionarExcepcion() {
        try {
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
            unObj.metodoPeligroso();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Excepcion " + ex.getMessage());
            System.out.println("\nPilas de llamadas " + Arrays.toString(ex.getStackTrace()));

        }

        try {
            Object objNulo = null;
            System.out.println("Fallara: " + objNulo.toString());
        } catch (NullPointerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
