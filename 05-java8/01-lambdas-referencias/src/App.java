import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        // Crear la lista de películas de prueba
        List<Pelicula> peliculas = new ArrayList<>();

        peliculas.add(new Pelicula("Inception", "Christopher Nolan", 2010, 8.8));
        peliculas.add(new Pelicula("The Godfather", "Francis Ford Coppola", 1972, 9.2));
        peliculas.add(new Pelicula("Parasite", "Bong Joon-ho", 2019, 8.6));
        peliculas.add(new Pelicula("Interstellar", "Christopher Nolan", 2014, 8.6));
        peliculas.add(new Pelicula("Pulp Fiction", "Quentin Tarantino", 1994, 8.9));

        // Imprimir la lista sin ordenar
        System.out.println("\nPelículas NO ordenadas:");
        imprimirPeliculas(peliculas);

        // Ordenar con Comparator: calificación descendente, desempate por año descendente
        System.out.println("\nPelículas SI ordenadas:");
        Comparator<Pelicula> porCalificacionYAnio = Comparator
        .comparing(Pelicula::getCalificacion)
        .reversed()
        .thenComparing(Pelicula::getAnioEstreno, Comparator.reverseOrder());
        peliculas.sort(porCalificacionYAnio);
        imprimirPeliculas(peliculas);

        // Referencia a un método estático: Clase::metodoEstatico
        Function<String, Integer> convertirAnio = Integer::parseInt;
        int anioConvertido = convertirAnio.apply("1994");
        System.out.println("\nAño convertido desde texto con Integer::parseInt: " + anioConvertido);

        // Referencia a un método de instancia de un objeto YA EXISTENTE: instancia::metodo
        Consumer<Pelicula> imprimirUnaPelicula = System.out::println;
        System.out.println("\nUsando Consumer con System.out::println:");
        imprimirUnaPelicula.accept(peliculas.get(0));

        // Referencia a un constructor: Clase::new
        Supplier<List<Pelicula>> fabricaDeListas = ArrayList::new;
        List<Pelicula> otraLista = fabricaDeListas.get();
        otraLista.add(new Pelicula("Coco", "Lee Unkrich", 2017, 8.4));
        System.out.println("\nNueva lista creada con Supplier + ArrayList::new: " + otraLista);

        // Function<T, R>: recibe un valor, devuelve otro (una transformación)
        Function<Pelicula, String> resumen = pelicula -> pelicula.toString();
        System.out.println("\nResúmenes con Function:");
        for (Pelicula pelicula : peliculas) {
            System.out.println(resumen.apply(pelicula));
        }

        // Predicate<T>: recibe un valor, devuelve boolean (una condición/filtro)
        Predicate<Pelicula> esExcelente = pelicula -> pelicula.esExcelente();
        System.out.println("\nPelículas con calificación >= 8.8 (Predicate):");
        for (Pelicula pelicula : peliculas) {
            if (esExcelente.test(pelicula)) {
                System.out.println(pelicula.getTitulo());
            }
        }
    }

    public static void imprimirPeliculas(List<Pelicula> peliculas) {
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }
}
