import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        // Crear fecha, hora, y su combinación
        LocalDate miFechaNacimiento = LocalDate.of(2003, 6, 20);
        LocalTime horaCualquiera = LocalTime.of(6, 0, 3);
        LocalDateTime combinandoFechaHora = LocalDateTime.of(miFechaNacimiento, horaCualquiera);

        // Imprimir con el formato ISO-8601 por defecto (toString implícito)
        System.out.println(miFechaNacimiento);
        System.out.println(horaCualquiera);
        System.out.println(combinandoFechaHora);
    }
}
