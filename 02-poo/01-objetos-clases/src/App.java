import java.math.BigDecimal;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {

        CuentaBancaria cuenta1 = new CuentaBancaria(
                "Juan Perez", "1234567890", "0987654321", new BigDecimal("1000.00"), new Date());

        if (cuenta1.depositar(new BigDecimal("200.00"))) {
            System.out.println("Depósito exitoso");
        } else {
            System.out.println("Depósito fallido");
        }

        if (cuenta1.retirar(new BigDecimal("500.00"))) {
            System.out.println("Retiro exitoso");
        } else {
            System.out.println("Retiro fallido");
        }

        System.out.println("Nombre del titular: " + cuenta1.getNombreTitular());
        System.out.println("Número de cuenta: " + cuenta1.getNumeroCuenta());
        System.out.println("Número de cuenta CCI: " + cuenta1.getNumeroCuentaCci());
        System.out.println("Saldo disponible: " + cuenta1.getSaldoDisponible());
        System.out.println("Fecha de creación: " + cuenta1.getFechaCreacion());
    }
}
