public class GeneradorEmail {
    public static void main(String[] args) {
        // Creación y asignación de valores de las variables
        var nombres = "Juan Pablo";
        var apellidos = "Perez Ossa";
        var nombreEmpresa = "Universidad CUN";
        var dominio = ".edu.co";

        // Normalizar valores
        var nombresNormalizado = nombres.toLowerCase().replace(" ",".");
        var apellidosNormalizado = apellidos.toLowerCase().replace(" ",".");
        var nombreEmpresaNormalizado = nombreEmpresa.toLowerCase().replace(" ","");

        // Concatenar para generar el correo electronico
        var stringBuffer = new StringBuffer();
        stringBuffer.append(nombresNormalizado).append(".").append(apellidosNormalizado).append("@").append(nombreEmpresaNormalizado).append(dominio);
        var email = stringBuffer.toString();

        // Imprimir los resultados
        System.out.println(" **** Generador de Email **** ");
        System.out.println("Nombre usuario: " + nombres + " " + apellidos);
        System.out.println("Nombre usuario normalizado: " + nombresNormalizado + "." + apellidosNormalizado);
        System.out.println(String.join(" ","\nNombre Empresa:",nombreEmpresa));
        System.out.println(String.join(" ","Extensión del dominio:",dominio));
        System.out.println("Dominio del email normalizado: " + nombreEmpresaNormalizado+dominio);
        System.out.println(String.join(" ","\nEmail final generado:",email));

    }
}
