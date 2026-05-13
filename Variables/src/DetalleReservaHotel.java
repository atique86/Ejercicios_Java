public class DetalleReservaHotel {
    public static void main(String[] args) {
        //Declarar variables y asignar valores
        var nombre = "Carlos";
        var apellido = "Castro";
        var diasEstancia = 5;
        var tarifaDiaria = 150.75;
        var vistaAlMar = false;
        var tarifaTotal = diasEstancia * tarifaDiaria;

        //Imprimir el valor de las variables
        System.out.println(" **** Sistema de Reserva de Hoteles **** ");
        System.out.println("Nombre Completo = " + nombre + " " + apellido);
        System.out.println("diasEstancia = " + diasEstancia);
        System.out.println("tarifaDiaria = " + tarifaDiaria);
        System.out.println("vistaAlMar = " + vistaAlMar);
        System.out.println("tarifaTotal = " + tarifaTotal);

        // Modificar los valores de las variables
        nombre = "Jairo";
        apellido = "Pulgarín";
        diasEstancia = 7;
        tarifaDiaria = 140.80;
        vistaAlMar = true;
        tarifaTotal = diasEstancia * tarifaDiaria;

        //Imprimir el valor de las variables
        System.out.println("\n");
        System.out.println("Nombre Completo = " + nombre + " " + apellido);
        System.out.println("diasEstancia = " + diasEstancia);
        System.out.println("tarifaDiaria = " + tarifaDiaria);
        System.out.println("vistaAlMar = " + vistaAlMar);
        System.out.println("tarifaTotal = " + tarifaTotal);
    }
}
