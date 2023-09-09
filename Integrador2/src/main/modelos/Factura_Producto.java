
package main.modelos;

public class Factura_Producto {
    private int factura;
    private int producto;
    private int cantidad;
    public Factura_Producto(int factura, int producto, int cantidad) {
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    public int getFactura() {
        return factura;
    }
    public void setFactura(int factura) {
        this.factura = factura;
    }
    public int getProducto() {
        return producto;
    }
    public void setProducto(int producto) {
        this.producto = producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
