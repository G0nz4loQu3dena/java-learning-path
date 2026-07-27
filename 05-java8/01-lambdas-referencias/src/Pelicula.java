public class Pelicula {
  private final String titulo;
  private final String director;
  private final int anioEstreno;
  private final double calificacion;

  public Pelicula(String titulo, String director, int anioEstreno, double calificacion) {
    if (titulo == null || titulo.isEmpty()) {
      throw new IllegalArgumentException("El título no puede ser nulo o vacío.");
    }

    if (director == null || director.isEmpty()) {
      throw new IllegalArgumentException("El director no puede ser nulo o vacío.");
    }

    if (calificacion < 0 || calificacion > 10) {
      throw new IllegalArgumentException("La calificación debe estar entre 0 y 10.");
    }

    this.titulo = titulo;
    this.director = director;
    this.anioEstreno = anioEstreno;
    this.calificacion = calificacion;
  }

  @Override
  public String toString() {
    return "Pelicula{" +
        "titulo='" + titulo + '\'' +
        ", director='" + director + '\'' +
        ", anioEstreno=" + anioEstreno +
        ", calificacion=" + calificacion +
        '}';
  }

  public boolean esExcelente() {
    return (calificacion >= 8.8);
  }

  public String getTitulo() {
    return titulo;
  }

  public String getDirector() {
    return director;
  }

  public int getAnioEstreno() {
    return anioEstreno;
  }

  public double getCalificacion() {
    return calificacion;
  }
}
