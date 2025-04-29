package Menu;

import Lista.Lista;
import Lista.Nodo;
import Persona.Estudiante;
import Validaciones.Validaciones;

import javax.swing.JOptionPane;

public class MenuActualizar {
    public static void mostrarMenu(Lista lista) {
        Validaciones v = new Validaciones();

        if (!v.listaVacia(lista)) {
            String dato = JOptionPane.showInputDialog("Ingrese INE de la persona a actualizar:");
            Nodo nodo = lista.buscarDato(dato);

            if (nodo != null) {
                Estudiante persona = nodo.getDato();

                String menu = "----- MENÚ DE ACTUALIZACIÓN -----\n"
                        + "1. Actualizar Nombre\n"
                        + "2. Actualizar Edad\n"
                        + "3. Actualizar INE\n"
                        + "Ingrese una opción:";

                String opcionStr = JOptionPane.showInputDialog(menu);

                try {
                    int opcion = Integer.parseInt(opcionStr);
                    switch (opcion) {
                        case 1: // Actualizar nombre
                            String nuevoNombre = JOptionPane.showInputDialog("Ingrese el nuevo nombre:");
                            if (Validaciones.esNombre(nuevoNombre)) {
                                persona.setNombre(nuevoNombre);
                                JOptionPane.showMessageDialog(null, "Nombre actualizado correctamente.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Nombre inválido. No debe contener números.");
                            }
                            break;
                        case 2: // Actualizar edad
                            String nuevaEdadStr = JOptionPane.showInputDialog("Ingrese la nueva edad:");
                            if (v.esNumero(nuevaEdadStr)) {
                                int nuevaEdad = Integer.parseInt(nuevaEdadStr);
                                persona.setEdad(nuevaEdad);
                                JOptionPane.showMessageDialog(null, "Edad actualizada correctamente.");
                            } else {
                                JOptionPane.showMessageDialog(null, "Edad inválida. Debe ser un número entero.");
                            }
                            break;
                        case 3: // Actualizar INE
                            String nuevoIne = JOptionPane.showInputDialog("Ingrese el nuevo INE:");
                            if (Validaciones.esIne(nuevoIne)) {
                                persona.setIne(nuevoIne);
                                JOptionPane.showMessageDialog(null, "INE actualizado correctamente.");
                            } else {
                                JOptionPane.showMessageDialog(null, "INE inválido. Debe tener 18 caracteres alfanuméricos.");
                            }
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró resultado para " + dato);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay personas registradas.");
        }
    }
}
