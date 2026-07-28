# 04 - Polimorfismo

<div align="justify">

[← Módulo 2: POO](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Dynamic dispatch: cómo decide Java, en tiempo de ejecución, qué versión de un método `@Override` correr.
- La diferencia entre el tipo **declarado** de una variable y el tipo **real** del objeto.
- `instanceof` (con *pattern variable*) para acceder a métodos exclusivos de una subclase de forma segura.
- La otra mitad del polimorfismo: overloading (tiempo de compilación) vs overriding (tiempo de ejecución).

## Antes de escribir código: preguntas para pensar

1. Si escribes `Cuenta cuenta = new CuentaCorriente(...);` y luego `cuenta.retirar(...)`, la variable está declarada como `Cuenta`, pero el objeto real es un `CuentaCorriente` (que sobrescribe `retirar()` con lógica de sobregiro, distinta a la de `Cuenta`). ¿Qué versión de `retirar()` se ejecuta — la de `Cuenta` o la de `CuentaCorriente`? ¿Por qué?
2. Con esa misma variable `cuenta` (declarada como `Cuenta`), ¿podrías escribir `cuenta.aplicarInteres()` — un método que solo existe en `CuentaAhorro` — sabiendo que el objeto real detrás podría ser una `CuentaAhorro`? ¿Compilaría?

## Conceptos, paso a paso

<div align="justify">

**Dynamic dispatch (enlace dinámico):** para métodos sobrescritos con `@Override`, Java decide **en tiempo de ejecución** qué versión correr, mirando el **tipo real del objeto** (el que se creó con `new`) — sin importar cómo esté declarada la variable que lo referencia. Por eso, en la Pregunta 1, se ejecuta el `retirar()` de `CuentaCorriente` (con sobregiro), no el de `Cuenta`, aunque la variable diga `Cuenta`.

</div>

<div align="justify">

**La otra mitad de la respuesta — por qué `aplicarInteres()` NO compila sobre una variable `Cuenta`:** el tipo **declarado** de la variable determina qué métodos tienes **permitido llamar** — eso lo decide el compilador, mirando solo la clase `Cuenta` y lo que hereda. El tipo real del objeto solo entra en juego **después**, para decidir qué implementación ejecutar, pero únicamente de métodos que el compilador ya aprobó que existen. Como `aplicarInteres()` no está declarado en `Cuenta`, el compilador rechaza la llamada — es un error de compilación, no de ejecución.

</div>

<div align="justify">

**Cómo acceder igual a `aplicarInteres()` — `instanceof` con *pattern variable*:**

</div>

```java
if (cuenta instanceof CuentaAhorro cuentaAhorro) {
    cuentaAhorro.aplicarInteres();
}
```

<div align="justify">

Esto primero verifica en tiempo de ejecución si el objeto realmente es del tipo `CuentaAhorro`, y si es así, te da una referencia ya casteada (`cuentaAhorro`) — evitando el riesgo de un `ClassCastException` por asumir un tipo incorrecto. Es la forma moderna (Java 16+) de lo que antes se escribía en dos pasos: `if (cuenta instanceof CuentaAhorro) { ((CuentaAhorro) cuenta).aplicarInteres(); }` — ambas formas son válidas, pero vas a ver la clásica en código legado.

</div>

<div align="justify">

**La otra cara de la moneda: overloading (sobrecarga) vs overriding (sobrescritura).** Son las dos formas de polimorfismo en Java, y se resuelven en momentos completamente distintos:

</div>

| | Overloading | Overriding (`@Override`) |
|---|---|---|
| ¿Cuándo se decide? | En **compilación**, según los argumentos de la llamada | En **ejecución**, según el tipo real del objeto |
| ¿Quién decide? | El compilador | La JVM |
| Ejemplo | `depositar(monto)` vs `depositar(monto, concepto)` — mismo nombre, distinta firma, en la **misma** clase | `retirar()` en `Cuenta` vs `CuentaCorriente` — misma firma, en clases **distintas** |

<div align="justify">

`@Override` **nunca** se usa en overloading — solo tiene sentido cuando de verdad sustituyes un método heredado con firma idéntica. Si accidentalmente cambias la firma creyendo que sobrescribes, sin `@Override` Java lo acepta silenciosamente como un método nuevo (un overload no intencional) — con `@Override` puesto, el compilador te avisa inmediatamente si no hay coincidencia real con la superclase.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
