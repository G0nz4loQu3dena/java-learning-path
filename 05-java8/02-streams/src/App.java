import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
        // Crear la lista de canciones de prueba
        List<Cancion> canciones = new ArrayList<>();

        canciones.add(new Cancion("Bohemian Rhapsody", "Queen", "Rock", 355, 1_800_000_000L));
        canciones.add(new Cancion("Blinding Lights", "The Weeknd", "Pop", 200, 3_500_000_000L));
        canciones.add(new Cancion("Hotel California", "Eagles", "Rock", 391, 900_000_000L));
        canciones.add(new Cancion("Shape of You", "Ed Sheeran", "Pop", 233, 3_800_000_000L));
        canciones.add(nComew Cancion("Smells Like Teen Spirit", "Nirvana", "Rock", 301, 1_000_000_000L));
        canciones.add(new Cancion("Levitating", "Dua Lipa", "Pop", 203, 1_200_000_000L));

        System.out.println("Canciones de prueba:");
        imprimirElementos(canciones, System.out::println);

        // Un solo pipeline: 1. filtra, 2. transforma a título, 3. colecciona en
        // List<String>
        var titulosMuyReproducidos = canciones
                .stream()
                .filter(cancion -> cancion.getReproducciones() > 1_500_000_000L)
                .map(Cancion::getTitulo)
                .collect(Collectors.toList());

        // 4. imprime la lista resultante
        imprimirElementos(titulosMuyReproducidos, System.out::println);
    }

    public static <T> void imprimirElementos(List<T> elementos, Consumer<T> accion) {
        for (T elemento : elementos) {
            accion.accept(elemento);
        }
    }
}
