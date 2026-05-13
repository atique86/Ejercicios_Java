package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            //Si ya existe el archivo, lo borramos
            if (archivo.exists()) {
                System.out.println("El archivo ya existe!");
            } else {
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Archivo creado: " + archivo.getAbsolutePath());
            }
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        // Abrimos el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de Películas");
            // Abrimos archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            // Leer linea a linea
            String linea;
            linea = entrada.readLine();
            // Leer todas las lineas del archivo
            while (linea != null) {
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                // Antes de terminar el ciclo, volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }
            // Cerrar el archivo
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        boolean anexar = true;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            // Verificar si la película ya existe
            if (!existePelicula(pelicula)) {
                // Revisar si el archivo existe
                var salida = new PrintWriter(new FileWriter(archivo,anexar));
                // Agregar película (toString)
                salida.println(pelicula);
                salida.close();
                System.out.println("Se agregó al archivo: " + pelicula);
            } else {
                System.out.println("La película '" + pelicula.getNombre() +  "' ya existe");
            }
        } catch (Exception e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    private boolean existePelicula(Pelicula pelicula) throws IOException {
        var archivo = new File(NOMBRE_ARCHIVO);
        if (!archivo.exists()) return false;

        var entrada = new BufferedReader(new FileReader(archivo));
        String linea;
        while ((linea = entrada.readLine()) != null) {
            if (linea.equalsIgnoreCase(pelicula.getNombre())) {
                entrada.close();
                return true;
            }
        }
        entrada.close();
        return false;
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try{
            // Abrir archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while (lineaTexto != null){
                // Buscamos sin importar mayusculas o minusculas
                if (peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                // Si no encontramos, volvemos al principio del archivo
                lineaTexto = entrada.readLine();
                indice++;
            }
            // Imprimir los resultados de la busqueda
            if(encontrada){
                System.out.println("La película '"  + pelicula.getNombre() + "' se encuentra en la linea: " + indice);
            } else {
                System.out.println("La película '" + pelicula.getNombre() + "' no fue encontrada");
            }
            entrada.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

    }
}
