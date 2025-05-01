import Lista.Lista;
import Lista.ListaDoblementeEnlazada;
import Lista.ListaCircularSimplementeEnlazada;
import Lista.ListaCircularDoblementeEnlazada;
import Menu.MenuActualizar;
import Menu.MenuAgregar;
import Menu.MenuBuscarPersona;
import Menu.MenuEliminar;
import Validaciones.Validaciones;

import javax.swing.*;

public class main {
    public static void main(String[] args) throws Exception {
        Validaciones v = new Validaciones();
        Lista lista = null;

        while (lista == null) {
            String tipo = JOptionPane.showInputDialog(null,
                    "SELECCIONE EL TIPO DE LISTA\n\n" +
                            "1.- Lista Simple\n" +
                            "2.- Lista Doblemente Enlazada\n" +
                            "3.- Lista Circular Simple\n" +
                            "4.- Lista Circular Doblemente Enlazada\n\n" +
                            "Seleccione una opción:",
                    "Tipo de Lista",
                    JOptionPane.PLAIN_MESSAGE);

            if (tipo == null) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                System.exit(0);
            }

            tipo = tipo.trim();

            if (v.esNumero(tipo)) {
                int tipoLista = Integer.parseInt(tipo);
                switch (tipoLista) {
                    case 1:
                        lista = new Lista();
                        break;
                    case 2:
                        lista = new ListaDoblementeEnlazada();
                        break;
                    case 3:
                        lista = new ListaCircularSimplementeEnlazada();
                        break;
                    case 4:
                        lista = new ListaCircularDoblementeEnlazada();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        // MENÚ PRINCIPAL
        while (true) {
            String opcion = JOptionPane.showInputDialog(null,
                    "MENÚ PRINCIPAL\n\n" +
                            "1.- Añadir Estudiante\n" +
                            "2.- Buscar Estudiante\n" +
                            "3.- Actualizar Estudiante\n" +
                            "4.- Eliminar Estudiante\n" +
                            "5.- Mostrar Estudiante\n" +
                            "6.- Salir\n\n" +
                            "Seleccione una opción:",
                    "Gestión de Estudiante UV",
                    JOptionPane.PLAIN_MESSAGE);

            if (opcion == null) {
                JOptionPane.showMessageDialog(null, "Saliendo del programa.");
                System.exit(0);
            }

            opcion = opcion.trim();

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





