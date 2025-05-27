package Lista;

import Persona.Estudiante;

public class Pila extends Lista {
    public void push(Estudiante estudiante) {
        super.insertar_frente(estudiante);
    }

    public Estudiante pop() {
        if (validaciones.listaVacia(this)) {
            return null;
        }
        Estudiante dato = Cabeza.getDato();
        super.delateLogico(Cabeza);
        return dato;
    }

    public Estudiante cima() {
        if (validaciones.listaVacia(this)) {
            return null;
        }
        return Cabeza.getDato();
    }

    public boolean pilaVacia() {
        return validaciones.listaVacia(this);
    }

    public void limpiarPila() {
        this.Cabeza = null;
    }
}