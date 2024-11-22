/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author hisco
 */
public class Videojuego extends Producto {
    private final String genero;
    private final String plataforma;
    private final String desarrolladora;
    private final int añoLanzamiento;
    
    public Videojuego(int id, String nombre, double precio, String genero, 
                      String plataforma, String desarrolladora, int añoLanzamiento) {
        super(id, nombre, precio);
        this.genero = validarCampo(genero, "género");
        this.plataforma = validarCampo(plataforma, "plataforma");
        this.desarrolladora = validarCampo(desarrolladora, "desarrolladora");
        this.añoLanzamiento = validarAño(añoLanzamiento);
    }
    
    private String validarCampo(String campo, String nombreCampo) {
        if (campo == null || campo.trim().isEmpty()) {
            throw new IllegalArgumentException("El " + nombreCampo + " no puede estar vacío");
        }
        return campo.trim();
    }
    
    private int validarAño(int año) {
        int añoActual = java.time.Year.now().getValue();
        if (año < 1958 || año > añoActual + 2) { // 1958: primer videojuego
            throw new IllegalArgumentException("Año de lanzamiento inválido");
        }
        return año;
    }
    

    public String getGenero() { return genero; }
    public String getPlataforma() { return plataforma; }
    public String getDesarrolladora() { return desarrolladora; }
    public int getAñoLanzamiento() { return añoLanzamiento; }
    
    @Override
    public String toString() {
        return String.format("ID: %d | %s | Q%.2f | %s | %s | %s | %d", 
                           id, nombre, precio, genero, plataforma, desarrolladora, añoLanzamiento);
    }
}