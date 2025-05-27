package Lista;

import Persona.Estudiante;

public class Cola extends Lista {
    public void insertar(Estudiante estudiante) {
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
    }

    public Estudiante quitar() {
        if (validaciones.listaVacia(this)) {
            return null;
        }
        Estudiante dato = Cabeza.getDato();
        super.delateLogico(Cabeza);
        return dato;
    }

    public Estudiante frente() {
        if (validaciones.listaVacia(this)) {
            return null;
        }
        return Cabeza.getDato();
    }

    public boolean colaVacia() {
        return validaciones.listaVacia(this);
    }

    public void limpiarCola() {
        this.Cabeza = null;
    }
}