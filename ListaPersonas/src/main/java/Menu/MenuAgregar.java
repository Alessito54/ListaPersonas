package Menu;

import Persona.Persona;
import Lista.Lista;

import javax.swing.JOptionPane;

import Validaciones.Validaciones;

public class MenuAgregar {

    public static void mostrarMenu(Lista lista) {
        while (true) {
            String opcion = JOptionPane.showInputDialog(
                    "MENÚ AGREGAR PERSONA\n\n" +
                            "1. Agregar nueva persona\n" +
                            "2. Volver al menú principal\n\n" +
                            "Seleccione una opción:");

            if (opcion == null || opcion.equals("2")) {
                break;
            }

            switch (opcion) {
                case "1":
                    agregarPersona(lista);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }

    private static void agregarPersona(Lista lista) {
        Validaciones validaciones = new Validaciones();

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        if (!validaciones.esNumero(nombre) && Validaciones.esNombre(nombre)) {
            JOptionPane.showMessageDialog(null, "Nombre agregado exitosamente");

            String edadTexto = JOptionPane.showInputDialog("Ingrese la edad:");
            if (validaciones.esNumero(edadTexto)) {
                int edad = Integer.parseInt(edadTexto);
                if (edad>=18 && edad<=120) {
                    JOptionPane.showMessageDialog(null, "Edad agregada exitosamente");

                    String ine = JOptionPane.showInputDialog("Ingrese el número de INE:");
                    if (Validaciones.esIne(ine)) {
                        JOptionPane.showMessageDialog(null, "Ine agregado exitosamente");

                        Persona persona = new Persona(nombre, edad, ine);
                        lista.add(persona);
                        JOptionPane.showMessageDialog(null, "Persona agregada exitosamente.");
                        return;
                    }
                }
            }
        }

        JOptionPane.showMessageDialog(null, "Caracter inválido");
        return;
    }
}