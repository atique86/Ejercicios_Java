public class DetallePersona {
    public static void main(String[] args) {

        //Definir las variables
        String nombrePersona = "Juan Perez Ossa";
        int edad = 45;
        float altura = 1.85F; //Altura en metros
        String paisOrigen = "Ecuador";
        char esCasado = 'S'; // Es casado donde 'C'-Casado / 'S'-Soltero

        //Imprimir el valor de las variables
        System.out.println("Nombre de la persona: " + nombrePersona);
        System.out.println("Edad: " + edad);
        System.out.println("Altura: " + altura + " mts");
        System.out.println("País de origen: " + paisOrigen);
        System.out.println("¿Es casado? (C-Casado / S-Soltero): " + esCasado);
    }
}
