package com.company;

import java.util.Scanner;

public class Main 
{
    String nombre = new String();
    int numero;

    public void imprimir(int[] lista)
    {
        for(int i=0; i < lista.length; i++)
        {
            System.out.println(lista[i]);
        }
    }

    public static void main(String[] args)
    {
        Main x = new Main();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Por favor ingrese su nombre: ");
        x.nombre = teclado.nextLine();
        System.out.println("Ingrese un numero entero: ");
        x.numero = teclado.nextInt();
        int arreglo[] = llenarArreglo(x.numero, x.nombre);
        x.imprimir(arreglo);


        /*Scanner teclado = new Scanner(System.in);
        int numero;
        float resultado2;

        System.out.println("Por favor ingrese su nombre: ");
        String nombre = teclado.nextLine();
        int longitud = nombre.length();
        System.out.println("Ingrese un número entero: ");
        numero = teclado.nextInt();
        int resultado1[] = new int[numero];
        int i;
        for (i = 1; i<=numero; i++){
            resultado1[i] = longitud*i;
            System.out.println(longitud + " * " + i + " = " + resultado1[i]);
        }
        //return resultado1;*/

    }

    public static int[] llenarArreglo(int numero, String nombre)
    {
        int[] resultado = new int[numero];
        for (int i = 0; i < numero; i++)
        {
            resultado[i] = nombre.length() * (i + 1);
        }
        return resultado;
    }


}
