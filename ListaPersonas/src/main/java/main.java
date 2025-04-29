import Lista.Lista;
import Menu.MenuActualizar;
import Menu.MenuAgregar;
import Menu.MenuBuscarPersona;
import Menu.MenuEliminar;
import Validaciones.Validaciones;

import javax.swing.*;

public class main {
    public static void main(String[] args) throws Exception {
        Validaciones v = new Validaciones();
        Lista lista = new Lista();

        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "MENÚ PRINCIPAL\n\n" +
                            "1.- Añadir Persona\n" +
                            "2.- Buscar Persona\n" +
                            "3.- Actualizar Persona\n" +
                            "4.- Eliminar Persona\n" +
                            "5.- Mostrar Personas\n" +
                            "6.- Salir\n\n" +
                            "Seleccione una opción:",
                    "Gestión de Personas",
                    JOptionPane.PLAIN_MESSAGE);

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                System.exit(0);
            }

            opcion = opcion.trim(); // para limpiar espacios pa

            if (v.esNumero(opcion)) {
                int numOpcion = Integer.parseInt(opcion);
                switch (numOpcion) {
                    case 1:
                        MenuAgregar.mostrarMenu(lista);
                        break;
                    case 2:
                        MenuBuscarPersona.buscarPersona(lista);
                        break;
                    case 3:
                        MenuActualizar.mostrarMenu(lista);
                        break;
                    case 4:
                        MenuEliminar.mostrarMenu(lista);
                        break;
                    case 5:
                        JOptionPane.showMessageDialog(null, lista.printLista() + "\n");
                        break;
                    case 6:
                        JOptionPane.showMessageDialog(null, "Good Bye!!", "Salir", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
