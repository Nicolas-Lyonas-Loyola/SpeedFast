package cl.duoc.speedfast.model;

import cl.duoc.speedfast.interfaces.Cancelable;
import cl.duoc.speedfast.interfaces.Despachable;
import cl.duoc.speedfast.interfaces.Rastreable;

public class PedidoExpress extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoExpress(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor prioritario para pedido express.");
    }

    @Override
    public int calcularTiempoEntrega() {
        int tiempoBase = 10;

        if (getDistanciaKm() > 5) {
            tiempoBase += 5;
        }

        return tiempoBase;
    }

    @Override
    public void despachar() {
        System.out.println("Pedido express despachado correctamente.");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido express cancelado.");
    }

    @Override
    public void verHistorial() {
        System.out.println("- PedidoExpress #" + getIdPedido() + " - entrega registrada.");
    }
}