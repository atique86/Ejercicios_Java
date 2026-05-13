import java.util.Scanner;

public class SistemaTiendaEnLinea {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        final double COMPRA_MINIMA = 1000;
        final double PORCENTAJE_DESCUENTO_ALTO_MIEMBRO = 0.10; // 10%
        final double PORCENTAJE_DESCUENTO_BAJO_MIEMBRO = 0.05; // 5%
        System.out.println(" **** Tienda en Línea con Descuentos **** ");
        System.out.print("Cuál fue el monto de su compra: ");
        var montoCompra = Double.parseDouble(consola.nextLine());
        System.out.print("Usted es miembro de la tienda (true/false)?: ");
        var esMiembro = Boolean.parseBoolean(consola.nextLine()); 

        if (montoCompra > COMPRA_MINIMA && esMiembro) {
            var descuento = montoCompra * PORCENTAJE_DESCUENTO_ALTO_MIEMBRO;
            var montoFinal = montoCompra - descuento;
            System.out.printf("""
                \nFelicidades, usted ha obtenido un descuento del 10%%
                Monto de la compra: $%.2f
                Monto del descuento: $%.2f
                Monto final de la compra con descuento: $%.2f
                """, montoCompra, descuento, montoFinal);
        } else if (montoCompra <= COMPRA_MINIMA && esMiembro) {
            var descuento = montoCompra * PORCENTAJE_DESCUENTO_BAJO_MIEMBRO;
            var montoFinal = montoCompra - descuento;
            System.out.printf("""
                \nFelicidades, usted ha obtenido un descuento del 5%%
                Monto de la compra: $%.2f
                Monto del descuento: $%.2f
                Monto final de la compra con descuento: $%.2f
            """,montoCompra, descuento, montoFinal);
        } else {
            System.out.printf("""
                    \nNo obtuvo ningún tipo de descuento
                    Lo invitamos a hacerse miembro de la tienda
                    Monto final de la compra: $%.2f
                    """, montoCompra);
        }
        consola.close();
    }
}