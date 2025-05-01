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
        if (validaciones.listaVacia(this)) { // verificar si la lista está vacía
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

    public Lista insertar_frente(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (validaciones.listaVacia(this)) {
            this.Cabeza=nuevo;
        }else {
            nuevo.setProximo(Cabeza);
            Cabeza = nuevo;
        }
        return this;
    }

   /* public Lista insertar_ordenada(Estudiante estudiante) {

        Nodo nuevo=new Nodo(estudiante);
        if(validaciones.listaVacia(this)) {
            Cabeza=nuevo;
        }
        else{
            if(entrada<Cabeza.getDato()){
                nuevo.setProximo(Cabeza);
                cabeza=nuevo;
            }else{
                nodo reco=cabeza;
                nodo atras=cabeza;
                while (entrada>=reco.getDato() && reco.getEnlace()!=null){
                    atras=reco;
                    reco=reco.getEnlace();
                }
                if (entrada>=reco.getDato()) {
                    reco.setEnlance(nuevo);
                }else {
                    nuevo.setEnlance(reco);
                    atras.setEnlance(nuevo);
                }
            }
        }
        return this;
    }*/


    public Nodo buscarDato(String dato) {
        if (validaciones.listaVacia(this)) {
            return null;
        }
        Nodo nodo = Cabeza;
        while (nodo != null) {
            Estudiante estudiante = nodo.getDato();
            if (estudiante != null && dato.equals(estudiante.getMatricula())) {
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
        if (verificarExistenciaNodo(nodo)) {
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

    public static void ordenarLista() {

    }

    protected boolean verificarExistenciaNodo(Nodo nodo) {
        return nodo != null;
    }
}
