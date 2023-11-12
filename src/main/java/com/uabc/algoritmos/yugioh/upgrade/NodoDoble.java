package com.uabc.algoritmos.yugioh.upgrade;

import java.util.Arrays;

public class NodoDoble<T> {

    private T info;
    private NodoDoble<T> sig;
    private NodoDoble<T> ant;

    public NodoDoble(T dato, NodoDoble<T> sig, NodoDoble<T> ant) {
       
        this.sig = sig;
        this.info = dato;
        this.ant = ant;

    }

    public NodoDoble() {
        this.info = null;
        this.sig = null;
        this.ant = null;
    }

    public NodoDoble<T> getSig() {

        return sig;

    }

    public NodoDoble<T> getAnt() {

        return ant;
    }

    public T getInfo() {

        return info;
    }

    public void setSig(NodoDoble<T> Sig) {

        this.sig = Sig;
    }

    public void setAnt(NodoDoble<T> Ant) {

        this.ant = Ant;

    }

    public void setInfo(T dato) {

        this.info = dato;
    }

    public String toString() {
        if (info instanceof Object[]) {
            return Arrays.toString((Object[]) info);
        }
        return String.valueOf(info);
    }
}
