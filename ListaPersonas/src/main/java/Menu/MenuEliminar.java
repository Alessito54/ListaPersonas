package Menu;


import Lista.Lista;
import Lista.Nodo;
import Validaciones.Validaciones;

import java.awt.Component;
import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class MenuEliminar {
    public static void mostrarMenu(Lista lista) {
        Validaciones v = new Validaciones();

        if (!v.listaVacia(lista)) {
            String dato = JOptionPane.showInputDialog("Ingrese INE");

            if (dato == null || dato.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Operación cancelada o INE vacío.");
                return;
            }

            Nodo nodo = lista.buscarDato(dato);
            if (nodo != null) {
                String menu = "----- MENÚ DE PERSONAS -----\n1. Eliminar persona (LÓGICA)\n2. Eliminar persona (FÍSICA)\nIngrese una opción:";
                String opcionStr = JOptionPane.showInputDialog(menu);

                if (opcionStr == null || opcionStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Operación cancelada o sin opción seleccionada.");
                    return;
                }

                try {
                    int opcion = Integer.parseInt(opcionStr.trim());
                    switch (opcion) {
                        case 1:
                            lista.delateLogico(nodo);
                            break;
                        case 2:
                            lista.delateFisico(nodo);
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: opción no numérica.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró resultado para " + dato);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay personas registradas");
        }
    }
}

