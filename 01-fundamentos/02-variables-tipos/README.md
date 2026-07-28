# 02 - Variables y Tipos

<div align="justify">

[← Módulo 1: Fundamentos](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Qué es una variable y cómo se declara en Java.
- Los 8 tipos primitivos de Java y para qué sirve cada uno.
- Qué pasa cuando intentas guardar un valor que no cabe en el tipo que elegiste.

## Antes de escribir código: preguntas para pensar

1. Java es un lenguaje de **tipado estático** — cada variable declara desde el principio qué tipo de dato va a guardar, y eso no cambia después. ¿Qué ventaja crees que tiene esto frente a un lenguaje donde una variable puede cambiar de tipo libremente? ¿Qué desventaja?
2. Un `byte` en Java solo puede guardar números entre -128 y 127. ¿Qué crees que pasaría si intentas guardar `200` en un `byte`? ¿Un error al compilar, un error al ejecutar, o el programa sigue corriendo con un valor "raro"?

## Conceptos, paso a paso

<div align="justify">

**Una variable es un espacio con nombre para guardar un valor**, y en Java, ese espacio tiene un tipo fijo desde que lo declaras:

</div>

```java
int edad = 30;
```

<div align="justify">

Aquí `int` es el tipo (números enteros), `edad` es el nombre que le das a ese espacio, y `30` es el valor inicial. Una vez declarada como `int`, esa variable **solo** puede contener enteros, nunca texto ni decimales.

</div>

<div align="justify">

**Los tipos primitivos de Java** (los "básicos", integrados al lenguaje, no clases) son:

</div>

| Tipo | Guarda | Ejemplo |
|---|---|---|
| `byte` | enteros pequeños (-128 a 127) | `byte numero = 100;` |
| `short` | enteros medianos | `short cantidad = 2000;` |
| `int` | enteros normales (el más usado) | `int edad = 30;` |
| `long` | enteros grandes | `long distancia = 100000L;` |
| `float` | decimales, menos precisión | `float peso = 70.5f;` |
| `double` | decimales, más precisión (el más usado) | `double altura = 1.75;` |
| `char` | un solo carácter | `char letra = 'A';` |
| `boolean` | verdadero o falso | `boolean esEstudiante = true;` |

<div align="justify">

Fíjate en dos detalles de sintaxis que no son opcionales: `100000L` lleva una `L` al final porque, sin ella, Java asume que es un `int` (y algunos números grandes no caben en `int`); `70.5f` lleva una `f` porque, sin ella, Java asume que es un `double`, y no puedes asignar un `double` directamente a una variable `float` sin decírselo explícitamente.

</div>

<div align="justify">

**Por qué existen tantos tipos numéricos distintos, en vez de uno solo:** cada tipo ocupa una cantidad distinta de memoria (`byte` ocupa 1 byte, `int` ocupa 4, `long` ocupa 8). Elegir el tipo más chico que te alcance es una forma de no desperdiciar memoria — importante cuando tienes millones de valores guardados, aunque para programas chicos como estos casi no se nota.

</div>

<div align="justify">

**Qué pasa si te pasas del rango — el overflow:** si intentas convertir un `int` grande (como `130`) a un `byte` (que solo llega hasta `127`) sin decírselo explícitamente a Java, **no compila** — el compilador te obliga a hacer un *casting* explícito:

</div>

```java
int numeroGrande = 130;
byte b1 = (byte) numeroGrande;  // esto sí compila...
```

<div align="justify">

Pero aquí viene lo importante: aunque compile, el resultado **no es 130** — es un desbordamiento (*overflow*). El valor "da la vuelta" y termina siendo un número negativo raro (`-126` en este caso), porque `byte` no tiene espacio para representar `130`. Este es un error silencioso — el programa corre sin quejarse, pero el valor guardado es incorrecto. Por eso elegir el tipo correcto para el rango de valores que esperas es importante, no solo un detalle de estilo.

</div>

## Cómo compilar y ejecutar

```bash
javac src/App.java -d out
java -cp out App
```
