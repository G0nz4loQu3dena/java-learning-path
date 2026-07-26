import java.math.BigDecimal;

public class CuentaCorriente extends Cuenta {

  private final BigDecimal limiteSobregiro;

  public CuentaCorriente(
      String nombreTitular,
      String numeroCuenta,
      BigDecimal saldoDisponible,
      BigDecimal limiteSobregiro) {
    super(nombreTitular, numeroCuenta, saldoDisponible);

    if (limiteSobregiro == null || limiteSobregiro.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("El límite de sobregiro no puede ser nulo o negativo.");
    }

    this.limiteSobregiro = limiteSobregiro;
  }

  @Override
  public String toString() {
    return "CuentaCorriente{" +
        "nombreTitular='" + getNombreTitular() + '\'' +
        ", numeroCuenta='" + getNumeroCuenta() + '\'' +
        ", saldoDisponible=" + getSaldoDisponible() +
        ", limiteSobregiro=" + limiteSobregiro +
        '}';
  }

  @Override
  public boolean retirar(BigDecimal monto) {
    if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("El monto a retirar debe ser mayor que cero.");
    }
    if (monto.compareTo(getSaldoDisponible().add(limiteSobregiro)) > 0) {
      throw new IllegalArgumentException("Fondos insuficientes para realizar el retiro.");
    }
    ajustarSaldo(monto.negate());
    return true;
  }
}
