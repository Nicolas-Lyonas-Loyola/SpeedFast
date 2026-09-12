package cl.duoc.speedfast.semana5.concurrente;

import cl.duoc.speedfast.semana5.model.EstadoPedido;
import cl.duoc.speedfast.semana5.model.Pedido;
import cl.duoc.speedfast.semana5.service.ZonaDeCarga;

import java.util.concurrent.ThreadLocalRandom;

public class Repartidor implements Runnable {

    private final String nombre;
    private final ZonaDeCarga zonaDeCarga;

    public Repartidor(String nombre, ZonaDeCarga zonaDeCarga) {
        this.nombre = nombre;
        this.zonaDeCarga = zonaDeCarga;
    }

    @Override
    public void run() {

        while (!Thread.currentThread().isInterrupted()) {

            Pedido pedido = zonaDeCarga.retirarPedido();

            if (pedido == null) {
                break;
            }

            pedido.setEstado(EstadoPedido.EN_REPARTO);

            String hilo = Thread.currentThread().getName();

            System.out.println(
                    "[" + hilo + " | " + nombre + "] "
                            + "retira Pedido #" + pedido.getId()
                            + " -> " + pedido.getEstado()
            );

            try {
                long tiempoSimulado =
                        ThreadLocalRandom.current().nextLong(500, 1501);

                Thread.sleep(tiempoSimulado);

            } catch (InterruptedException e) {

                Thread.currentThread().interrupt();

                System.out.println(
                        "[" + hilo + " | " + nombre + "] "
                                + "interrumpido durante la entrega del Pedido #"
                                + pedido.getId()
                );

                return;
            }

            pedido.setEstado(EstadoPedido.ENTREGADO);

            System.out.println(
                    "[" + hilo + " | " + nombre + "] "
                            + "Pedido #" + pedido.getId()
                            + " -> " + pedido.getEstado()
            );
        }

        System.out.println(
                "[" + Thread.currentThread().getName()
                        + " | " + nombre + "] "
                        + "finaliza su jornada."
        );
    }
}