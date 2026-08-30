package cl.duoc.speedfast.model;

import cl.duoc.speedfast.interfaces.Cancelable;
import cl.duoc.speedfast.interfaces.Despachable;
import cl.duoc.speedfast.interfaces.Rastreable;

public class PedidoEncomienda extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoEncomienda(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Asignando repartidor con capacidad para transportar encomiendas.");
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (20 + (1.5 * getDistanciaKm()));
    }

    @Override
    public void despachar() {
        System.out.println("Pedido de encomienda despachado correctamente.");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido de encomienda cancelado.");
    }

    @Override
    public void verHistorial() {
        System.out.println("- PedidoEncomienda #" + getIdPedido() + " - entrega registrada.");
    }
}