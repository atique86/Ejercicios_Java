public class DetalleProducto {
    public static void main(String[] args) {
        //Definir variables
        String nombreProducto = "Detergente Ariel";
        double precioProducto = 7.45;
        int cantidadDisponible = 80;
        boolean disponibleVenta = true;

        //Imprimir los valores de las variables
        System.out.println("nombreProducto = " + nombreProducto);
        System.out.println("precioProducto = " + precioProducto);
        System.out.println("cantidadDisponible = " + cantidadDisponible);
        System.out.println("disponibleVenta = " + disponibleVenta);

        //Modificar valor de las variables
        nombreProducto = "Detergente Ariel 1000 gr";
        precioProducto = 7.85;
        cantidadDisponible = 73;
        disponibleVenta = false;

        //Imprimir los valores de las variables
        System.out.println("nombreProducto = " + nombreProducto);
        System.out.println("precioProducto = " + precioProducto);
        System.out.println("cantidadDisponible = " + cantidadDisponible);
        System.out.println("disponibleVenta = " + disponibleVenta);
    }
}
