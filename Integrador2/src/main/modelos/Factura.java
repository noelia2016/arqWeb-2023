
package main.modelos;

import javax.persistence.Entity;
import javax.persistence.Id;
// import javax.persistence.OneToMany;

@Entity
public class Factura {

    @Id
    private int factura;

    // @Id
    private int cliente;
    
    public Factura(){
        super();
    }
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
