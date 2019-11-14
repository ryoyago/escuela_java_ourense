package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * El sistema de bloqueo lo tiene que gestionar el recurso compartido
 *
 * @author pc
 */
public class Contenedor {

    // Normalmente será un array, lista, bb.dd., 
    // mapa, fichero, DAO, servicio web, cualquier recurso compartido...
    int dato;
    //SEMAFORO:  false no se puede usar el recurso
    //           true si se puede usar
    boolean hayDato = false;

    
    //synchronized prepara el metodo para el bloqueo
    public synchronized int get() {
         
           // System.out.println("Contenedor. Al principio del get(): " + hayDato);
            while (hayDato == false) { //Esperamos a que se produzca algun dato
             //   System.out.println("GET:Esperando, hayDato= " + hayDato);
                try {
                    this.wait();//Le decimos que espere hasta que el productor produzca el dato :D
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            hayDato = false;   //Marcamos para bloquear el recurso antes de devolverlo
            //System.out.println("Contenedor. Al final del get(): " + dato);
            
            this.notifyAll();  //Indicar al hilo que avise a los otros hilos de que el recurso ha sido consumido

            return dato; //Devolver el dato

        

    }

    public synchronized void put(int valor) {
        //System.out.println("Contenedor. Al principio del put(): " + valor);
       
        while (hayDato) { //Esperar a que alguien consuma el dato
            //Mientras hay dato, nadie lo ha consumido
           // System.out.println("PUT:Esperando,hayDAto= " + hayDato);
             try {
                    this.wait();//Le decimos que espere hasta que el productor produzca el dato :D
                } catch (InterruptedException ex) {
                    Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
         dato = valor;// Almacenar el dato
        hayDato = true; //Marcamos para liberar el recurso

        //System.out.println("Contenedor. Al final del put(): " + valor);
         this.notifyAll(); 

    }
}
