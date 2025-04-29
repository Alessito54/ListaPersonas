package Lista;

import Persona.Persona;

public class Nodo {
    private Persona dato;
    private Nodo proximo;
    private Nodo anterior;
    private int posicion;

    public Nodo(Persona dato) {
        this.dato = dato;
    }

    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
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
}