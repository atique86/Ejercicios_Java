import java.util.Scanner;

public class RecetasCocina {
    public static void main(String[] args) {
        // Recetas Cocina
        System.out.println(" **** Recetas de cocina ****");
        var consola = new Scanner(System.in);

        // Capturar los datos
        System.out.print("Ingrese el nombre: ");
        var nombre = consola.nextLine();
        System.out.print("Ingrese los ingredientes: ");
        var ingredientes = consola.nextLine();
        System.out.print("Ingrese el tiempo de preparación (min): ");
        var tiempoPreparacion = Integer.parseInt(consola.nextLine());
        System.out.print("Ingrese la dificultad: ");
        var dificultad = consola.nextLine();

        // Imprimir el resultado
        System.out.println("\n --- Receta de cocina --- ");
        System.out.println("Nombre receta: " + nombre);
        System.out.println("Ingredientes: " + ingredientes);
        System.out.println("Tiempo de preparación: " + tiempoPreparacion);
        System.out.println("Dificultad: " + dificultad);

    }
}
