# SpeedFast - Sumativa 2

## PRY2203 - Desarrollo Orientado a Objetos II

Proyecto desarrollado para la Sumativa 2 de la Semana 5, orientada al uso de programación concurrente en Java mediante múltiples tareas, sincronización de recursos compartidos y control consistente del estado de los pedidos.

## Objetivo

Simular el trabajo concurrente de varios repartidores de SpeedFast utilizando una única zona de carga compartida.

El sistema debe asegurar que:

- varios repartidores puedan trabajar concurrentemente;
- cada pedido sea retirado por un solo repartidor;
- no existan retiros duplicados;
- los pedidos mantengan un estado coherente durante su procesamiento;
- la aplicación espere la finalización real de las tareas antes de informar el resultado final.

## Tecnologías utilizadas

- Java JDK 21 LTS
- IntelliJ IDEA Community
- Git
- GitHub
- API `java.util.concurrent`

## Estructura del proyecto

```text
semana 5
└── src
    └── cl.duoc.speedfast.semana5
        ├── concurrente
        │   └── Repartidor.java
        ├── main
        │   └── Main.java
        ├── model
        │   ├── EstadoPedido.java
        │   └── Pedido.java
        └── service
            └── ZonaDeCarga.java