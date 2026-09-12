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
                // Simula el tiempo de entrega.
                // No se utiliza como mecanismo de sincronización.
                Thread.sleep(tiempoSimulado);

            } catch (InterruptedException e) {

                // El pedido no debe quedar perdido en EN_REPARTO.
                // Se devuelve a la zona de carga para que pueda ser procesado nuevamente.
                pedido.setEstado(EstadoPedido.PENDIENTE);
                zonaDeCarga.agregarPedido(pedido);

                // Se restaura la señal de interrupción del hilo.
                Thread.currentThread().interrupt();

                System.out.println(
                        "[" + hilo + " | " + nombre + "] "
                                + "interrumpido durante la entrega del Pedido #"
                                + pedido.getId()
                                + ". Pedido devuelto a la zona de carga -> "
                                + pedido.getEstado()
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