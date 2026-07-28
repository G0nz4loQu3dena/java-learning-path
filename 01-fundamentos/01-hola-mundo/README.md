# 01 - Hola Mundo

<div align="justify">

[← Módulo 1: Fundamentos](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- La estructura mínima que necesita todo programa Java para funcionar.
- Qué es una clase, qué es un método, y por qué `main` es especial.
- Cómo mostrar texto en la consola.

## Antes de escribir código: preguntas para pensar

<div align="justify">

Mira este código completo (es el programa entero, no un fragmento):

</div>

```java
public class App {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
```

1. Hay palabras que se repiten en casi todo código Java que vas a ver: `public`, `static`, `void`. Sin buscar la respuesta todavía, ¿qué crees que significa cada una, aunque sea intuitivamente?
2. ¿Por qué crees que el nombre del archivo (`App.java`) tiene que coincidir exactamente con el nombre de la clase (`public class App`)?

## Conceptos, paso a paso

<div align="justify">

**Un programa Java siempre vive dentro de una clase.** No puedes escribir código "suelto" en un archivo `.java` como sí se podría en otros lenguajes — todo tiene que estar dentro de `public class App { ... }`. Por ahora piensa en la clase como "el contenedor" de tu programa; en el módulo 2 vas a entender a fondo qué es realmente una clase.

</div>

<div align="justify">

**`public static void main(String[] args)` es el punto de entrada.** Cuando ejecutas un programa Java, la JVM (la máquina virtual que corre tu código) busca **exactamente** un método con esta firma y empieza a ejecutar desde ahí:

</div>

- `public` — cualquiera puede ejecutar este método (necesario, porque la JVM lo llama desde afuera de tu clase).
- `static` — no necesitas crear un objeto de la clase `App` para correr `main`; existe sin depender de ninguna instancia. (En el módulo 2 vas a ver la diferencia entre algo `static` y algo que no lo es.)
- `void` — este método no devuelve ningún valor.
- `String[] args` — un arreglo de textos que la terminal te puede pasar como argumentos al ejecutar el programa (no lo vas a usar en este proyecto, pero siempre está ahí).

<div align="justify">

**`System.out.println(...)` imprime texto en la consola**, agregando un salto de línea al final (`println` = "print line"). `System` es una clase de Java, `out` es un objeto dentro de esa clase que representa "la salida estándar" (tu terminal), y `println` es el método que hace la impresión.

</div>

<div align="justify">

**Por qué el nombre del archivo debe coincidir con la clase pública:** Java exige que, si una clase está marcada como `public`, el archivo debe llamarse exactamente igual (`App.java` para `class App`). Es una regla del lenguaje, no una convención opcional — si no coinciden, no compila.

</div>

## Cómo compilar y ejecutar

```bash
javac src/App.java -d out
java -cp out App
```

<div align="justify">

Deberías ver `Hello, World!` impreso en la consola.

</div>
