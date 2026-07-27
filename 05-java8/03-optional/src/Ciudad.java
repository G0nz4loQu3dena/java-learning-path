public class Ciudad {
  private final String nombre;
  private final String pais;
  private final long poblacion;
  private final double temperaturaPromedio;

  public Ciudad(String nombre, String pais, long poblacion, double temperaturaPromedio) {
    if (nombre == null || nombre.isEmpty()) {
      throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
    }

    if (pais == null || pais.isEmpty()) {
      throw new IllegalArgumentException("El país no puede ser nulo o vacío.");
    }

    if (poblacion <= 0) {
      throw new IllegalArgumentException("La población debe ser mayor a cero.");
    }

    this.nombre = nombre;
    this.pais = pais;
    this.poblacion = poblacion;
    this.temperaturaPromedio = temperaturaPromedio;
  }

  @Override
  public String toString() {
    return "Ciudad{" +
        "nombre='" + nombre + '\'' +
        ", pais='" + pais + '\'' +
        ", poblacion=" + poblacion +
        ", temperaturaPromedio=" + temperaturaPromedio +
        '}';
  }

  public String getNombre() {
    return nombre;
  }

  public String getPais() {
    return pais;
  }

  public long getPoblacion() {
    return poblacion;
  }

  public double getTemperaturaPromedio() {
    return temperaturaPromedio;
  }
}
