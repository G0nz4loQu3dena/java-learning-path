# 02 - Encapsulación

<div align="justify">

[← Módulo 2: POO](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Qué significa `private` y por qué los atributos casi nunca deberían ser públicos.
- Validar datos dentro del constructor, para que sea imposible crear un objeto en un estado inválido.
- `final` en un atributo: qué garantiza y qué no.
- Sobrescribir `toString()` para controlar cómo se ve un objeto cuando lo imprimes.

## Antes de escribir código: preguntas para pensar

1. Compara este proyecto con `01-objetos-clases`: ahí, el constructor de `CuentaBancaria` guardaba lo que le pasaras, sin revisar nada. ¿Qué problema real podría causar eso? Piensa en qué pasaría si alguien crea una cuenta con `saldoDisponible` negativo, o con `nombreTitular` vacío.
2. Los atributos aquí son `private final String nombreTitular` (antes eran solo `private`). `final` significa que, una vez asignado en el constructor, ese campo **nunca más** puede cambiar. ¿Por qué crees que tiene sentido que el nombre del titular o el número de cuenta sean `final`, pero `saldoDisponible` **no** lo sea?

## Conceptos, paso a paso

<div align="justify">

**`private` significa que el atributo solo es accesible desde dentro de la propia clase** — nadie desde `App.java` puede escribir `cuenta1.saldoDisponible = -500;` directamente. Es como un cajón cerrado con llave: solo la clase `CuentaBancaria` tiene la llave para tocar ese campo directamente. Desde afuera, la única forma de leer el saldo es a través de un método público que la clase decide exponer (`getSaldoDisponible()`).

</div>

<div align="justify">

**Por qué esto importa — la validación en el constructor:**

</div>

```java
if (saldoDisponible == null || saldoDisponible.compareTo(BigDecimal.ZERO) < 0) {
    throw new IllegalArgumentException("El saldo disponible no puede ser nulo o negativo");
}
```

<div align="justify">

Si los atributos fueran públicos y modificables libremente, **cualquier parte del programa** podría dejar una `CuentaBancaria` en un estado que no debería existir (saldo negativo, nombre vacío). Al validar **dentro del constructor** y lanzar una excepción si algo no cumple, haces que sea **imposible** — no solo poco recomendable — crear un objeto inválido. Si el constructor termina sin lanzar excepción, tienes la garantía de que el objeto está bien formado. Esta garantía se pierde por completo si cualquiera puede modificar los campos después, sin control.

</div>

<div align="justify">

**`final` en un atributo — qué garantiza exactamente:** una vez que el constructor le asigna un valor, ese campo **no puede reasignarse nunca más**, ni siquiera dentro de la propia clase. Por eso `nombreTitular`, `numeroCuenta`, `numeroCuentaCci` y `fechaCreacion` son `final` — no tiene sentido que una cuenta bancaria "cambie" de titular o de número; son datos de identidad, fijos desde la creación. `saldoDisponible`, en cambio, **necesita** poder cambiar (`depositar`, `retirar` lo modifican), así que **no** lleva `final`.

</div>

<div align="justify">

**`@Override public String toString()`** — por defecto, si imprimes un objeto (`System.out.println(cuenta1)`), Java muestra algo como `CuentaBancaria@1b6d3586` (el nombre de la clase + una dirección de memoria en hexadecimal), que no te dice nada útil. Sobrescribir `toString()` te deja controlar exactamente qué texto se muestra:

</div>

```java
@Override
public String toString() {
    return "CuentaBancaria{" + "nombreTitular='" + nombreTitular + '\'' + ... + '}';
}
```

<div align="justify">

`println` llama a `toString()` automáticamente por dentro — no necesitas llamarlo tú mismo.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
