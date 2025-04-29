package Lista;
import Persona.Estudiante;
import Validaciones.Validaciones;

import javax.swing.*;
public class Lista {
    protected Nodo Cabeza;
    protected Validaciones validaciones = new Validaciones();

    public Lista() {
        this.Cabeza = null;
    }

    public Nodo getCabeza() {
        return Cabeza;
    }

    public Lista add(Estudiante estudiante) {
        Nodo nuevoNodo = new Nodo(estudiante); // variable del nuevo nodo
        if (this.Cabeza == null) { // verificar si la lista está vacía
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


    public Nodo buscarDato(String dato) {
        if (validaciones.listaVacia(this)) {
            return null;
        }
        Nodo nodo = Cabeza;
        while (nodo != null) {
            Estudiante estudiante = nodo.getDato();
            if (estudiante != null && dato.equals(estudiante.getIne())) {
                return nodo;
            }
            nodo = nodo.getProximo();
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
                Nodo anterior = Cabeza;
                while (anterior.getProximo() != nodo) {
                    anterior = anterior.getProximo();
                }
                anterior.setProximo(nodo.getProximo());
            }
        }
        return this;
    }

    public void delateFisico(Nodo nodo) {
        if (verificarExistenciaNodo(nodo)) {
            nodo.setDato(null);
        }
    }

    public Estudiante mostrarDato(Nodo nodo) {
        if (nodo != null) {
            Estudiante estudiante = nodo.getDato();
            if (estudiante != null) {
                return estudiante;
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró el Ine");
                return null;
            }
        }
        return null;
    }

    protected boolean verificarExistenciaNodo(Nodo nodo) {
        return nodo != null;
    }
}
