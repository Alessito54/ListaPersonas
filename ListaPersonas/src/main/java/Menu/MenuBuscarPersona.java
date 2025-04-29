package Menu;

import Lista.Lista;
import Lista.Nodo;
import Persona.Persona;
import Validaciones.Validaciones;

import javax.swing.*;

public class MenuBuscarPersona {
    public static void buscarPersona(Lista lista) {
        Validaciones v = new Validaciones();
        if (!v.listaVacia(lista)){
            String ine = JOptionPane.showInputDialog(null,
                    "BUSCAR PERSONA\n\n" +
                            "Ingrese el INE de la persona a buscar:",
                    "Búsqueda de Personas",
                    JOptionPane.PLAIN_MESSAGE);

            if(ine == null || ine.equals("")) {
                return;
            }

            if (  lista.buscarDato(ine) != null &&  lista.buscarDato(ine).getDato() != null) {
                JOptionPane.showMessageDialog(null, lista.buscarDato(ine).getDato());
            }
        }else JOptionPane.showMessageDialog(null, "No hay personas registradas");
    }
}
