package Negocio;

/**
 * Created by Nacho on 11/28/2015.
 */
public class Platillos {
    private String ingredientes;
    private String nombre;
    private String precio;

    public Platillos() {
    }

    public Platillos(String nombre, String ingredientes, String precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
