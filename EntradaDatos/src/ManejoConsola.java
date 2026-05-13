import java.util.Scanner;

public class ManejoConsola {
    public static void main(String[] args) {
        // Introducir valores por consola
        var scanner = new Scanner(System.in); // Entrada de datos
        System.out.print("Escribe tu nombre: ");
        var nombre = scanner.nextLine();
        System.out.println("nombre = " + nombre);
    }
}
