public class TipoVar {
    public static void main(String[] args) {
        //Sin el uso de var
        String nombre = "Juan";
        System.out.println("nombre = " + nombre);

        //Con el uso de var / Se le debe asignar un valor al crear la variable
        var nombre2 = "Carlos";
        System.out.println("nombre2 = " + nombre2);

        //Definir otros variables usando var
        var edad = 25;
        System.out.println("edad = " + edad);
        var sueldo = 5000.5F; //Se infiere tipo float
        System.out.println("sueldo = " + sueldo);
        var esCasado = false; //Se infiere tipo boolean
        System.out.println("esCasado = " + esCasado);
    }
}
