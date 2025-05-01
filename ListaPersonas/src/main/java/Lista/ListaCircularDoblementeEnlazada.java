package Lista;

import Persona.Estudiante;

public class ListaCircularDoblementeEnlazada extends ListaDoblementeEnlazada {

    @Override
    public String getTipoDeLista() {
        return "ListaCircularDoblementeEnlazada";
    }

    @Override
    public Lista insertar_final(Estudiante estudiante) {
        Nodo nuevoNodo = new Nodo(estudiante);
        if (validaciones.listaVacia(this)) {
            this.Cabeza = nuevoNodo;
            nuevoNodo.setProximo(Cabeza);
            nuevoNodo.setAnterior(Cabeza);
        } else {
            Nodo nodoAnterior = this.Cabeza;
            while (nodoAnterior.getProximo() != Cabeza) {
                nodoAnterior = nodoAnterior.getProximo();
            }
            nodoAnterior.setProximo(nuevoNodo);
            nuevoNodo.setAnterior(nodoAnterior);
            nuevoNodo.setProximo(Cabeza);
            Cabeza.setAnterior(nuevoNodo);
        }
        return this;
    }

    @Override
    public Lista insertar_frente(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (validaciones.listaVacia(this)) {
            this.Cabeza = nuevo;
            nuevo.setProximo(Cabeza);
            nuevo.setAnterior(Cabeza);
        } else {
            nuevo.setProximo(Cabeza);
            Cabeza.setAnterior(nuevo);
            Cabeza = nuevo;
            Nodo ultimoNodo = Cabeza;
            while (ultimoNodo.getProximo() != Cabeza) {
                ultimoNodo = ultimoNodo.getProximo();
            }
            ultimoNodo.setProximo(Cabeza);
            Cabeza.setAnterior(ultimoNodo);
        }
        return this;
    }

    @Override
    public Lista insertar_ordenada(Estudiante estudiante) {
        ordenar();
        Nodo nuevo = new Nodo(estudiante);
        int año = Integer.parseInt(nuevo.getDato().getMatricula().substring(1, 3));

        if (validaciones.listaVacia(this)) {
            Cabeza = nuevo;
            nuevo.setProximo(Cabeza);
            nuevo.setAnterior(Cabeza);
        } else {
            int añoCabeza = Integer.parseInt(Cabeza.getDato().getMatricula().substring(1, 3));

            if (año < añoCabeza) {
                nuevo.setProximo(Cabeza);
                Cabeza.setAnterior(nuevo);
                Cabeza = nuevo;
                Nodo ultimoNodo = Cabeza;
                while (ultimoNodo.getProximo() != Cabeza) {
                    ultimoNodo = ultimoNodo.getProximo();
                }
                ultimoNodo.setProximo(Cabeza);
                Cabeza.setAnterior(ultimoNodo);
            } else {
                Nodo actual = Cabeza;
                Nodo atras = null;
                while (actual != Cabeza && año >= Integer.parseInt(actual.getDato().getMatricula().substring(1, 3))) {
                    atras = actual;
                    actual = actual.getProximo();
                }
                nuevo.setProximo(actual);
                if (atras != null) {
                    atras.setProximo(nuevo);
                    nuevo.setAnterior(atras);
                }
                if (actual != null) {
                    actual.setAnterior(nuevo);
                }
            }
        }
        return this;
    }
}

