# Java Learning Path

<div align="justify">

Repositorio de aprendizaje personal de Java, organizado como una serie de mini-proyectos independientes agrupados en módulos progresivos — desde `"Hello, World!"` hasta Streams, `Optional` y la API de fechas de Java 8.

</div>

## Para quién es este repositorio

<div align="justify">

Está pensado para alguien que aprende Java **desde cero**, incluso si nunca programó antes en ningún lenguaje. No se asume ningún conocimiento previo: cada proyecto explica el **por qué** detrás de cada concepto, no solo el **cómo** — porque memorizar sintaxis sin entender el motivo detrás no sirve de mucho a la larga.

</div>

## Cómo está organizado

- Cada **módulo** es una carpeta numerada (`01-fundamentos`, `02-poo`, `03-api-basica`, ...).
- Dentro de cada módulo hay uno o más **mini-proyectos**, también numerados (`01-hola-mundo`, `02-variables-tipos`, ...).
- Cada mini-proyecto es un **proyecto de Java independiente y autocontenido**: tiene su propio `src/`, se abre como carpeta raíz en VS Code (así la extensión de Java lo reconoce bien, sin advertencias de "non-project file"), y se compila/ejecuta por separado del resto.
- Cada proyecto tiene su propio `README.md` explicando qué se aprende ahí, con preguntas para pensar antes de mirar el código.

## Índice de módulos

| Módulo | Tema | Proyectos |
|---|---|---|
| [01-fundamentos](01-fundamentos/README.md) | Fundamentos del lenguaje: variables, tipos, operadores, control de flujo, métodos | 5 |
| [02-poo](02-poo/README.md) | Programación Orientada a Objetos: clases, encapsulación, herencia, polimorfismo | 4 |
| [03-api-basica](03-api-basica/README.md) | API básica de Java: cadenas, arrays, manejo de excepciones | 2 |
| [04-colecciones-genericos](04-colecciones-genericos/README.md) | Colecciones (`List`, `Set`, `Map`) y genéricos (`<T>`) | 4 |
| [05-java8](05-java8/README.md) | Java 8: lambdas, referencias a métodos, Streams, `Optional` | 3 |
| [06-complementarios](06-complementarios/README.md) | Temas complementarios: fechas, formateo y localización | 2 |

## Cómo compilar y ejecutar un proyecto

<div align="justify">

Todos los proyectos se compilan y ejecutan de la misma forma, parado en la terminal dentro de la carpeta del proyecto (no en la raíz del repositorio):

</div>

```bash
javac src/*.java -d out
java -cp out App
```

## Dinámica de aprendizaje

<div align="justify">

Cada proyecto sigue el mismo patrón:

</div>

1. **Antes de escribir código**, hay 1-2 preguntas conceptuales para pensar por cuenta propia (sección "Preguntas para pensar" de cada README). Intenta responderlas con tus propias palabras — está bien equivocarse, ahí está el aprendizaje real, no en la respuesta perfecta a la primera.
2. **Después**, la explicación detallada del concepto, construida desde cero, sin asumir que ya lo sabes.
3. **Al final**, cómo compilar/ejecutar y, cuando aplica, errores comunes que aparecieron al construir el ejemplo — para que los reconozcas si te topas con ellos.

<div align="justify">

La mayoría de los proyectos reutilizan el mismo dominio de **cuenta bancaria** (`Cuenta`, `CuentaAhorro`, `CuentaCorriente`) para mantener continuidad entre conceptos — así puedes comparar cómo el mismo dominio se ve afectado por cada tema nuevo. El módulo 5 (Java 8) introduce dominios distintos (`Pelicula`, `Cancion`, `Ciudad`) deliberadamente, para practicar con contextos nuevos en vez de repetir siempre lo mismo.

</div>

## Requisitos

- JDK instalado (versión 17 o superior recomendada, para soporte completo de todas las características usadas: `var`, pattern matching de `instanceof`, etc.)
- VS Code con la extensión de Java (opcional, pero los proyectos ya vienen con `.vscode/settings.json` configurado para eso)
