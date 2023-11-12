package com.uabc.algoritmos.yugioh.upgrade;

import java.util.ArrayList;

public class ListaCircularDoble<T> {

    private NodoDoble<T> inicio;
    private NodoDoble<T> fin;

    public NodoDoble<T> getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble<T> inicio) {
        this.inicio = inicio;
    }

    public NodoDoble<T> getFin() {
        return fin;
    }

    public void setFin(NodoDoble<T> fin) {
        this.fin = fin;
    }

    public ListaCircularDoble() {
        inicio = null;
        fin = null;
    }

    public void insertaInicio(T dato) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);

        if (inicio == null) {
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
            n.setSig(inicio);
            n.setAnt(fin);
            inicio.setAnt(n);
            inicio = n;
            fin.setSig(inicio);
        }
    }


    public void insertaFin(T dato) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);

        if (inicio == null) {
            
            inicio = fin = n;
            n.setSig(inicio);
            n.setAnt(inicio);
        } else {
           
            n.setSig(inicio);
            n.setAnt(fin);
            fin.setSig(n);
            inicio.setAnt(n);
            fin = n;
        }
    }

    public void eliminaInicio() {
        if (inicio == null) {
            System.out.println("Lista Vacia");
        } else if (inicio == fin) {
            inicio = fin = null;
        } else {
            fin.setSig(inicio.getSig());
            inicio = inicio.getSig();
            inicio.setAnt(fin);
        }
    }

    public void eliminaFin() {
        if (inicio == null) {
            System.out.println("Lista Vacia");
        } else if (inicio == fin) {
            inicio = fin = null;
        } else {
            NodoDoble<T> r = fin.getAnt();
            r.setSig(inicio);
            inicio.setAnt(r);
            fin = r;
        }
    }

    public void recorrer() {
        if (inicio == null) {
            System.out.println("Lista Vacia");
        } else {
            NodoDoble<T> r = inicio;
            do {
                System.out.println("" + r.getInfo());
                r = r.getSig();
            } while (r != inicio);
        }
    }

    public ArrayList<Integer> mostrarLista() {
        NodoDoble<T> r = inicio;
        ArrayList<Integer> contenido = new ArrayList<>();

        if (inicio != null) {
            do {
                contenido.add((Integer) r.getInfo());

                r = r.getSig();
            } while (r != inicio);
        } else {

            System.out.println("Lista Vacia");
        }

        return contenido;
    }

    public String ToStringRecursivo() {
        return mostrarRecursivo(inicio);
    }

    private String mostrarRecursivo(NodoDoble<T> x) {
        if (x == null) {
            return "Lista Vacía";
        }

        if (x.getSig() == inicio) {
            return x.getInfo().toString();
        }

        String cadenaRecursiva = mostrarRecursivo(x.getSig());

        return cadenaRecursiva + " " + x.getInfo().toString();
    }

    public void eliminarPosicionesPares() {
        NodoDoble<T> n = inicio;
        NodoDoble<T> a = null;
        int posicion = 1;

        do {
            if (posicion % 2 == 0) {
                if (a == null) {
                    inicio = n.getSig();
                } else {
                    a.setSig(n.getSig());
                    n.getSig().setAnt(a);
                }
            } else {
                a = n;
            }

            n = n.getSig();
            posicion++;
        } while (n != inicio);
    }

    public T eliminaX(T x) {
        if (inicio == null) {
            System.out.println("Lista Vacia");
            return null;
        }

        if (inicio.getInfo().equals(x)) {
            T info = inicio.getInfo();
            inicio = inicio.getSig();
            inicio.setAnt(fin);
            fin.setSig(inicio);
            return info;
        }

        NodoDoble<T> n = inicio;
        NodoDoble<T> a = null;

        do {
            if (n.getInfo().equals(x)) {
                a.setSig(n.getSig());
                n.getSig().setAnt(a);

                if (n == fin) {
                    fin = a;
                    fin.setSig(inicio);
                    inicio.setAnt(fin);
                }

                return n.getInfo();
            }

            a = n;
            n = n.getSig();
        } while (n != inicio);

        System.out.println("Valor no encontrado en la lista");
        return null;
    }

    public int buscar(T x) {
        int posicion = 0;
        NodoDoble<T> n = inicio;

        do {
            if (n.getInfo().equals(x)) {
                return posicion;
            }
            n = n.getSig();
            posicion++;
        } while (n != inicio);

        return -1;
    }

    public T eliminaPosicion(int posicion) {
        if (posicion < 0 || inicio == null) {
            return null;
        }

        if (posicion == 0) {
            T dato = inicio.getInfo();
            inicio = inicio.getSig();
            inicio.setAnt(fin);
            fin.setSig(inicio);
            return dato;
        }

        int contador = 0;
        NodoDoble<T> n = inicio;
        NodoDoble<T> a = null;

        do {
            if (contador == posicion) {
                a.setSig(n.getSig());
                n.getSig().setAnt(a);

                if (n == fin) {
                    fin = a;
                    fin.setSig(inicio);
                    inicio.setAnt(fin);
                }

                return n.getInfo();
            }

            a = n;
            n = n.getSig();
            contador++;
        } while (n != inicio);

        return null;
    }

    public void insertaPosicion(T dato, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición más pequeña que el tamaño de la lista");
            return;
        }

        NodoDoble<T> nuevo = new NodoDoble<>(dato, null, null);

        if (posicion == 0) {
            nuevo.setSig(inicio);
            nuevo.setAnt(fin);
            inicio.setAnt(nuevo);
            fin.setSig(nuevo);
            inicio = nuevo;
        } else {
            int contador = 0;
            NodoDoble<T> n = inicio;
            NodoDoble<T> a = null;

            do {
                if (contador == posicion) {
                    a.setSig(nuevo);
                    nuevo.setAnt(a);
                    nuevo.setSig(n);
                    n.setAnt(nuevo);
                    return;
                }

                a = n;
                n = n.getSig();
                contador++;
            } while (n != inicio);

            if (contador == posicion) {
                a.setSig(nuevo);
                nuevo.setAnt(a);
                nuevo.setSig(n);
                n.setAnt(nuevo);
            } else {
                System.out.println("Posición Fuera Rango");
            }
        }
    }

    public ArrayList<Integer> ordenarLista() {

        ArrayList<Integer> orden = mostrarLista();

        orden.sort((o1, o2) -> o1.compareTo(o2));
        return orden;
    }
}
