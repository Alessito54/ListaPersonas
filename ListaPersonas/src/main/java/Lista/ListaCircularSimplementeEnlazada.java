package Lista;

import Persona.Estudiante;

public class ListaCircularSimplementeEnlazada extends ListaDoblementeEnlazada {
    @Override
    public String getTipoDeLista() {
        return "ListaCircularSimplementeEnlazada";
    }

    @Override
    public Lista insertar_final(Estudiante estudiante) {
        Nodo nuevoNodo = new Nodo(estudiante);
        if (validaciones.listaVacia(this)) {
            this.Cabeza = nuevoNodo;
            nuevoNodo.setProximo(Cabeza);
        } else {
            Nodo nodoAnterior = this.Cabeza;
            while (nodoAnterior.getProximo() != Cabeza) {
                nodoAnterior = nodoAnterior.getProximo();
            }
            nodoAnterior.setProximo(nuevoNodo);
            nuevoNodo.setProximo(Cabeza);
        }
        return this;
    }

    @Override
    public Lista insertar_frente(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (validaciones.listaVacia(this)) {
            this.Cabeza = nuevo;
            nuevo.setProximo(Cabeza);
        } else {
            nuevo.setProximo(Cabeza);
            this.Cabeza = nuevo;
            Nodo ultimoNodo = Cabeza;
            while (ultimoNodo.getProximo() != Cabeza) {
                ultimoNodo = ultimoNodo.getProximo();
            }
            ultimoNodo.setProximo(Cabeza);
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
            nuevo.setProximo(Cabeza);
        } else {
            int añoCabeza = Integer.parseInt(Cabeza.getDato().getMatricula().substring(1, 3));

            if (año < añoCabeza) {
                nuevo.setProximo(Cabeza);
                Cabeza = nuevo;
                Nodo ultimoNodo = Cabeza;
                while (ultimoNodo.getProximo() != Cabeza) {
                    ultimoNodo = ultimoNodo.getProximo();
                }
                ultimoNodo.setProximo(Cabeza);
            } else {
                Nodo temp = Cabeza;
                Nodo atras = null;

                do {
                    if (año < Integer.parseInt(temp.getDato().getMatricula().substring(1, 3))) break;
                    atras = temp;
                    temp = temp.getProximo();
                } while (temp != Cabeza);

                nuevo.setProximo(temp);

                if (atras != null) {
                    atras.setProximo(nuevo);
                } else {
                    Cabeza = nuevo;
                    if (temp == Cabeza) {
                        nuevo.setProximo(Cabeza);
                    }
                }
            }
        }
        return this;
    }
}
