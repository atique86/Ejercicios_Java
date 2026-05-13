public class DetalleLibro {
    public static void main(String[] args) {
        //Detalle de un libro
        String tituloLibro = "El señor de los anillos";
        int anioPublicacion = 1954;
        boolean libroDisponible = true;
        double precio = 500.50;

        //Imprimir el valor de las variables
        System.out.println("Titulo del libro: " + tituloLibro);
        System.out.println("Año de publicación: " + anioPublicacion);
        System.out.println("Libro disponible para la venta: " + libroDisponible);
        System.out.println("Precio: " + precio);

        //Modificar el titulo del libro
        tituloLibro = "El Señor de los Anillos";
        System.out.println("Titulo del libro: " + tituloLibro);
    }
}
