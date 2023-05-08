/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.vitorone.contador;

/**
 *
 * @author vitor
 */
public class Contador {
    private int c = 0;
    
    public void incremento(String nome){
        c++;
        System.out.println(nome+": "+this.value());
    }
    
    public void decremento(String nome){
        c--;
        System.out.println(nome+": "+this.value());
    }
    
    public int value() {
        return c;
    }

    public static void main(String[] args) {
        
        Contador contador = new Contador();
        
        Thread t1 = new Thread(() ->{
            String nome = Thread.currentThread().getName();
            contador.incremento(nome);
        }, "t1");
        
        Thread t2 = new Thread(() ->{
            String nome = Thread.currentThread().getName();
            contador.incremento(nome);
        }, "t2");
        
        // cria as threads
        t1.start();
        t2.start();
        
        System.out.println( contador.value());
    }
}
