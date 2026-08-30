package cl.duoc.speedfast.model;

import cl.duoc.speedfast.interfaces.Cancelable;
import cl.duoc.speedfast.interfaces.Despachable;
import cl.duoc.speedfast.interfaces.Rastreable;

public class PedidoComida extends Pedido
        implements Despachable, Cancelable, Rastreable {

    public PedidoComida(int idPedido, String direccionEntrega, double distanciaKm) {
        super(idPedido, direccionEntrega, distanciaKm);
    }

    @Override
    public void asignarRepartidor() {
        System.out.println("Verificando mochila térmica para asignar repartidor de comida.");
    }

    @Override
    public int calcularTiempoEntrega() {
        return (int) (15 + (2 * getDistanciaKm()));
    }

    @Override
    public void despachar() {
        System.out.println("Pedido de comida despachado correctamente.");
    }

    @Override
    public void cancelar() {
        System.out.println("Pedido de comida cancelado.");
    }

    @Override
    public void verHistorial() {
        System.out.println("- PedidoComida #" + getIdPedido() + " - entrega registrada.");
    }
}