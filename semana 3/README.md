# SpeedFast

Proyecto correspondiente a la Sumativa 1 de la asignatura **PRY2203 - Desarrollo Orientado a Objetos II**.

El sistema simula la gestión de distintos tipos de pedidos de la empresa ficticia SpeedFast, aplicando principios avanzados de Programación Orientada a Objetos como herencia, polimorfismo, abstracción, interfaces y desacoplamiento.

## Tecnologías utilizadas

- Java 21 LTS
- IntelliJ IDEA Community
- Git
- GitHub
- PlantUML

## Estructura del proyecto

El sistema se organiza en los siguientes paquetes:

- `model`: contiene la clase abstracta `Pedido` y sus subclases.
- `interfaces`: contiene los contratos funcionales del sistema.
- `service`: contiene `ControladorDeEnvios`, encargado de coordinar operaciones mediante interfaces.
- `main`: contiene la clase `Main`, utilizada para ejecutar y demostrar el funcionamiento del sistema.

## Jerarquía de pedidos

La clase abstracta `Pedido` concentra los atributos y comportamientos comunes del sistema.

De ella heredan:

- `PedidoComida`
- `PedidoEncomienda`
- `PedidoExpress`

Cada subclase implementa su propia lógica para:

- asignar automáticamente un repartidor;
- calcular el tiempo estimado de entrega.

Además, el sistema utiliza sobrecarga mediante distintas versiones del método `asignarRepartidor()`.

## Interfaces

El proyecto implementa tres interfaces funcionales:

### Despachable

`void despachar();`

Representa la capacidad de despachar un pedido.

### Cancelable

`void cancelar();`

Representa la capacidad de cancelar un pedido.

### Rastreable

`void verHistorial();`

Permite consultar información asociada al historial del pedido.

Las clases concretas implementan estos contratos y `ControladorDeEnvios` los utiliza como tipos de referencia para reducir la dependencia de clases específicas.

## Reutilización

La clase abstracta `Pedido` concentra atributos y comportamientos comunes, como:

- `idPedido`
- `direccionEntrega`
- `distanciaKm`
- `mostrarResumen()`
- `reservar()`
- las distintas versiones de `asignarRepartidor()`

Esto evita duplicar código en las subclases y permite que cada tipo de pedido se concentre en su comportamiento particular.

## Desacoplamiento

Las interfaces `Despachable`, `Cancelable` y `Rastreable` separan capacidades funcionales de las clases concretas.

`ControladorDeEnvios` trabaja con estos contratos en lugar de depender directamente de `PedidoComida`, `PedidoEncomienda` o `PedidoExpress`.

De esta forma, el controlador conoce únicamente las capacidades que necesita para realizar cada operación.

## Escalabilidad

La estructura permite incorporar nuevos tipos de pedido sin modificar de manera significativa las clases existentes.

Por ejemplo, una nueva clase podría extender `Pedido` e implementar solamente las interfaces que correspondan a sus responsabilidades.

Esto permite ampliar el sistema manteniendo una estructura organizada.

## Mantenibilidad

Las responsabilidades se encuentran separadas entre distintos componentes:

- Las clases de `model` representan los pedidos y sus reglas.
- Las interfaces definen capacidades.
- `ControladorDeEnvios` coordina operaciones.
- `Main` crea objetos, conecta los componentes y demuestra el funcionamiento.

Esta separación facilita localizar y modificar funcionalidades sin afectar innecesariamente otras partes del sistema.

## Funcionalidades demostradas

La ejecución desde `Main` permite visualizar:

- creación de tres tipos distintos de pedido;
- asignación automática de repartidores;
- asignación manual de repartidores;
- sobrecarga de métodos;
- cálculo del tiempo estimado de entrega;
- reserva de pedidos;
- despacho de pedidos;
- cancelación;
- rastreo;
- historial de entregas.

## Diagramas UML

La carpeta `docs` contiene los diagramas PlantUML del proyecto:

- `SpeedFast.puml`
- `SpeedFast_Herencia.puml`
- `SpeedFast_Interfaces.puml`

Los diagramas representan la jerarquía de clases, la abstracción, las relaciones de herencia, las interfaces y el desacoplamiento utilizado por el controlador.

## Autor

**Nicolás Alberto Loyola Guevara**

Asignatura: **PRY2203 - Desarrollo Orientado a Objetos II**