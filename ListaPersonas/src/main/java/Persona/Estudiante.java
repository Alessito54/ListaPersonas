package Persona;

import Lista.Lista;
import Validaciones.Validaciones;

import java.util.Random;

@SuppressWarnings("NonAsciiCharacters")
public class Estudiante {
    private String nombre;
    private int edad;
    private String matricula;
    private int añoIngreso;


    private String carrera;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante(String nombre, int edad, int añoIngreso, String carrera,Lista lista) {
        this.nombre = nombre;
        this.edad = edad;
        this.añoIngreso = añoIngreso;
        this.carrera = carrera;
        generarmMatricula(lista);

    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String toString() {
        return "Nombre: " + this.nombre + " | Edad: " + this.edad +" | Carrera: " + this.carrera+ " | Matricula: " + this.matricula;
    }
    private void generarmMatricula(Lista lista) {
        System.out.println("Generando matricula de " + this.nombre);
        Random random = new Random();
        int año = añoIngreso % 100;
        int numero;
        String nuevaMatricula;

        do {
            numero = 1000 + random.nextInt(9000);
            nuevaMatricula = "S" + año + "00" + numero;
        } while (!Validaciones.verificarMatricula(nuevaMatricula, lista));


        this.matricula = nuevaMatricula;
    }

}