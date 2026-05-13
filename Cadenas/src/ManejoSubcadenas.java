public class ManejoSubcadenas {
    public static void main(String[] args) {
        // Tema de subcadenas
        var cadena1 = "Hola Mundo";
        System.out.println("cadena1 = " + cadena1);

        // Subcadena
        var subcadena1 = cadena1.substring(0,4);
        System.out.println("subcadena1 = " + subcadena1);
        var subcadena2 = cadena1.substring(5);
        System.out.println("subcadena2 = " + subcadena2);
        var subcadena3 = cadena1.substring(5,10);
        System.out.println("subcadena3 = " + subcadena3);

        // Busqueda de subcadenas
        // indexOf - Devuelve el indice de la primer aparición de la subcadena
        var indice1 = cadena1.indexOf("Hola");
        System.out.println("indice1 = " + indice1);
        // lastIndexOf - devuelve el indice de la ultima aparición de la subcadena
        var indice2 = cadena1.lastIndexOf("Mundo");
        System.out.println("indice2 = " + indice2);
    }
}
