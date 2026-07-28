# 04 - Control de Flujo

<div align="justify">

[← Módulo 1: Fundamentos](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Decisiones: `if` / `else if` / `else` y `switch`.
- Repeticiones: `for`, `while`, `do-while`.
- La diferencia real entre `while` y `do-while` (no es solo un detalle de sintaxis).

## Antes de escribir código: preguntas para pensar

1. Este código tiene una condición que siempre es falsa desde el inicio:

   ```java
   int numero = 0;
   do {
       System.out.println("Hola");
       numero++;
   } while (numero < 0);
   ```

   ¿Cuántas veces crees que se imprime `"Hola"` — cero veces, una vez, o más? ¿Qué pasaría si en vez de `do-while` fuera un `while` normal con la misma condición al principio?
2. Un `switch` necesita la palabra `break` al final de cada `case` (si no la pones, sigue ejecutando el siguiente `case` de corrido, un comportamiento llamado *fall-through*). ¿Por qué crees que Java diseñó el `switch` así, en vez de que cada `case` se detenga automáticamente al terminar?

## Conceptos, paso a paso

<div align="justify">

**`if` / `else if` / `else`** evalúan condiciones en orden, de arriba hacia abajo, y ejecutan **solo la primera** que sea verdadera:

</div>

```java
if (nota >= 90 && nota <= 100) {
    resultado = 'A';
} else if (nota >= 80 && nota < 90) {
    resultado = 'B';
} else {
    resultado = 'D';
}
```

<div align="justify">

Ni bien una condición da `true`, Java ejecuta ese bloque y **se salta todo el resto** — no sigue evaluando las condiciones de abajo, aunque también fueran verdaderas.

</div>

<div align="justify">

**`switch`** compara una variable contra varios valores posibles, como una alternativa más legible a una cadena larga de `if`/`else if` cuando todas las comparaciones son contra el mismo valor exacto:

</div>

```java
switch (diaSemana) {
    case 1: dia = "Lunes"; break;
    case 2: dia = "Martes"; break;
    default: dia = "Día no válido";
}
```

<div align="justify">

**El `break` no es opcional aunque el compilador no te obligue a ponerlo.** Si lo olvidas, Java sigue ejecutando el `case` siguiente sin volver a evaluar la condición (*fall-through*) — un error clásico y silencioso en código Java real. `default` es el caso "si ninguno de los anteriores aplicó".

</div>

<div align="justify">

**Los tres tipos de bucles, y cuándo usar cada uno:**

</div>

- **`for`** — cuando sabes de antemano **cuántas veces** vas a repetir algo (o tienes un contador claro):
  ```java
  for (int i = 1; i <= 5; i++) {
      System.out.print(i + " ");
  }
  ```
  Las tres partes son: inicialización (`int i = 1`, se ejecuta una sola vez al principio), condición (`i <= 5`, se revisa antes de cada vuelta), y actualización (`i++`, se ejecuta al final de cada vuelta).

- **`while`** — cuando **no** sabes cuántas veces de antemano, solo sabes la condición de parada:
  ```java
  int suma = 0, contador = 1;
  while (contador <= 10) {
      suma += contador;
      contador++;
  }
  ```
  La condición se revisa **antes** de cada vuelta — si es falsa desde el principio, el bloque nunca se ejecuta ni una vez.

- **`do-while`** — igual que `while`, pero la condición se revisa **al final**, no al principio. Esto garantiza que el bloque se ejecute **al menos una vez**, sin importar si la condición ya era falsa desde el arranque. Es la respuesta a la Pregunta 1: el `do-while` de tu código imprime `"Hola"` **una vez**, aunque `numero < 0` sea falso desde el inicio (`numero` empieza en `0`) — porque el cuerpo se ejecuta primero, y la condición recién se revisa después. Con un `while` normal y la misma condición, el bloque **nunca** se habría ejecutado, ni una sola vez.

## Cómo compilar y ejecutar

```bash
javac src/App.java -d out
java -cp out App
```
