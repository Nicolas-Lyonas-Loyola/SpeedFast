package cl.duoc.speedfast.service;

import cl.duoc.speedfast.interfaces.Cancelable;
import cl.duoc.speedfast.interfaces.Despachable;
import cl.duoc.speedfast.interfaces.Rastreable;

import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios {

    private final List<Rastreable> historialEntregas;

    public ControladorDeEnvios() {
        historialEntregas = new ArrayList<>();
    }

    public void despacharPedido(Despachable despachable, Rastreable rastreable) {
        despachable.despachar();
        historialEntregas.add(rastreable);
    }

    public void cancelarPedido(Cancelable pedido) {
        pedido.cancelar();
    }

    public void revisarHistorial(Rastreable pedido) {
        pedido.verHistorial();
    }

    public void mostrarHistorialEntregas() {
        System.out.println("\n=== HISTORIAL DE ENTREGAS ===");

        if (historialEntregas.isEmpty()) {
            System.out.println("No existen entregas registradas.");
            return;
        }

        for (Rastreable pedido : historialEntregas) {
            pedido.verHistorial();
        }
    }
}