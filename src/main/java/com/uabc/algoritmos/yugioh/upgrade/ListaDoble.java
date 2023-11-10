package com.uabc.algoritmos.yugioh.upgrade;

public class ListaDoble<T> {

    private NodoDoble<T> inicio;

    public ListaDoble() {
        inicio = null;
    }

    public NodoDoble<T> getInicio() {
        return inicio;
    }

    public void setInicio(NodoDoble<T> inicio) {
        this.inicio = inicio;
    }

    public void insertaInicio(T dato) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);

        if (inicio == null) {
            n.setAnt(null);
            n.setSig(null);
        } else {
            n.setAnt(null);
            n.setSig(inicio);
            inicio.setAnt(n);
        }

        inicio = n;
    }

    public void insertaFin(T dato) {
        NodoDoble<T> n = new NodoDoble<>();
        n.setInfo(dato);

        if (inicio == null) {
            n.setAnt(null);
            n.setSig(null);
            inicio = n;
        } else {
            NodoDoble<T> r = inicio;
            while (r.getSig() != null) {
                r = r.getSig();
            }

            r.setSig(n);
            n.setAnt(r);
            n.setSig(null);
        }
    }

    public void eliminaInicio() {
        if (inicio == null) {
            System.out.println("Lista Vacia");
        } else {
            if (inicio.getSig() != null) {
                inicio.getSig().setAnt(null);
            }
            inicio = inicio.getSig();
        }
    }

    public void eliminaFin() {
        if (inicio == null) {
            System.out.println("Lista Vacia");
        } else if (inicio.getSig() == null) {
            inicio = null;
        } else {
            NodoDoble<T> r = inicio;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            r.getAnt().setSig(null);
        }
    }

    public void recorrer() {
        if (inicio == null) {
            System.out.println("Lista Vacia");
        } else {
            NodoDoble<T> r = inicio;
            while (r != null) {
                System.out.println("" + r.getInfo());
                r = r.getSig();
            }
        }
    }

public void mostrarLista() {
    NodoDoble<T> r = inicio;

    if (inicio != null) {
        while (r != null) {
            String[] info = (String[]) r.getInfo();
            
            for (String data : info) {
                System.out.print(data + " ");
            }
            
            System.out.println(); // Move to the next line for the next node
            r = r.getSig();
        }
    } else {
        System.out.println("La lista está vacía");
    }
}


    public String ToStringRecursivo() {
        return mostrarRecursivo(inicio);
    }

    private String mostrarRecursivo(NodoDoble<T> x) {
        if (x == null) {
            return "Lista Vacía";
        }

        if (x.getSig() == null) {
            return x.getInfo().toString();
        }

        String cadenaRecursiva = mostrarRecursivo(x.getSig());
        return cadenaRecursiva + " " + x.getInfo().toString();
    }

    public T eliminaX(T x) {
        
        if (inicio == null) {
            System.out.println("Lista Vacia");
            return null;
        }

        if (inicio.getInfo().equals(x)) {
            T info = inicio.getInfo();
            inicio = inicio.getSig();
            if (inicio != null) {
                inicio.setAnt(null);
            }
            return info;
        }

        NodoDoble<T> n = inicio;

        while (n != null && !n.getInfo().equals(x)) {
            n = n.getSig();
        }

        if (n != null) {
            if (n.getAnt() != null) {
                n.getAnt().setSig(n.getSig());
            }
            if (n.getSig() != null) {
                n.getSig().setAnt(n.getAnt());
            }
            return n.getInfo();
        } else {
            System.out.println("Valor no encontrado en la lista");
            return null;
        }
    }

    public int buscar(T x) {
        int posicion = 0;
        NodoDoble<T> n = inicio;
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
            if (inicio != null) {
                inicio.setAnt(null);
            }
            return dato;
        }

        int contador = 0;
        NodoDoble<T> n = inicio;

        while (n != null && contador < posicion) {
            n = n.getSig();
            contador++;
        }

        if (n != null) {
            if (n.getAnt() != null) {
                n.getAnt().setSig(n.getSig());
            }
            if (n.getSig() != null) {
                n.getSig().setAnt(n.getAnt());
            }
            return n.getInfo();
        } else {
            return null;
        }
    }

    public void eliminarPosicionesPares() {
        NodoDoble<T> n = inicio;
        int posicion = 1;

        while (n != null) {
            if (posicion % 2 == 0) {
                if (n.getAnt() != null) {
                    n.getAnt().setSig(n.getSig());
                }
                if (n.getSig() != null) {
                    n.getSig().setAnt(n.getAnt());
                }
            }

            n = n.getSig();
            posicion++;
        }
    }

    public void insertaPosicion(T dato, int posicion) {
        if (posicion < 0) {
            System.out.println("Posición más pequeña que el tamaño de la lista");
            return;
        }

        NodoDoble<T> nuevo = new NodoDoble<>(dato, null, null);

        if (posicion == 0) {
            nuevo.setSig(inicio);
            if (inicio != null) {
                inicio.setAnt(nuevo);
            }
            inicio = nuevo;
            return;
        }

        int contador = 0;
        NodoDoble<T> n = inicio;

        while (n != null && contador < posicion) {
            n = n.getSig();
            contador++;
        }

        if (contador == posicion) {
            nuevo.setSig(n);
            nuevo.setAnt(n.getAnt());
            if (n.getAnt() != null) {
                n.getAnt().setSig(nuevo);
            }
            n.setAnt(nuevo);
        } else {
            System.out.println("Posición Fuera de Rango");
        }
    }

    public void ordenarLista() {
        boolean intercambio;
        do {
            intercambio = false;
            NodoDoble<T> actual = inicio;
            NodoDoble<T> siguiente;

            if (inicio != null) {
                siguiente = inicio.getSig();
            } else {
                siguiente = null;
            }

            while (siguiente != null) {
                if (((Comparable<T>) actual.getInfo()).compareTo(siguiente.getInfo()) > 0) {
                    T temp = actual.getInfo();
                    actual.setInfo(siguiente.getInfo());
                    siguiente.setInfo(temp);
                    intercambio = true;
                }

                actual = siguiente;
                siguiente = siguiente.getSig();
            }
        } while (intercambio);
    }

    

}
