import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        // Crear la lista de ciudades de prueba
        List<Ciudad> ciudades = new ArrayList<>();

        ciudades.add(new Ciudad("Lima", "Perú", 10_000_000L, 19.5));
        ciudades.add(new Ciudad("Bogotá", "Colombia", 7_800_000L, 14.0));
        ciudades.add(new Ciudad("Santiago", "Chile", 6_300_000L, 15.0));
        ciudades.add(new Ciudad("Ciudad de México", "México", 9_200_000L, 17.5));
        ciudades.add(new Ciudad("Buenos Aires", "Argentina", 3_100_000L, 18.0));

        System.out.println("Ciudades de prueba:");
        for (Ciudad ciudad : ciudades) {
            System.out.println(ciudad);
        }

        // Caso: el nombre SÍ existe
        var ciudadEncontradaPorNombre = buscarPorNombre(ciudades, "Lima")
                .orElseThrow(() -> new NoSuchElementException());
        System.out.println("\nCiudad encontrada: " + ciudadEncontradaPorNombre.getNombre());

        // Caso: el nombre NO existe
        try {
            buscarPorNombre(ciudades, "Madrid")
                    .orElseThrow(() -> new NoSuchElementException("No se encontró la ciudad 'Madrid'."));
        } catch (NoSuchElementException e) {
            System.out.println("Excepción esperada: " + e.getMessage());
        }
    }

    public static Optional<Ciudad> buscarPorNombre(List<Ciudad> ciudades, String nombreCiudad) {
        return ciudades.stream().filter(ciudad -> ciudad.getNombre().equals(nombreCiudad)).findFirst();
    }
}
