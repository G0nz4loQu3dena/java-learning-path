# 05 - Métodos

<div align="justify">

[← Módulo 1: Fundamentos](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Cómo definir tus propios métodos, más allá de `main`.
- Parámetros y valores de retorno.
- Qué es la sobrecarga de métodos (*overloading*) — verla en su forma más simple, antes del módulo 5 donde vas a profundizar en ella.

## Antes de escribir código: preguntas para pensar

1. Este archivo tiene **dos** métodos llamados `suma` — mismo nombre, distinta cantidad de parámetros. ¿Por qué crees que Java permite esto sin confundirse sobre cuál llamar?
2. Si un método está declarado como `public static int suma(...)`, ¿qué crees que pasaría si escribieras `return "hola";` dentro de él, en vez de devolver un número?

## Conceptos, paso a paso

<div align="justify">

**Un método es un bloque de código con nombre, que puedes ejecutar ("llamar") las veces que quieras**, en vez de copiar y pegar el mismo código una y otra vez:

</div>

```java
public static int suma(int num1, int num2) {
    return num1 + num2;
}
```

- `int` (antes de `suma`) es el **tipo de retorno** — lo que este método promete devolver cuando termine.
- `suma` es el nombre.
- `(int num1, int num2)` son los **parámetros** — los datos de entrada que el método necesita para hacer su trabajo. `num1` y `num2` solo existen **dentro** de este método; no son visibles desde afuera.
- `return num1 + num2;` termina la ejecución del método y entrega el resultado a quien lo llamó.

<div align="justify">

**Cómo se usa** (dentro de `main`):

</div>

```java
int resultado = suma(5, 10);  // resultado vale 15
```

<div align="justify">

Aquí `5` y `10` son los **argumentos** — los valores concretos que le pasas al método en esta llamada específica (el parámetro es el nombre genérico en la definición; el argumento es el valor real que usas al llamarlo).

</div>

<div align="justify">

**El tipo de retorno es una promesa que el compilador hace cumplir.** Si el método dice `int`, tiene que devolver un `int` en cada camino posible de ejecución — intentar `return "hola";` dentro de un método declarado `int` **no compila**, con un error del tipo *"incompatible types"*. Esto es lo mismo que verás más adelante con métodos que devuelven `boolean`, `Optional`, o cualquier otro tipo: el compilador siempre exige que lo que devuelves coincida con lo que declaraste.

</div>

<div align="justify">

**Sobrecarga (*overloading*)**: puedes tener varios métodos con el **mismo nombre**, siempre que tengan una **firma distinta** (distinta cantidad de parámetros, o distinto tipo de parámetros):

</div>

```java
public static int suma(int num1, int num2) { return num1 + num2; }
public static int suma(int num1, int num2, int num3) { return num1 + num2 + num3; }
```

<div align="justify">

Cuando llamas `suma(5, 10)`, Java mira **cuántos argumentos le pasaste** y elige automáticamente la versión que coincide — esta decisión la toma el **compilador**, mirando tu código, no algo que se resuelve mientras el programa corre. (Vas a ver esta misma idea, pero mucho más a fondo — incluyendo por qué se le dice "polimorfismo en tiempo de compilación" — en el módulo 2, proyecto `04-polimorfismo`.)

</div>

## Cómo compilar y ejecutar

```bash
javac src/App.java -d out
java -cp out App
```
