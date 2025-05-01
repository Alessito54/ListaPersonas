package Persona;

import Lista.Lista;
import Validaciones.Validaciones;

import java.util.Random;

public class Estudiante {
    private String nombre;
    private int edad;
    private String matricula;
    private int añoIngreso;

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante(String nombre, int edad, int añoIngreso, Lista lista) {
        this.nombre = nombre;
        this.edad = edad;
        this.añoIngreso = añoIngreso;
        generarmMatricula(lista);

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public String toString() {
        return "Nombre: " + this.nombre + " | Edad: " + this.edad + " | Matricula: " + this.matricula;
    }
    private void generarmMatricula(Lista lista) {
        System.out.println("Generando matricula de " + this.nombre);
        Random random = new Random();
        Validaciones v = new Validaciones();
        int año = añoIngreso % 100;
        int numero;
        String nuevaMatricula;

        do {
            int contador = 0;
            numero = 1000 + random.nextInt(9000);
            nuevaMatricula = "S" + año + "00" + numero;
            System.out.println(contador);
        } while (!v.verificarMatricula(nuevaMatricula, lista));


        this.matricula = nuevaMatricula;
    }

}