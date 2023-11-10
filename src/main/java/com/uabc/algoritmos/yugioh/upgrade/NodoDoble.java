package com.uabc.algoritmos.yugioh.upgrade;

public class NodoDoble<T> {

    private T info;
    private NodoDoble<T> sig;
    private NodoDoble<T> ant;

    public NodoDoble(T dato, NodoDoble<T> sig, NodoDoble<T> ant) {

        this.info = dato;
        this.sig = sig;
        this.ant = ant;

    }

    public NodoDoble() {

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

        this.info=dato;
    }

    public String toString(){

        return ""+ant+""+info+""+sig;

    }
}
