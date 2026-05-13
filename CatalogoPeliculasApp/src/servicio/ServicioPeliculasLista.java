package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas{

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista() {
        this.peliculas = new ArrayList<>();
    }

    @Override
    public void listarPeliculas() {
        System.out.println("Listado de películas: ");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agregó la película: " + pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var indice = peliculas.indexOf(pelicula);
        if (indice == -1) {
            System.out.println("No se encontró la película: " + pelicula);
        }else {
            System.out.println("Película encontrada en el indice: " + indice);
        }

    }

    public static void main(String[] args) {
        // Creamos objetos de tipo pelicula
        var pelicula1 = new Pelicula("La casa de papel");
        var pelicula2 = new Pelicula("Batman");
        var pelicula3 = new Pelicula("El hobbit");
        // Crear objeto de servicio (patron de diseño service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        // Agregar peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);
        servicioPeliculas.agregarPelicula(pelicula3);
        // Listar peliculas
        servicioPeliculas.listarPeliculas();
        // Buscar pelicula (se debe eimplementar el metodo equal y hashcode
        servicioPeliculas.buscarPelicula(new Pelicula("Old Boy"));
    }
}
