import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class App {
    public static void main(String[] args) {
        LocalDate miFechaNacimiento = LocalDate.of(2003, 6, 20);

        // Formatear con patrón numérico dd/MM/yyyy (sin dependencia de idioma)
        DateTimeFormatter formatoNumerico = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String miFechaNacimientoFormateadoNumerico = miFechaNacimiento.format(formatoNumerico);
        System.out.println(miFechaNacimientoFormateadoNumerico);

        // Formatear con nombre de mes en inglés, usando Locale
        DateTimeFormatter formatoIngles = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
        String miFechaNacimientoFormateadoIngles = miFechaNacimiento.format(formatoIngles);
        System.out.println(miFechaNacimientoFormateadoIngles);

        // Parsear: texto -> LocalDate, usando el mismo formateador numérico
        String textoDeFecha = "25/12/2010";
        LocalDate fechaParseada = LocalDate.parse(textoDeFecha, formatoNumerico);
        System.out.println(fechaParseada);
    }
}
