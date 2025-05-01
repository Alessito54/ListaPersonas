package Lista;

import Persona.Estudiante;

public class Nodo {
    private Estudiante dato;
    private Nodo proximo;
    private Nodo anterior;

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


    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}