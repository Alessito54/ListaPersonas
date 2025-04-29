package Validaciones;


import Lista.Lista;

import javax.swing.*;

public class Validaciones {
    public Boolean listaVacia(Lista lista) {
        if (lista.getCabeza() == null) {//si hay un nodo en la cabeza significa que no esta vacia
            return true;
        }
        return false;
    }

    public Boolean esNumero(String s) {
        try {
            int numero = Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean esIne(String s) {
        if (s.length() != 18)
            return false;

        // Recorremos cada carácter
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Verificamos si es letra (A-Z, a-z) o número (0-9)
            if (!((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9'))) {
                return false;
            }
        }

        return true;
    }

    public static boolean esNombre(String s){
        if (s == null || s.length() == 0)
            return false;

        return !buscarNumerosEnCadena(s);
        }

        public static boolean buscarNumerosEnCadena(String s){
            for (int i = 0; i < s.length(); i++) {
                if (Character.isDigit(s.charAt(i))) {
                    return true;
                }
            }
            return false;
        }



}