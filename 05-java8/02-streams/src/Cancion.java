public class Cancion {
  private final String titulo;
  private final String artista;
  private final String genero;
  private final int duracionSegundos;
  private final long reproducciones;

  public Cancion(String titulo, String artista, String genero, int duracionSegundos, long reproducciones) {
    if (titulo == null || titulo.isEmpty()) {
      throw new IllegalArgumentException("El título no puede ser nulo o vacío.");
    }

    if (artista == null || artista.isEmpty()) {
      throw new IllegalArgumentException("El artista no puede ser nulo o vacío.");
    }

    if (genero == null || genero.isEmpty()) {
      throw new IllegalArgumentException("El género no puede ser nulo o vacío.");
    }

    if (duracionSegundos <= 0) {
      throw new IllegalArgumentException("La duración debe ser mayor a cero.");
    }

    if (reproducciones < 0) {
      throw new IllegalArgumentException("Las reproducciones no pueden ser negativas.");
    }

    this.titulo = titulo;
    this.artista = artista;
    this.genero = genero;
    this.duracionSegundos = duracionSegundos;
    this.reproducciones = reproducciones;
  }

  @Override
  public String toString() {
    return "Cancion{" +
        "titulo='" + titulo + '\'' +
        ", artista='" + artista + '\'' +
        ", genero='" + genero + '\'' +
        ", duracionSegundos=" + duracionSegundos +
        ", reproducciones=" + reproducciones +
        '}';
  }

  public String getTitulo() {
    return titulo;
  }

  public String getArtista() {
    return artista;
  }

  public String getGenero() {
    return genero;
  }

  public int getDuracionSegundos() {
    return duracionSegundos;
  }

  public long getReproducciones() {
    return reproducciones;
  }
}
