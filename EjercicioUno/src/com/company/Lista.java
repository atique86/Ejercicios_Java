/**
 * 
 */
package com.company;

import java.util.ArrayList; //Se importa arrayList para usar guardar datos en memoria 
import java.util.List; //Se importa List para insertar elementos en una lista y acceder a los mismos
import java.util.Scanner; //Se importa clase Scanner para capturar los datos ingresados por teclado

/**
 * @author Andres Tiquw
 *
 */

//Se crea la clase Lista que contiene los metodos para realizar la tarea requerida
public class Lista {

	/**
	 * @param args
	 */
	//Metodo principal en el cual se llaman crean las variables y metodos a usar
	public static void main(String[] args) 
	{
		Lista lista = new Lista(); //Se crea un nuevo objeto tipo List
		String nombre = new String(); //Se crea un nuevo objeto del tipo String
		int limite, divisor; //Se crea las variables de tipo entera "limite y divisor"
		List<Integer> listaTabla; //Se crea un array List que permite ingresar valores enteros
		
		Scanner teclado = new Scanner(System.in); //Se crea el objeto "teclado" que permite capturar los datos ingresados por teclado
        System.out.println("Por favor ingrese su nombre: "); //Se muestra mensaje al usuario solicitando nombre
        nombre = teclado.nextLine();//Se captura el nombre ingresado por el usuario y se asigna al objeto
        System.out.println("Por favor ingrese limite: "); //Se muestra mensaje al usuario solicitando el numero "limite"
        limite = teclado.nextInt(); //Se captura el numero ingresado y se asigna a la variable "limite"
        System.out.println("Por favor ingrese divisor: "); //Se muestra mensaje al usuario solicitando el numero "divisor"
        divisor = teclado.nextInt(); //Se captura el numero ingresado y se asigna a la variable "divisor"
        
        listaTabla = lista.realizarTabla(nombre, limite); //Se asigna a "listaTabla" los valores que se capturan en el metodo realizar tabla
        lista.mostrarDivisiores(listaTabla, divisor); //Se llama el metodo "mostrarDivisores"
	}
	
	//Se crea el metodo realizarTabla
	public List<Integer> realizarTabla(String nombre, int limite) 
	{
		int numeroLetras = nombre.length(); //Se crea la variable y se le asigna el valor del tamaño del "nombre" ingresado por el usuario
		List<Integer> listaTabla = new ArrayList<>(); //Se crea una nueva lista
		
		System.out.println("LA TABLA ES:\n"); //Se muestra mensaje informativo al usuario 
		
		//Se crea el ciclo repetitivo for para crear la tabla de multiplicar con los valores de "numeros de letras" multiplicado por "i" hasta 
		//el valor ingresado por el usuario -- "limite"
		for (int i=1; i<=limite; i++) 
		{
			int resultado = numeroLetras * i; //Se crea la variable "resultado" y se le asigna el producto de la operación
			listaTabla.add(resultado);//Agrega el valor de "resultado" a la lista
			System.out.println(numeroLetras + " X " + i + " = " + resultado); //Se muestra por mensaje de consola el valor de la multiplicación		
		}		
		return listaTabla; //Al finalizar el ciclo for se retorna la lista con sus respectivos elementos
	}
	
	//Se crea metodo para mostrar los productos que son divisibles por el "divisor" ingresado por el usuario
	public void mostrarDivisiores(List<Integer> listaTabla, int divisor) 
	{
		//Se crea arrayList
		List<Integer> divisores = new ArrayList<>();
		
		//Se crea el ciclo respetitivo for para recorrer la lista
		for (int item : listaTabla) 
		{
			if (item % divisor == 0) //Se crea la condicional if para agregar al array "divisores" solo los productos que cumplan la condicion
			{
				divisores.add(item); //Se agregan a la lista solo los productos que cumplen la condicional
			}
		}
		
		StringBuilder cadenaDivisores = new StringBuilder(); //Se instacia el objeto StringBuilder para concatenar los productos
		
		for (int i = 0; i < divisores.size(); i++) //Se crea el ciclo repetitivo for para recorrer la lista de divisores
		{
			if (i + 1 < divisores.size()) //Se crea condicional para poner una coma que separa los distintos elementos de la lista divisores
			{
				cadenaDivisores.append("" + divisores.get(i) + ", "); //Si cumple la condicional se agrega una coma despues del elemento
			}
			else
			{
				cadenaDivisores.append("" + divisores.get(i)); //Sino cumple se omite la coma
			}
			 
		}
		
		System.out.println("\nLos numeros divisibles por " + divisor + " son " + cadenaDivisores.toString()); //Se muestra por mensaje de consola los productos que son divibles por el divisor ingresado
		System.out.println("La cantidad de numeros divisbles es " + divisores.size()); //Se muestra la cantidad de numeros divibles
	}
	

}
