package com.uabc.algoritmos.yugioh.upgrade;

public class NodoSimple<T> {
    private T info;
    private NodoSimple<T> sig;

    public NodoSimple(T dato, NodoSimple<T> sig) {
        this.info = dato;
        this.sig = sig;
    }

    public NodoSimple() {
        info=null;
        sig=null;
    }

    public NodoSimple<T> getSig() {
        return sig;
    }

    public T getInfo() {
        return info;
    }

    public void setSig(NodoSimple<T> Sig) {
        this.sig = Sig;
    }

    public void setInfo(T dato) {
        this.info = dato;
    }

    public String toString() {
        return info + "";
    }
}
