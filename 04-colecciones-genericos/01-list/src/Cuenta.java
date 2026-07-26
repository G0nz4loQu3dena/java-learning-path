import java.math.BigDecimal;

public class Cuenta implements Comparable<Cuenta> {
  private final String nombreTitular;
  private final String numeroCuenta;
  private BigDecimal saldoDisponible;

  public Cuenta(String nombreTitular, String numeroCuenta, BigDecimal saldoDisponible) {

    if (nombreTitular == null || nombreTitular.isEmpty()) {
      throw new IllegalArgumentException("El nombre del titular no puede ser nulo o vacío.");
    }

    if (numeroCuenta == null || numeroCuenta.isEmpty()) {
      throw new IllegalArgumentException("El número de cuenta no puede ser nulo o vacío.");
    }

    if (saldoDisponible == null || saldoDisponible.compareTo(BigDecimal.ZERO) < 0) {
      throw new IllegalArgumentException("El saldo disponible no puede ser nulo o negativo.");
    }

    this.nombreTitular = nombreTitular;
    this.numeroCuenta = numeroCuenta;
    this.saldoDisponible = saldoDisponible;
  }

  public boolean depositar(BigDecimal monto) {
    if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("El monto a depositar debe ser mayor que cero.");
    }
    saldoDisponible = saldoDisponible.add(monto);
    return true;
  }

  public boolean retirar(BigDecimal monto) {
    if (monto == null || monto.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException("El monto a retirar debe ser mayor que cero.");
    }
    if (monto.compareTo(saldoDisponible) > 0) {
      throw new IllegalArgumentException("Fondos insuficientes para realizar el retiro.");
    }
    saldoDisponible = saldoDisponible.subtract(monto);
    return true;
  }

  protected void ajustarSaldo(BigDecimal delta) {
    saldoDisponible = saldoDisponible.add(delta);
  }

  @Override
  public String toString() {
    return "Cuenta{" +
        "nombreTitular='" + nombreTitular + '\'' +
        ", numeroCuenta='" + numeroCuenta + '\'' +
        ", saldoDisponible=" + saldoDisponible +
        '}';
  }

  @Override
  public int compareTo(Cuenta otraCuenta) {
    return this.saldoDisponible.compareTo(otraCuenta.saldoDisponible);
  }

  public String getNombreTitular() {
    return nombreTitular;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public BigDecimal getSaldoDisponible() {
    return saldoDisponible;
  }
}
