package Menu;

import Lista.Lista;
import Lista.Nodo;
import Persona.Estudiante;
import Validaciones.Validaciones;

import javax.swing.*;

public class MenuBuscarPersona {
    public static void buscarPersona(Lista lista) {
        Validaciones v = new Validaciones();
        if (!v.listaVacia(lista)){
            String matricula = JOptionPane.showInputDialog(null,
                    "BUSCAR PERSONA\n\n" +
                            "Ingrese el Matricula del estudiante a buscar:",
                    "Búsqueda de Personas",
                    JOptionPane.PLAIN_MESSAGE);

            if(matricula == null || matricula.equals("")) {
                return;
            }

            if (  lista.buscarDato(matricula) != null &&  lista.buscarDato(matricula).getDato() != null) {
                JOptionPane.showMessageDialog(null, lista.buscarDato(matricula).getDato());
            }
        }else JOptionPane.showMessageDialog(null, "No hay personas registradas");
    }
}
