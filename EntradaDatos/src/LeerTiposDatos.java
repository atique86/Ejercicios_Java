import java.util.Scanner;

public class LeerTiposDatos {
    public static void main(String[] args) {
        // Leer distintos tipos de datos
        // Leer tipo int
        var consola = new Scanner(System.in);
        System.out.print("Ingrese su edad: ");
        var edad = consola.nextInt();
        consola.nextLine(); // Consumir el salto de línea pendiente
        System.out.println("edad = " + edad);

        // Leer tipo double
        System.out.print("Ingrese su altura (mts): ");
        double altura = consola.nextDouble();
        consola.nextLine(); // Consumir el salto de línea pendiente
        //double altura = Double.parseDouble(consola.nextLine());
        System.out.println("altura = " + altura);

        // Conversión de datos
        System.out.print("Proporciona un valor entero: ");
        var enteroString = consola.nextLine();
        var entero = Integer.parseInt(enteroString);
        System.out.println("entero = " + entero);

        // Tipo flotante
        System.out.print("Proporciona un valor de tipo flotante: ");
        var flotante = Float.parseFloat(consola.nextLine());
        System.out.println("flotante = " + flotante);

        // Cerrar el Scanner
        consola.close();

    }
}
