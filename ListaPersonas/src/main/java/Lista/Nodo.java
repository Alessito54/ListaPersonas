package Lista;

import Persona.Estudiante;

public class Nodo {
    private Estudiante dato;
    private Nodo proximo;
    private Nodo anterior;
    private int posicion;
    private Nodo cola;

    public Nodo(Estudiante dato) {
        this.dato = dato;
    }

    public Estudiante getDato() {
        return dato;
    }

    public void setDato(Estudiante dato) {
        this.dato = dato;
    }

    public void setProximo(Nodo proximo) {
        this.proximo = proximo;
    }

    public Nodo getProximo() {
        return proximo;
    }

    public String getPosicion() {
        return String.valueOf(posicion);
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    public Nodo getCola() {
        return cola;
    }

    public void setCola(Nodo cola) {
        this.cola = cola;
    }
}