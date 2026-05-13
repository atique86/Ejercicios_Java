package mundopc;

import mundopc.modelo.Computadora;
import mundopc.modelo.Monitor;
import mundopc.modelo.Raton;
import mundopc.modelo.Teclado;
import mundopc.servicio.Orden;

public class VentaComputadorasApp {
    public static void main(String[] args) {
        // Crear objetos
        Raton raton = new Raton("USB", "Acer");
        //System.out.println(raton);

        Teclado teclado = new Teclado("Bluetooth", "Logitech");
        //System.out.println(teclado);

        Monitor monitor = new Monitor("Acer", 27.8);
        //System.out.println(monitor);

        // Crear objeto de tipo Computadora
        Computadora computadora = new Computadora("PC Acer", monitor, raton, teclado);
        //System.out.println(computadora);

        // Objeto computadora Dos
        Monitor monitor2 = new Monitor("Asus", 27.8);
        Teclado teclado2 = new Teclado("USB", "Dell");
        Raton raton2 = new Raton("Bluetooth", "HP");
        Computadora computadora2 = new Computadora("PC Asus", monitor2, raton2, teclado2);

        // Creamos orden
        Orden orden = new Orden();
        orden.agregarComputadora(computadora);
        orden.agregarComputadora(computadora2);
        orden.imprimirOrden();

        // Computadora Mac
        Monitor monitorMac = new Monitor("MacBook", 13);
        Teclado tecladoMac = new Teclado("Bluetooth", "Apple");
        Raton ratonMac = new Raton("Bluetooth", "Apple");
        Computadora computadoraMac = new Computadora("MacBook Pro", monitorMac, ratonMac, tecladoMac);

        Orden ordenMac = new Orden();
        ordenMac.agregarComputadora(computadoraMac);
        ordenMac.agregarComputadora(computadora);
        ordenMac.agregarComputadora(computadora2);
        System.out.println();
        ordenMac.imprimirOrden();
    }
}