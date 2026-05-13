import java.util.Scanner;

public class SistemaDescuentosVIP {
    public static void main(String[] args) {
        System.out.println(" **** Sistema de Descuentos VIP **** ");
        final var NO_PRODUCTOS_DESCUENTO = 10;
        var consola = new Scanner(System.in);

        System.out.print("¿Cuántos productos compraste el día de hoy?: ");
        var cantidadProductos = Integer.parseInt(consola.nextLine());

        System.out.print("¿Tiene la membresía de la tienda (true/false)?: ");
        var tieneMembresia = Boolean.parseBoolean(consola.nextLine());

        var esElegibleDescuentoVIP = cantidadProductos >= NO_PRODUCTOS_DESCUENTO && tieneMembresia;
        System.out.println("Tiene acceso al  Descuento VIP = " + esElegibleDescuentoVIP);
    }
}
