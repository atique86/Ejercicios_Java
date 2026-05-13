import java.util.Scanner;

public class AreaPerimetroRectangulo {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        System.out.println(" **** Calculo area y perimetro de un rectangulo **** ");
        // Solicitar dimensiones
        System.out.print("Ingrese el largo del rectangulo: ");
        double largoRectangulo = Double.parseDouble(consola.nextLine());
        System.out.print("Ingrese el ancho del rectangulo: ");
        double anchoRectangulo = Double.parseDouble(consola.nextLine());

        // Calcular el área
        double area = largoRectangulo * anchoRectangulo;

        // Calcular el perímetro
        double perimetro = 2 * (largoRectangulo + anchoRectangulo);

        // Imprimir los resultados
        System.out.printf("%nEl área del rectángulo es: %.2f%n",area);
        System.out.printf("El perímetro del rectángulo es: %.2f%n",perimetro);
    }
}
