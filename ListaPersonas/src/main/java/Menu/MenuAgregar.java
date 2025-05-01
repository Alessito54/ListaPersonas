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
                    "MENÚ AGREGAR ESTUDIANTE\n\n" +
                            "1. Agregar nuevo Estudiante\n" +
                            "2. Volver al menú Estudiante\n\n" +
                            "Seleccione una opción:");

            if (opcion == null || opcion.equals("2")) {
                break;
            }

            switch (opcion) {
                case "1":
                    String tipoInsercion = JOptionPane.showInputDialog(
                            "SELECCIONE TIPO DE INSERCIÓN\n\n" +
                                    "1. Inserción al inicio\n" +
                                    "2. Inserción al final\n" +
                                    "3. Inserción ordenada\n\n" +
                                    "Seleccione una opción:");

                    if (tipoInsercion != null) {
                        switch (tipoInsercion) {
                            case "1":
                                agregarPersona(lista, "inicio");
                                break;
                            case "2":
                                agregarPersona(lista, "final");
                                break;
                            case "3":
                                agregarPersona(lista, "ordenada");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción de inserción no válida");
                                break;
                        }
                    }
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }
        }
    }




    private static void agregarPersona(Lista lista, String string) {
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
            return;
        }
        int añoIngreso = Integer.parseInt(añoIngresoTexto);

        //carrera
        String carrera = seleccionarCarrera();
        if (carrera == null) {
            return;
        }

        Estudiante estudiante = new Estudiante(nombre, edad, añoIngreso,carrera, lista);
        estudiante.setCarrera(carrera);
        lista.insertar_final(estudiante);
        JOptionPane.showMessageDialog(null, "Estudiante agregado exitosamente:\n" + estudiante);
    }

    public static String seleccionarCarrera() {
        String subMenuCarrera = "Seleccione una carrera:\n"
                + "1. Ingeniería de Software\n"
                + "2. Medicina\n"
                + "3. Psicología\n"
                + "4. Derecho\n"
                + "5. Arquitectura\n"
                + "Ingrese una opción:";

        String opcionCarrera = JOptionPane.showInputDialog(subMenuCarrera);
        if (opcionCarrera == null) return null;

        switch (opcionCarrera) {
            case "1":
                return "Ingeniería de Software";
            case "2":
                return "Medicina";
            case "3":
                return "Psicología";
            case "4":
                return "Derecho";
            case "5":
                return "Arquitectura";
            default:
                JOptionPane.showMessageDialog(null, "Opción de carrera no válida.");
                return null;
        }
    }
}
