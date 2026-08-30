package cl.duoc.speedfast.main;

import cl.duoc.speedfast.model.Pedido;
import cl.duoc.speedfast.model.PedidoComida;
import cl.duoc.speedfast.model.PedidoEncomienda;
import cl.duoc.speedfast.model.PedidoExpress;
import cl.duoc.speedfast.service.ControladorDeEnvios;

public class Main {

    public static void main(String[] args) {

        PedidoComida pedidoComida =
                new PedidoComida(101, "Av. Alameda 123", 4);

        PedidoEncomienda pedidoEncomienda =
                new PedidoEncomienda(102, "Av. Santa Rosa 567", 6);

        PedidoExpress pedidoExpress =
                new PedidoExpress(103, "Av. Providencia 890", 7);

        Pedido[] pedidos = {
                pedidoComida,
                pedidoEncomienda,
                pedidoExpress
        };

        ControladorDeEnvios controlador = new ControladorDeEnvios();


        System.out.println("=== SPEEDFAST ===");

        for (Pedido pedido : pedidos) {
            System.out.println("\n------------------------------");

            pedido.mostrarResumen();

            System.out.println("\nAsignación automática:");
            pedido.asignarRepartidor();

            System.out.println("Tiempo estimado: "
                    + pedido.calcularTiempoEntrega()
                    + " minutos");
        }

        System.out.println("=== RESERVAS ===");

        pedidoComida.reservar();
        pedidoEncomienda.reservar();
        pedidoExpress.reservar();

        System.out.println("\n=== ASIGNACIÓN MANUAL ===");

        pedidoComida.asignarRepartidor("Luis Díaz");
        pedidoEncomienda.asignarRepartidor("Daniela Tapia");
        pedidoExpress.asignarRepartidor("Carlos Soto");

        System.out.println("\n=== DESPACHOS ===");

        controlador.despacharPedido(
                pedidoComida,
                pedidoComida
        );

        controlador.despacharPedido(
                pedidoEncomienda,
                pedidoEncomienda
        );

        System.out.println("\n=== CANCELACIÓN ===");

        controlador.cancelarPedido(pedidoExpress);

        System.out.println("\n=== RASTREO ===");

        controlador.revisarHistorial(pedidoComida);
        controlador.revisarHistorial(pedidoEncomienda);

        controlador.mostrarHistorialEntregas();
    }
}