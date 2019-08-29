
package Model;

public class Dispositivo {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String modelo;
    private String marca;
    private int precio;
    private String color;
    
    public Dispositivo(){
        
    }

    public Dispositivo(String nombre, String descripcion, String modelo, String marca, int precio, String color) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.marca = marca;
        this.precio =  precio;
        this.color = color;
    }

        public Dispositivo(String nombre, String descripcion, String modelo, String marca, int precio, String color, int id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.modelo = modelo;
        this.marca = marca;
        this.precio =  precio;
        this.color = color;
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    
    
    
}
