/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avlui_ruthdercantillo;

/**
 *
 * @author Ruthder
 */
public class Nodo {
    private int dato;
    private Nodo izquierdo, derecho;

    public Nodo(int dato) {
        this.dato = dato;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public Nodo getDerecho() {
        return derecho;
    }


    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }
    
    public int getDato() {
        return dato;
    }
    public void setDato(int dato) {
        this.dato = dato;
    }
}
