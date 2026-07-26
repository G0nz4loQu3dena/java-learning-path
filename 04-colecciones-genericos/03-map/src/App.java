import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;

public class App {
        public static void main(String[] args) {
                List<Cuenta> cuentas = new ArrayList<>();

                cuentas.add(
                                new CuentaAhorro("Juan Pérez", "1234567890",
                                                new BigDecimal("1000.00"),
                                                new BigDecimal("0.05")));
                cuentas.add(
                                new CuentaAhorro("Ana Gómez", "1122334455",
                                                new BigDecimal("2000.00"),
                                                new BigDecimal("0.03")));
                cuentas.add(
                                new CuentaCorriente("María López", "0987654321",
                                                new BigDecimal("1000.00"),
                                                new BigDecimal("500.00")));
                cuentas.add(
                                new CuentaCorriente("Carlos Sánchez", "5566778899",
                                                new BigDecimal("500.00"),
                                                new BigDecimal("300.00")));

                // Crear mapa de cuentas utilizando HashMap y TreeMap
                Map<String, Cuenta> mapaCuentas = new HashMap<>();
                Map<String, Cuenta> mapaCuentasTree = new TreeMap<>();
                for (Cuenta cuenta : cuentas) {
                        mapaCuentas.put(cuenta.getNumeroCuenta(), cuenta);
                        mapaCuentasTree.put(cuenta.getNumeroCuenta(), cuenta);
                }

                // Mostrar keys y valores del mapa
                System.out.println("HashMap:");
                mostrarMapa(mapaCuentas);

                System.out.println("TreeMap:");
                mostrarMapa(mapaCuentasTree);
        }

        public static void mostrarMapa(Map<String, Cuenta> mapa) {
                for (Map.Entry<String, Cuenta> entry : mapa.entrySet()) {
                        System.out.println(
                                        "Key map [Numero de cuenta]: " + entry.getKey() +
                                                        "\n, Titular: " + entry.getValue() + "\n");
                }
        }
}
