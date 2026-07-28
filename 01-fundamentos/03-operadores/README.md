# 03 - Operadores

<div align="justify">

[← Módulo 1: Fundamentos](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Operadores aritméticos (`+`, `-`, `*`, `/`, `%`).
- Operadores lógicos (`&&`, `||`, `!`).
- El operador ternario, como forma corta de un `if`/`else`.

## Antes de escribir código: preguntas para pensar

1. En matemáticas normales, `10 / 20` da `0.5`. En Java, si `a` y `b` son ambos de tipo `int`, ¿qué crees que da `a / b`? ¿Por qué crees que pasa eso?
2. El operador `%` (módulo) da el **resto** de una división, no el resultado. ¿Para qué crees que sirve esto en un programa real — en qué situación necesitarías saber el resto de una división en vez del cociente?

## Conceptos, paso a paso

<div align="justify">

**Operadores aritméticos** — hacen lo que esperas de la escuela, con una excepción importante:

</div>

```java
int a = 10, b = 20;
a + b;  // 30
a - b;  // -10
a * b;  // 200
a / b;  // 0   <- ¡no 0.5!
a % b;  // 10  (el resto de dividir 10 entre 20)
```

<div align="justify">

**La división entera es la trampa más común para quien recién empieza.** Cuando divides dos `int`, Java hace **división entera**: descarta cualquier parte decimal, no redondea. `10 / 20` da `0`, no `0.5`, porque el resultado de dividir dos enteros es, por definición del tipo, otro entero. Para obtener `0.5` necesitarías que al menos uno de los dos operandos fuera `double` (por ejemplo, `10.0 / 20`).

</div>

<div align="justify">

**El operador `%` (módulo)** te da el resto de la división, no el cociente. Es extremadamente útil para preguntas del tipo "¿es este número par o impar?" (`numero % 2 == 0`), o "¿cada cuántas posiciones repito algo?" — lo vas a usar mucho más adelante en el curso.

</div>

<div align="justify">

**Operadores lógicos** — trabajan con `boolean`, no con números:

</div>

```java
boolean verdadero = true, falso = false;
verdadero && falso;  // false (Y lógico: ambos deben ser true)
verdadero || falso;  // true  (O lógico: al menos uno debe ser true)
!verdadero;          // false (negación: invierte el valor)
```

<div align="justify">

**El operador ternario** es una forma corta de escribir un `if`/`else` que **devuelve un valor**, en vez de solo ejecutar bloques de código:

</div>

```java
String resultado = (a > b) ? "a es mayor que b" : "a es menor o igual que b";
```

<div align="justify">

Se lee: *"si `a > b` es verdadero, el valor completo es el texto de la izquierda del `:`; si es falso, es el de la derecha."* Es útil cuando la decisión es simple y quieres asignar directamente un valor, en vez de escribir un bloque `if`/`else` completo de varias líneas solo para eso.

</div>

## Cómo compilar y ejecutar

```bash
javac src/App.java -d out
java -cp out App
```
