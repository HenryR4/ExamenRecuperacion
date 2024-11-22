/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hisco
 */
public abstract class Producto {
    protected int id;
    protected String nombre;
    protected double precio;
    
    protected Producto(int id, String nombre, double precio) {
        validarPrecio(precio);
        this.id = id;
        this.nombre = validarNombre(nombre);
        this.precio = precio;
    }
    
    private void validarPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero");
        }
    }
    
    private String validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        return nombre.trim();
    }
    
    // Getters y setters con validación
    public int getId() { return id; }
    
    public String getNombre() { return nombre; }
    
    public double getPrecio() { return precio; }
    
    public void setPrecio(double precio) {
        validarPrecio(precio);
        this.precio = precio;
    }
}
