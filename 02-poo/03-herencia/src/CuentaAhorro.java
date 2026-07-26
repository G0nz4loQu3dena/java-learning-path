import java.math.BigDecimal;
import java.math.RoundingMode;

public class CuentaAhorro extends Cuenta {

  private final BigDecimal tasaInteres;

  public CuentaAhorro(
      String nombreTitular,
      String numeroCuenta,
      BigDecimal saldoDisponible,
      BigDecimal tasaInteres) {
    super(nombreTitular, numeroCuenta, saldoDisponible);

    if (tasaInteres == null || tasaInteres.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("La tasa de interés no puede ser nula o negativa.");
    }

    this.tasaInteres = tasaInteres;
  }

  @Override
  public String toString() {
    return "CuentaAhorro{" +
        "nombreTitular='" + getNombreTitular() + '\'' +
        ", numeroCuenta='" + getNumeroCuenta() + '\'' +
        ", saldoDisponible=" + getSaldoDisponible() +
        ", tasaInteres=" + tasaInteres +
        '}';
  }

  public BigDecimal aplicarInteres() {
    BigDecimal interes = getSaldoDisponible()
      .multiply(tasaInteres)
      .setScale(2, RoundingMode.HALF_UP);
    ajustarSaldo(interes);
    return interes;
  }
}
