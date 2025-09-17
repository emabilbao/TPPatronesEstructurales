package Main.Java.Facade;

public class TiendaFacade {
    private Carrito carrito;
    private Pago pago;
    private Envio envio;

    public TiendaFacade() {
        this.carrito = new Carrito();
        this.pago = new Pago();
        this.envio = new Envio();
    }

    //Metodo simplificado para comprar un producto
    public void comprar(String producto, double monto, String direccion) {
        carrito.agregarProducto(producto);
        pago.procesarPago(monto);
        envio.coordinarEnvio(direccion);
        System.out.println("Compra completada con exito!\n");
    }
}
