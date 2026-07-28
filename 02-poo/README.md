# Módulo 2: Programación Orientada a Objetos (POO)

<div align="justify">

[← Volver al índice general](../README.md)

</div>

## Objetivo del módulo

<div align="justify">

Pasar de escribir instrucciones sueltas dentro de `main` a modelar el mundo con **objetos**: cosas que tienen datos propios (atributos) y comportamiento propio (métodos). Los cuatro proyectos de este módulo construyen, paso a paso, el mismo dominio — un sistema bancario simple — agregando en cada uno un pilar nuevo de la Programación Orientada a Objetos.

</div>

## Proyectos

| # | Proyecto | Qué cubre |
|---|---|---|
| 01 | [objetos-clases](01-objetos-clases/README.md) | Qué es una clase, qué es un objeto, y la diferencia entre ambos |
| 02 | [encapsulacion](02-encapsulacion/README.md) | Campos `private`, validación en el constructor, getters — proteger el estado interno |
| 03 | [herencia](03-herencia/README.md) | `extends`, `super()`, `protected` vs `private`, reutilizar comportamiento entre clases relacionadas |
| 04 | [polimorfismo](04-polimorfismo/README.md) | Dynamic dispatch (`@Override` en tiempo de ejecución), `instanceof`, overloading vs overriding |

## El dominio compartido

<div align="justify">

A partir de `02-encapsulacion`, todos los proyectos giran alrededor de la misma clase `CuentaBancaria`/`Cuenta` (una cuenta de banco con titular, número de cuenta y saldo), que en `03-herencia` se convierte en una jerarquía (`Cuenta` → `CuentaAhorro`, `CuentaCorriente`). Esta continuidad es intencional: te deja ver cómo el **mismo código** se transforma cuando se le agrega un concepto nuevo, en vez de aprender cada pilar con un ejemplo desconectado del anterior.

</div>

## Orden recomendado

<div align="justify">

Estrictamente en orden — `herencia` no tiene sentido sin haber entendido `encapsulacion` primero (¿por qué un campo `private` no es accesible desde una subclase?), y `polimorfismo` construye directamente sobre las clases que `herencia` deja armadas.

</div>
