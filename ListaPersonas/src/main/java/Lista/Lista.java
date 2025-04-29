package Lista;


import Persona.Estudiante;

import Persona.Estudiante;
import Validaciones.Validaciones;

import javax.swing.*;

public class Lista {
    Validaciones validaciones = new Validaciones();
    private Nodo Cabeza;
    private Nodo nodoAnterior;// variable para no perder el nodo anterior

    public Lista() {
        this.Cabeza = null;
    }

    public Nodo getCabeza() {
        return Cabeza;
    }

    public Lista add(Estudiante persona) {

        Nodo nuevoNodo = new Nodo(persona);//variable del nuevo nodo

        if (this.Cabeza == null) {//verificar que ya hay un uno anterior
            this.Cabeza = nuevoNodo;
            nodoAnterior = this.Cabeza;
        } else {
            nuevoNodo.setAnterior(nodoAnterior);
            nodoAnterior.setProximo(nuevoNodo);
            nodoAnterior = nuevoNodo;
        }
        return this;
    }

    public Nodo buscarDato(String dato) {
        if (validaciones.listaVacia(this)) {
            return null;
        }
        Nodo nodo = Cabeza;
        while (nodo != null) {
            if (validaciones.esNumero(dato)) {
                if (dato.equals(nodo.getPosicion())) {
                    return nodo;
                }
            } else {
                Estudiante persona = nodo.getDato();
                if (persona != null)
                {
                    if (dato.equals(persona.getIne())) {
                        return nodo;
                    }
                }
                nodo = nodo.getProximo();
            }
        }
        return null;
    }

    public String printLista() {
        String lista = "";
        if (validaciones.listaVacia(this)) {
            return "Lista vacia";
        }
        Nodo n = Cabeza;
        while (n != null) {
            if (n.getDato() != null) {
                lista += n.getDato() + "\n";
            }
            n = n.getProximo();
        }
        return lista;
    }

    public Lista delateLogico(Nodo nodo) {
        if (verificarExistenciaNodo(nodo)) {
            if (nodo == Cabeza) {
                Cabeza = nodo.getProximo();
            } else {
                Nodo nodoTemp = nodo.getProximo();
                nodo.getAnterior().setProximo(nodoTemp);
            }
        }
        return this;
    }

    public void delateFisico(Nodo nodo) {
        //Nodo nodo = buscarDato(ine);
        if (verificarExistenciaNodo(nodo)) {
            nodo.setDato(null);
        }
    }

    public Estudiante mostrarDato(Nodo nodo) {
        if (nodo != null) {
            Estudiante persona = nodo.getDato();
            if (persona != null) {
                return persona;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro el Ine");
                return null;
            }
        } else return null;

    }

    private boolean verificarExistenciaNodo(Nodo nodo) {
        if (nodo == null) {
            return false;
        }
        return true;
    }
}