# 03 - Herencia

<div align="justify">

[← Módulo 2: POO](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- `extends`: qué gana realmente una subclase, y qué NO hereda (los constructores).
- La diferencia de acceso entre `private` y `protected` desde una subclase.
- Diseñar un método `protected` como mecanismo de mutación compartido, separado de la regla de negocio.
- Un gotcha real de `BigDecimal.multiply()` con la escala de decimales.

## Antes de escribir código: preguntas para pensar

1. En `class CuentaAhorro extends Cuenta`, ¿para qué sirve `extends`? ¿Qué gana `CuentaAhorro` al usarlo? En particular: ¿el constructor de `Cuenta` se hereda automáticamente, o hay que hacer algo explícito para usarlo desde `CuentaAhorro`?
2. Si `Cuenta` tiene un atributo `private BigDecimal saldoDisponible;`, ¿ese campo **existe** dentro de un objeto `CuentaAhorro`? Y si existe, ¿por qué `CuentaAhorro` no puede escribir `this.saldoDisponible` directamente en su propio código?

## Conceptos, paso a paso

<div align="justify">

**`extends` establece una relación "es un"**: `CuentaAhorro extends Cuenta` significa que toda `CuentaAhorro` **es una** `Cuenta`, y hereda todos los métodos y campos **no-private** de `Cuenta` (públicos y `protected`).

</div>

<div align="justify">

**Lo que NO se hereda: los constructores.** `CuentaAhorro` necesita su propio constructor, y dentro de él invoca al de `Cuenta` explícitamente con `super(...)`:

</div>

```java
public CuentaAhorro(String nombreTitular, String numeroCuenta, BigDecimal saldoDisponible, BigDecimal tasaInteres) {
    super(nombreTitular, numeroCuenta, saldoDisponible);  // construye la parte "Cuenta"
    // ... validar y asignar tasaInteres, lo que es exclusivo de CuentaAhorro
}
```

<div align="justify">

**Sobre la Pregunta 2 — el campo `private` de la superclase SÍ existe dentro del objeto, pero no es accesible por nombre.** Piensa en un cajón cerrado con llave: ese cajón viaja dentro de cada `CuentaAhorro` que se crea (porque una `CuentaAhorro` es, por dentro, una `Cuenta` completa), pero `CuentaAhorro` no tiene la llave para abrirlo escribiendo `this.saldoDisponible` directamente. Solo puede interactuar con ese dato de dos formas: (1) al construirse, pasándole el valor a `super(...)` para que `Cuenta` lo guarde; (2) después, a través de métodos públicos o `protected` que `Cuenta` decida exponer.

</div>

<div align="justify">

**El diseño de este proyecto: separar el mecanismo de mutación de la regla de negocio.** `Cuenta` expone un método `protected`:

</div>

```java
protected void ajustarSaldo(BigDecimal delta) {
    saldoDisponible = saldoDisponible.add(delta);
}
```

<div align="justify">

Este método es deliberadamente "tonto" — no valida nada, solo suma un `delta` (positivo o negativo) al saldo. La validación (¿cuánto se puede retirar? ¿hay sobregiro permitido?) vive en cada `retirar()`, que sí puede ser distinto por subclase. `CuentaCorriente` sobrescribe `retirar()` para permitir sobregiro hasta un límite, y usa `ajustarSaldo(monto.negate())` — `negate()` invierte el signo de un `BigDecimal` (`500` → `-500`, sin modificar el original, porque `BigDecimal` es inmutable) para convertir "quiero retirar 500" en "ajusta el saldo en -500".

</div>

<div align="justify">

**Gotcha real encontrado en este proyecto: `BigDecimal.multiply()` no se comporta como `add()`/`subtract()`.** `CuentaAhorro.aplicarInteres()` calcula `saldoDisponible.multiply(tasaInteres)` — pero la **escala** (cantidad de decimales) del resultado de `multiply()` es la **suma** de las escalas de ambos operandos, no el máximo (que es como funcionan `add`/`subtract`). `1200.00 (escala 2) × 0.05 (escala 2)` da `60.0000` (escala 4), no `60.00`. El fix es normalizar explícitamente con `.setScale(2, RoundingMode.HALF_UP)` después de multiplicar — algo a tener siempre presente al hacer cálculos financieros con `BigDecimal`.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
