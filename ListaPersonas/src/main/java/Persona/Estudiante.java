package Persona;

public class Estudiante {
    private String nombre;
    private int edad;
    private String ine;


    public Estudiante() {
    }

    public Estudiante(String nombre) {
        this.nombre = nombre;
    }

    public Estudiante(String nombre, int edad, String ine) {
        this.nombre = nombre;
        this.edad = edad;
        this.ine = ine;

    }

    public String getIne() {
        return this.ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return this.edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }


    public String toString() {
        return "Nombre: " + this.nombre + " | Edad: " + this.edad + " | INE: " + this.ine;
    }
}