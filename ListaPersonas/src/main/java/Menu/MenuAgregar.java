package Menu;

import Persona.Estudiante;
import Persona.Estudiante;
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

        // Nombre
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre:");
        if (nombre == null || validaciones.esNumero(nombre) || !Validaciones.esNombre(nombre)) {
            JOptionPane.showMessageDialog(null, "Nombre inválido");
            return;
        }

        // Edad
        String edadTexto = JOptionPane.showInputDialog("Ingrese la edad:");
        if (edadTexto == null || !validaciones.esNumero(edadTexto)) {
            JOptionPane.showMessageDialog(null, "Edad inválida");
            return;
        }
        int edad = Integer.parseInt(edadTexto);
        if (edad < 18 || edad > 120) {
            JOptionPane.showMessageDialog(null, "Edad fuera de rango (18-120)");
            return;
        }

        // Año de ingreso
        String añoIngresoTexto = JOptionPane.showInputDialog("Ingrese año de ingreso:");
        if (añoIngresoTexto == null || !validaciones.esNumero(añoIngresoTexto) || añoIngresoTexto.length() != 4) {
            JOptionPane.showMessageDialog(null, "Año de ingreso inválido");
            return; // <-- Aquí el programa termina ese flujo sin error.
        }

        int añoIngreso = Integer.parseInt(añoIngresoTexto);

        // Crear estudiante y asignar matrícula automáticamente
        Estudiante estudiante = new Estudiante(nombre, edad, añoIngreso, lista);
        lista.add(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente:\n" + estudiante);
    }
}