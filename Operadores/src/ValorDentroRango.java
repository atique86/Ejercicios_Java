import java.util.Scanner;

public class ValorDentroRango {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        System.out.println(" **** Determinar si una valor está dentro de un rango (0 - 5) **** ");
        final var MINIMO = 0;
        final var MAXIMO = 5;
        System.out.print("Ingrese un valor entero: ");
        var valor = Integer.parseInt(consola.nextLine());
        boolean estaRango;
        estaRango = valor >=MINIMO && valor <=MAXIMO;
        System.out.println("El valor ingresado está dentro del rango entre 0 y 5? : " + estaRango);
    }
}
