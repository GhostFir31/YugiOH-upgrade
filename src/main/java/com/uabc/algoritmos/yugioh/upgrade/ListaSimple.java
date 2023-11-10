package com.uabc.algoritmos.yugioh.upgrade;

public class ListaSimple<T> {
    private NodoSimple<T> inicio;

    public ListaSimple() {
        inicio = null;
    }

    public void insertaInicio(T dato) {
        NodoSimple<T> n = new NodoSimple<>(dato, inicio);
        inicio = n;
    }

    public void insertaFin(T dato) {
        NodoSimple<T> nuevo = new NodoSimple<>(dato, null);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            NodoSimple<T> n = inicio;
            while (n.getSig() != null) {
                n = n.getSig();
            }
            n.setSig(nuevo);
        }
    }

    public void eliminaInicio() {
        if (inicio != null) {
            inicio = inicio.getSig();
        } else {
            System.out.println("Lista Vacia");
        }
    }

    public T eliminaFin() {
        if (inicio == null) {
            System.out.println("Lista Vacia");
            return null;
        } else if (inicio.getSig() == null) {
            T dato = inicio.getInfo();
            inicio = null;
            return dato;
        } else {
            NodoSimple<T> n = inicio;
            NodoSimple<T> a = null;
            while (n.getSig() != null) {
                a = n;
                n = n.getSig();
            }
            a.setSig(null);
            return n.getInfo();
        }
    }

    public StringBuffer mostrarLista() {

        NodoSimple<T> r = inicio;
        StringBuffer cadena = new StringBuffer();

        if (inicio != null) {

            while (r != null) {

                cadena.append(" " + r.getInfo());

                r = r.getSig();
            }
        } else {

            System.out.println("Esta Vacia");
        }
        return cadena;
    }

    public String ToStringRecursivo() {
        return mostrarRecursivo(inicio);
    }

    private String mostrarRecursivo(NodoSimple<T> x) {

        if (x == null) {
            return "Lista Vacía";
        }

        if (x.getSig() == null) {

            return x.getInfo().toString();

        }

        String cadenaRecursiva = mostrarRecursivo(x.getSig());

        return cadenaRecursiva + " " + x.getInfo().toString();
    }

    public void eliminarPosicionesPares() {
        NodoSimple<T> n = inicio;
        NodoSimple<T> a = null;
        int posicion = 1;

        while (n != null) {
            if (posicion % 2 == 0) {
                if (a == null) {
                    inicio = n.getSig();
                } else {
                    a.setSig(n.getSig());
                }
            } else {
                a = n;
            }

            n = n.getSig();
            posicion++;
        }
    }

    public T eliminaX(T x) {
        if (inicio == null) {
            System.out.println("Lista Vacia");
            return null;
        }

        if (inicio.getInfo().equals(x)) {
            T info = inicio.getInfo();
            inicio = inicio.getSig();
            return info;
        }

        NodoSimple<T> n = inicio;
        NodoSimple<T> a = null;

        while (n != null && !n.getInfo().equals(x)) {
            a = n;
            n = n.getSig();
        }

        if (n != null) {
            a.setSig(n.getSig());
            return n.getInfo();
        } else {
            System.out.println("Valor no encontrado en la lista");
            return null;
        }
    }

    public int buscar(T x) {
        int posicion = 0;
        NodoSimple<T> n = inicio;
        while (n != null) {
            if (n.getInfo().equals(x)) {
                return posicion;
            }
            n = n.getSig();
            posicion++;
        }
        return -1;
    }

    public T eliminaPosicion(int posicion) {
        if (posicion < 0 || inicio == null) {
            return null;
        }

        if (posicion == 0) {
            T dato = inicio.getInfo();
            inicio = inicio.getSig();
            return dato;
        }

        int contador = 0;
        NodoSimple<T> n = inicio;
        NodoSimple<T> a = null;

        while (n != null && contador < posicion) {
            a = n;
            n = n.getSig();
            contador++;
        }

        if (n != null) {
            a.setSig(n.getSig());
            return n.getInfo();
        } else {
            return null;
        }
    }

    public void insertaPosicion(T dato, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición mas pequeña que el tamaño lista");
            return;
        }

        NodoSimple<T> nuevo = new NodoSimple<>(dato, null);

        if (posicion == 0) {
            nuevo.setSig(inicio);
            inicio = nuevo;
            return;
        }

        int contador = 0;
        NodoSimple<T> n = inicio;
        NodoSimple<T> a = null;

        while (n != null && contador < posicion) {
            a = n;
            n = n.getSig();
            contador++;
        }

        if (contador == posicion) {
            a.setSig(nuevo);
            nuevo.setSig(n);
        } else {
            System.out.println("Posición Fuera Rango");
        }
    }

    public void ordenarLista() {
        boolean intercambio;
        do {
            intercambio = false;
            NodoSimple<T> n = inicio;
            NodoSimple<T> sig = inicio.getSig();

            while (sig != null) {

                if (((Comparable<T>) n.getInfo()).compareTo(sig.getInfo()) > 0) {

                    T temp = n.getInfo();
                    n.setInfo(sig.getInfo());
                    sig.setInfo(temp);
                    intercambio = true;
                }

                n = sig;
                sig = sig.getSig();
            }
        } while (intercambio);
    }

}
