package Lista;

import Persona.Estudiante;
import Validaciones.Validaciones;

import javax.swing.*;

@SuppressWarnings("ALL")
public class Lista {
    protected static Nodo Cabeza;
    protected Validaciones validaciones = new Validaciones();



    public Lista() {
        this.Cabeza = null;
    }

    public Nodo getCabeza() {
        return Cabeza;
    }
    public String getTipoDeLista() {
        return "Lista";
    }
    public Lista insertar_final(Estudiante estudiante) {
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
            this.Cabeza = nuevo;
        } else {
            nuevo.setProximo(Cabeza);
            Cabeza = nuevo;
        }
        return this;
    }

    public Lista insertar_ordenada(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        int año = Integer.parseInt(nuevo.getDato().getMatricula().substring(1, 3));

        if (validaciones.listaVacia(this)) {
            Cabeza = nuevo;
        } else {
            int añoCabeza = Integer.parseInt(Cabeza.getDato().getMatricula().substring(1, 3));

            if (año < añoCabeza) {
                nuevo.setProximo(Cabeza);
                Cabeza = nuevo;
            } else {
                Nodo reco = Cabeza;
                Nodo atras = null;
                while (reco != null && año >= Integer.parseInt(reco.getDato().getMatricula().substring(1, 3))) {
                    atras = reco;
                    reco = reco.getProximo();
                }
                nuevo.setProximo(reco);

                if (atras != null) {
                    atras.setProximo(nuevo);
                }
            }
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

        protected void ordenar() {
        if (Cabeza == null || Cabeza.getProximo() == Cabeza) {
            return;
        }

        boolean ordenado;
        do {
            ordenado = true;
            Nodo actual = Cabeza;
            while (actual.getProximo() != Cabeza) {
                Nodo siguiente = actual.getProximo();
                if (actual.getDato().getMatricula().compareTo(siguiente.getDato().getMatricula()) > 0) {
                    Estudiante temp = actual.getDato();
                    actual.setDato(siguiente.getDato());
                    siguiente.setDato(temp);
                    ordenado = false;
                }
                actual = actual.getProximo();
            }
        } while (!ordenado);
    }
    protected boolean verificarExistenciaNodo(Nodo nodo) {
        return nodo != null;
    }
}
