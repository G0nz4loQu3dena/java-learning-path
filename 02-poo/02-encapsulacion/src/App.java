import java.math.BigDecimal;
import java.util.Date;

public class App {
    public static void main(String[] args) throws Exception {
       CuentaBancaria cuenta1 = new CuentaBancaria("John Doe", "123456789", "987654321", BigDecimal.valueOf(1000), new Date());
       System.out.println(cuenta1);
    }
}
