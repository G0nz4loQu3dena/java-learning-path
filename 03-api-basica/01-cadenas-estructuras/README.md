# 01 - Cadenas y Estructuras

<div align="justify">

[← Módulo 3: API básica](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Por qué `String` es inmutable, y el bug clásico que causa no saberlo.
- `StringBuilder` como alternativa mutable, y por qué importa para el rendimiento.
- `Arrays` de tamaño fijo — y qué pasa si te pasas del límite.
- Extraer lógica a métodos propios para reutilizar código.

## Antes de escribir código: preguntas para pensar

1. Mira este código:
   ```java
   String saludo = "Hola";
   saludo.concat(" Mundo");
   System.out.println(saludo);
   ```
   ¿Qué imprime esto — `"Hola"` o `"Hola Mundo"`? Piensa en lo que ya sabes de `BigDecimal`: `monto.negate()` no modifica `monto`, devuelve un valor nuevo. ¿`String` se comporta igual?
2. Si concatenas texto dentro de un `for` con `resultado += "x";` miles de veces, ¿por qué crees que esto podría ser lento? Piensa en qué pasa "por dentro" cada vez que ejecutas esa línea.
3. Si declaras `String[] palabras = {"Hola", "mundo"};` y luego intentas `palabras[5] = "extra";`, ¿eso compila? Si compila, ¿qué pasa al ejecutarlo?

## Conceptos, paso a paso

<div align="justify">

**`String` es inmutable — igual que `BigDecimal`.** Ningún método de `String` modifica el objeto original; todos devuelven un `String` **nuevo**. En la Pregunta 1, `saludo.concat(" Mundo");` sí crea un nuevo objeto `"Hola Mundo"` en memoria, pero como no lo asignas a ninguna variable, se pierde inmediatamente — `saludo` sigue apuntando al `"Hola"` original. El resultado es `"Hola"`. Para que funcione, hay que **reasignar**: `saludo = saludo.concat(" Mundo");` — el mismo patrón que ya usaste en `Cuenta.ajustarSaldo()` con `saldoDisponible = saldoDisponible.add(delta);`.

</div>

<div align="justify">

**Por qué esto hace que concatenar en un loop con `+=` sea lento:** cada `resultado += "x";` en realidad crea un `String` nuevo, copiando **todo** el contenido anterior más el carácter nuevo, y descarta el viejo. Con `n` iteraciones, el trabajo total copiado crece como `1+2+3+...+n` — **O(n²)**, cuadrático. Con pocos elementos no se nota; con cientos de miles, sí.

</div>

<div align="justify">

**`StringBuilder` resuelve esto con un buffer mutable interno** (un arreglo de `char` con espacio extra reservado). `append()` casi siempre solo escribe en el espacio libre que ya existe, sin crear objetos nuevos en cada paso — el costo total termina siendo **O(n)**, lineal. Al terminar, `.toString()` te da el `String` inmutable final, una sola vez:

</div>

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 5; i++) {
    sb.append("x");
}
String resultado = sb.toString();
```

<div align="justify">

**`Arrays` son de tamaño fijo, decidido al crearlos, y nunca cambia.** Si intentas `palabras[5] = "extra";` en un array de tamaño 2, **sí compila** (el compilador no puede saber en general qué índice vas a usar en tiempo de ejecución), pero al ejecutarlo lanza `ArrayIndexOutOfBoundsException` — un error en **runtime**, no en compilación. Los índices válidos van de `0` a `length - 1`. Si necesitas una colección que sí crezca dinámicamente, eso es exactamente lo que resuelve `ArrayList` (módulo 4).

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
