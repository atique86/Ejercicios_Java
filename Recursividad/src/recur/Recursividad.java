/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recur;

import Funciones.Teclado;

/**
 *
 * @author Andrés
 */
public class Recursividad {

    public Recursividad() {
    }

    /**
     * Metodo que permite aplicar recursividad hasta finalizar en CERO
     *
     * @param numero Variable que va a disminuir por cada paso
     */
    public void cambio(int numero) {
        if (numero < 0) {
            System.out.println("Finalizó el proceso.");
        } else {
            System.out.println("El número es: " + numero);
            numero = numero - 2;
            this.cambio(numero);
        }
    }

    public void cambio1(String msn, int numero) {
        if (numero < 0) {
            System.out.println(msn + numero);
        } else {
            msn += "Este el número: " + numero + "\n";
            numero -= 2;
            this.cambio1(msn, numero);
        }
    }

    public String cambio2(String msn, int numero) {
        if (numero < 0) {
            return msn;
        } else {
            msn += "El número es: " + numero + "\n";
            numero -= 2;
            return this.cambio2(msn, numero);
        }
    }

    public static void main(String[] args) {

        Teclado hp = new Teclado();
        Recursividad z = new Recursividad();
        //z.cambio(101);
        //z.cambio1("Lista de números\n", 100);
        String listado = z.cambio2("", hp.capInt("Ingrese un número"));
        System.out.println(listado);
    }

}
