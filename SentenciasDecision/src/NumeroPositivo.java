import java.util.Scanner;

public class NumeroPositivo {
    public static void main(String[] args) {
        System.out.println("**** Validar si un número es positivo o negativo **** ");
        Scanner consola = new Scanner(System.in);
        System.out.print("Ingrese un número entero: ");
        var numero = Integer.parseInt(consola.nextLine());
        if (numero > 0) {
            System.out.println("El número es positivo");
        } else if (numero == 0) {
            System.out.println("El número es cero");
        }else {
            System.out.println("El número es negativo");
        }
    }
}
