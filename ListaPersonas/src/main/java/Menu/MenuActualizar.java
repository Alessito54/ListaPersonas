package Menu;

import Lista.Lista;
import Lista.Nodo;
import Persona.Estudiante;
import Validaciones.Validaciones;

import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public class MenuActualizar {
    public static void mostrarMenu(Lista lista) {
        Validaciones v = new Validaciones();

        if (!v.listaVacia(lista)) {
            String dato = JOptionPane.showInputDialog("Ingrese la matrícula del estudiante a actualizar:");
            Nodo nodo = lista.buscarDato(dato);

            if (nodo != null) {
                Estudiante estudiante = nodo.getDato();

                String menu = "----- MENÚ DE ACTUALIZACIÓN DE ESTUDIANTE -----\n"
                        + "1. Actualizar Nombre\n"
                        + "2. Actualizar Edad\n"
                        + "3. Actualizar Carrera\n"
                        + "Ingrese una opción:";

                String opcionStr = JOptionPane.showInputDialog(menu);

                try {
                    if (opcionStr != null) {
                        int opcion = Integer.parseInt(opcionStr);
                        switch (opcion) {
                            case 1:
                                String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                                if (Validaciones.esNombre(nuevoNombre)) {
                                    estudiante.setNombre(nuevoNombre);
                                    JOptionPane.showMessageDialog(null, "Nombre actualizado correctamente.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Nombre inválido. No debe contener números.");
                                }
                                break;
                            case 2:
                                String nuevaEdadStr = JOptionPane.showInputDialog("Ingrese la nueva edad:");
                                if (v.esNumero(nuevaEdadStr)) {
                                    int nuevaEdad = Integer.parseInt(nuevaEdadStr);
                                    estudiante.setEdad(nuevaEdad);
                                    JOptionPane.showMessageDialog(null, "Edad actualizada correctamente.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Edad inválida. Debe ser un número entero.");
                                }
                                break;
                            case 3:
                                String nuevaCarrera = MenuAgregar.seleccionarCarrera();
                                if (nuevaCarrera != null) {
                                    estudiante.setCarrera(nuevaCarrera);
                                    JOptionPane.showMessageDialog(null, "Carrera actualizada correctamente.");
                                }
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    }
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró estudiante con matrícula: " + dato);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
        }
    }
}
