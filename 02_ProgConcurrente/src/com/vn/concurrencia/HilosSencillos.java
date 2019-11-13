/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

/**
 *
 * @author pc
 */
public class HilosSencillos {

    static int contcompartido = 0;

    HiloA hiloA1, hiloA2;
    HiloB hiloB1, hiloB2;

    public HilosSencillos() {
        this.hiloA1 = new HiloA();
        this.hiloB1 = new HiloB();
        this.hiloA2 = new HiloA();
        this.hiloB2 = new HiloB();
    }

    class HiloA implements Runnable {

        @Override
        public void run() {
            for (long i = 0; i < 500; i++) {
                contcompartido++;
                if (i % 2 == 0) {
                    System.out.println("Instruccion A " + i + " - contador = " + contcompartido);
                }

            }
        }

    }

    class HiloB implements Runnable {

        @Override
        public void run() {
            //El contador principal, j , en varibale local
            for (int j = 0; j < 800; j++) {
                contcompartido++;
                if (j % 100 == 0) {
                    System.out.println("Instruccion B" + j + " - contador = " + contcompartido);
                }

            }
        }

    }

    public void ejecutarHilosStartAB() {

        System.out.println("***** THREAD - START *****");
        Thread threadHiloA1 = new Thread(hiloA1);
        Thread threadHiloB1 = new Thread(hiloB1);
        Thread threadHiloA2 = new Thread(hiloA2);
        Thread threadHiloB2 = new Thread(hiloB2);
        //threadHiloA.run();            
        threadHiloA1.start();
        threadHiloB1.start();
        threadHiloA2.start();
        threadHiloB2.start();
        while (threadHiloA1.isAlive() || threadHiloB1.isAlive() ||threadHiloA2.isAlive() || threadHiloB2.isAlive() );

        System.out.println("***** END - START *****");
    }

    public void ejecturarHilosRunAB() {
        System.out.println("\n----- THREAD - RUN -----\n");
        //SIN HILOS, ejecutamos unòdetras de otro
       hiloA1.run();
       hiloA2.run();
       hiloB1.run();
       hiloB2.run();
       
  

        System.out.println("\n----- END- RUN -----\n");
    }
}
