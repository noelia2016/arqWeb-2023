
package modelos;

public class Factura_Producto {

    private Int cantidad;
    private Int producto;

    public Factura_Producto(Int cantidad, Float valor) {
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public Int getCantidad() {
        return cantidad;
    }

    public void setCantidad(Int cantidad) {
        this.cantidad = cantidad;
    }

    public Int getProducto() {
        return producto;
    }

    public void setProducto(Int producto) {
        this.producto = producto;
    }

    
}
