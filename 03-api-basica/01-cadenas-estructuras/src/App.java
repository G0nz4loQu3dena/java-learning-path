public class App {
    public static void main(String[] args) {
        // Creando un arreglo estático de cadenas
        String[] palabras = {"Hola", "mundo", "desde", "Java"};
        // Definiendo un separador
        String separador = "-";
        // Llamando al método unirPalabras para unir las palabras con el separador
        String resultado = unirPalabras(palabras, separador);
        // Mostrando el resultado en la consola
        System.out.println(resultado);

        // Modificando el arreglo de palabras en un indice que no existe para 
        // demostrar que no se puede acceder a un índice fuera del rango del arreglo
        // palabras[4] = "extra";
        // Esto lanzará un ArrayIndexOutOfBoundsException en tiempo de ejecución, 
        // ya que el arreglo tiene un tamaño de 4 y los índices válidos son 0, 1, 2 y 3.
        // Si descomentas la siguiente línea, verás el error:
        
        //palabras[4] = "extra";
    }

    public static String unirPalabras(String[] palabras, String separador) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < palabras.length; ++i) {
            resultado.append(palabras[i]);
            if (i < palabras.length - 1) {
                resultado.append(separador);
            }
        }
        return resultado.toString();
    }
}
