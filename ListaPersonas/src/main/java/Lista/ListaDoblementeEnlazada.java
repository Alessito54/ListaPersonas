package Lista;

import Persona.Estudiante;
import Validaciones.Validaciones;

import javax.swing.*;

public class ListaDoblementeEnlazada extends Lista {
    @Override
    public String getTipoDeLista() {
        return "ListaDoblementeEnlazada";
    }

    @Override
    public Lista insertar_final(Estudiante estudiante) {
        Nodo nuevoNodo = new Nodo(estudiante);
        if (validaciones.listaVacia(this)) {
            this.Cabeza = nuevoNodo;
        } else {
            Nodo nodoAnterior = this.Cabeza;
            while (nodoAnterior.getProximo() != null) {
                nodoAnterior = nodoAnterior.getProximo();
            }
            nuevoNodo.setAnterior(nodoAnterior);
            nodoAnterior.setProximo(nuevoNodo);
        }
        return this;
    }

    @Override
    public Lista insertar_frente(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (validaciones.listaVacia(this)) {
            this.Cabeza = nuevo;
        } else {
            nuevo.setProximo(Cabeza);
            Cabeza.setAnterior(nuevo);
            Cabeza = nuevo;
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
        } else {
            int añoCabeza = Integer.parseInt(Cabeza.getDato().getMatricula().substring(1, 3));

            if (año < añoCabeza) {
                nuevo.setProximo(Cabeza);
                Cabeza.setAnterior(nuevo);
                Cabeza = nuevo;
            } else {
                Nodo temp = Cabeza;
                Nodo atras = null;
                while (temp != null && año >= Integer.parseInt(temp.getDato().getMatricula().substring(1, 3))) {
                    atras = temp;
                    temp = temp.getProximo();
                }
                nuevo.setProximo(temp);

                if (temp != null) {
                    temp.setAnterior(nuevo);
                }
                if (atras != null) {
                    atras.setProximo(nuevo);
                    nuevo.setAnterior(atras);
                }
            }
        }
        return this;
    }

}
