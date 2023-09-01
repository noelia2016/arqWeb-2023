
package main.modelos;

public class Factura {
    private int factura;
    private int cliente;
    
    public Factura(int factura, int cliente) {
        this.factura = factura;
        this.cliente = cliente;
    }
    public int getFactura() {
        return factura;
    }
    public void setFactura(int factura) {
        this.factura = factura;
    }
    public int getCliente() {
        return cliente;
    }
    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

  
    
}
