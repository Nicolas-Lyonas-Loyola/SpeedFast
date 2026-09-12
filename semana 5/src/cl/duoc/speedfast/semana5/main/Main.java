package cl.duoc.speedfast.semana5.main;

import cl.duoc.speedfast.semana5.concurrente.Repartidor;
import cl.duoc.speedfast.semana5.model.EstadoPedido;
import cl.duoc.speedfast.semana5.model.Pedido;
import cl.duoc.speedfast.semana5.service.ZonaDeCarga;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== SPEEDFAST - SUMATIVA 2 ===");

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();

        List<Pedido> pedidos = List.of(
                new Pedido(
                        101,
                        "Av. Alameda 123",
                        EstadoPedido.PENDIENTE
                ),
                new Pedido(
                        102,
                        "Av. Santa Rosa 567",
                        EstadoPedido.PENDIENTE
                ),
                new Pedido(
                        103,
                        "Av. Providencia 890",
                        EstadoPedido.PENDIENTE
                ),
                new Pedido(
                        104,
                        "Av. Matta 456",
                        EstadoPedido.PENDIENTE
                ),
                new Pedido(
                        105,
                        "Av. Grecia 321",
                        EstadoPedido.PENDIENTE
                )
        );

        for (Pedido pedido : pedidos) {
            zonaDeCarga.agregarPedido(pedido);
        }

        System.out.println(
                "Pedidos cargados: "
                        + zonaDeCarga.cantidadPedidosPendientes()
        );

        Repartidor camila =
                new Repartidor("Camila", zonaDeCarga);

        Repartidor luis =
                new Repartidor("Luis", zonaDeCarga);

        Repartidor pedro =
                new Repartidor("Pedro", zonaDeCarga);

        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        executor.execute(camila);
        executor.execute(luis);
        executor.execute(pedro);

        executor.shutdown();

        try {

            boolean termino =
                    executor.awaitTermination(
                            30,
                            TimeUnit.SECONDS
                    );

            if (!termino) {
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {

            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }

        long pedidosEntregados = pedidos.stream()
                .filter(pedido ->
                        pedido.getEstado() == EstadoPedido.ENTREGADO
                )
                .count();

        System.out.println("\n=== VERIFICACIÓN FINAL ===");

        System.out.println(
                "Pedidos entregados: "
                        + pedidosEntregados
                        + " de "
                        + pedidos.size()
        );

        boolean todosEntregados =
                pedidosEntregados == pedidos.size();

        if (todosEntregados) {

            System.out.println(
                    "Todos los pedidos han sido entregados correctamente."
            );

        } else {

            System.out.println(
                    "La simulación finalizó con pedidos sin entregar."
            );
        }
    }
}

