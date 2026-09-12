package cl.duoc.speedfast.semana5.model;

public class Pedido {

    private int id;
    private String direccionEntrega;
    private EstadoPedido estado;

    public Pedido(int id, String direccionEntrega, EstadoPedido estado) {
        this.id = id;
        this.direccionEntrega = direccionEntrega;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccionEntrega() {
        return direccionEntrega;
    }

    public void setDireccionEntrega(String direccionEntrega) {
        this.direccionEntrega = direccionEntrega;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
    }

    public void setEstado(String nuevoEstado) {
        this.estado = EstadoPedido.valueOf(
                nuevoEstado.trim().toUpperCase()
        );
    }

    @Override
    public String toString() {
        return "Pedido #" + id
                + " | Dirección: " + direccionEntrega
                + " | Estado: " + estado;
    }
}