package cl.duoc.speedfast.semana5.service;

import cl.duoc.speedfast.semana5.model.Pedido;

import java.util.ArrayList;
import java.util.List;

public class ZonaDeCarga {

    private final List<Pedido> pedidos;

    public ZonaDeCarga() {
        this.pedidos = new ArrayList<>();
    }

    public synchronized void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public synchronized Pedido retirarPedido() {
        if (pedidos.isEmpty()) {
            return null;
        }

        return pedidos.remove(0);
    }

    public synchronized int cantidadPedidosPendientes() {
        return pedidos.size();
    }
}