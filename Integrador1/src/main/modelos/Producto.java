
package main.modelos;

public class Producto {

    private String nombre;
    private Float valor;

    public Producto(String nombre, Float valor) {
        this.nombre = nombre;
        this.valor = valor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    
}
