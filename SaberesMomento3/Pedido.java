package SaberesMomento3;

public class Pedido {
    private Cliente cliente;
    private Producto producto;
    /*esta clase representa un pedido, 
    se relaciona mediante agregacion con clase cliente y producto*/

    private java.util.Date fecha;
    /* No estoy importando ninguna libreria entonces
    debo usar todo el nombre (java.util) si no lo uso
    me aparecia un error por compilacion */

    private int numeroTarjetaCredito;

    //constructor clase pedido
    public Pedido (Cliente cliente, Producto producto, java.util.Date fecha, int numeroTarjetaCredito) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = fecha;
        this.numeroTarjetaCredito = numeroTarjetaCredito;

        /*usar el this es importante en este caso ya que si no se hace
         * no lanzaria un error como tal pero los atributos que se pongan quedarian
         * sin un valor o sea (null)
         */
    }

    //getter y setters

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public java.util.Date getFecha() {
        return fecha;
    }

    public void setFecha(java.util.Date fecha) {
        this.fecha = fecha;
    }

    public int getNumeroTarjetaCredito() {
        return numeroTarjetaCredito;
    }

    public void setNumeroTarjetaCredito(int numeroTarjetaCredito) {
        this.numeroTarjetaCredito = numeroTarjetaCredito;
    }
    
}
