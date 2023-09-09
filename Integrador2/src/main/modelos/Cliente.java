
package main.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(nullable = false)
    private String nombre=null;

    @Column(name="email")
    private String email=null;

    public Cliente(){
        super();
    }

    public Cliente (String nombre, String email){
        this.nombre=nombre;
        this.email=email;
    }

    @Override
    public String toString() {
        return "******** Cliente [id=" + id + ", nombre=" + nombre + ", email=" + email + "]";
    }

    public int getId(){
        return this.id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
