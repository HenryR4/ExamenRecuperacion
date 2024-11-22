/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicios;

import excepciones.VideojuegoException;
import interfaces.CrudOperations;
import interfaces.VideojuegoOperation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import modelo.Videojuego;

/**
 *
 * @author hisco
 */
public class VideojuegoManager implements CrudOperations<Videojuego>, VideojuegoOperation {
    private final Map<Integer, Videojuego> videojuegos;
    private int ultimoId;
    
    public VideojuegoManager() {
        this.videojuegos = new HashMap<>();
        this.ultimoId = 0;
    }
    
    @Override
    public void agregar(Videojuego videojuego) {
        try {
            int nuevoId = ++ultimoId;
            Videojuego nuevoVideojuego = new Videojuego(
                nuevoId,
                videojuego.getNombre(),
                videojuego.getPrecio(),
                videojuego.getGenero(),
                videojuego.getPlataforma(),
                videojuego.getDesarrolladora(),
                videojuego.getAñoLanzamiento()
            );
            videojuegos.put(nuevoId, nuevoVideojuego);
        } catch (IllegalArgumentException e) {
            throw new VideojuegoException("Error al agregar videojuego: " + e.getMessage());
        }
    }
    
    @Override
    public Videojuego buscarPorId(int id) {
        validarExistenciaVideojuegos();
        Videojuego videojuego = videojuegos.get(id);
        if (videojuego == null) {
            throw new VideojuegoException("No se encontró videojuego con ID: " + id);
        }
        return videojuego;
    }
    
    @Override
    public List<Videojuego> consultarTodos() {
        validarExistenciaVideojuegos();
        return new ArrayList<>(videojuegos.values());
    }
    
    @Override
    public List<Videojuego> buscarPorGenero(String genero) {
        validarExistenciaVideojuegos();
        return videojuegos.values().stream()
                         .filter(v -> v.getGenero().equalsIgnoreCase(genero))
                         .collect(Collectors.toList());
    }
    
    @Override
    public List<Videojuego> buscarPorRangoPrecio(double precioMin, double precioMax) {
        validarExistenciaVideojuegos();
        if (precioMin < 0 || precioMax < precioMin) {
            throw new VideojuegoException("Rango de precios inválido");
        }
        return videojuegos.values().stream()
                         .filter(v -> v.getPrecio() >= precioMin && v.getPrecio() <= precioMax)
                         .collect(Collectors.toList());
    }
    
    @Override
    public List<Videojuego> buscarPorPlataforma(String plataforma) {
        validarExistenciaVideojuegos();
        return videojuegos.values().stream()
                         .filter(v -> v.getPlataforma().equalsIgnoreCase(plataforma))
                         .collect(Collectors.toList());
    }
    
    @Override
    public List<Videojuego> buscarPorDesarrolladora(String desarrolladora) {
        validarExistenciaVideojuegos();
        return videojuegos.values().stream()
                         .filter(v -> v.getDesarrolladora().equalsIgnoreCase(desarrolladora))
                         .collect(Collectors.toList());
    }
    
    @Override
    public boolean actualizar(int id, Videojuego videojuego) {
        if (!videojuegos.containsKey(id)) {
            throw new VideojuegoException("No existe videojuego con ID: " + id);
        }
        try {
            Videojuego actualizado = new Videojuego(
                id,
                videojuego.getNombre(),
                videojuego.getPrecio(),
                videojuego.getGenero(),
                videojuego.getPlataforma(),
                videojuego.getDesarrolladora(),
                videojuego.getAñoLanzamiento()
            );
            videojuegos.put(id, actualizado);
            return true;
        } catch (IllegalArgumentException e) {
            throw new VideojuegoException("Error al actualizar videojuego: " + e.getMessage());
        }
    }
    
    @Override
    public boolean eliminar(int id) {
        validarExistenciaVideojuegos();
        if (videojuegos.remove(id) == null) {
            throw new VideojuegoException("No se pudo eliminar el videojuego con ID: " + id);
        }
        return true;
    }
    
    @Override
    public int contarVideojuegos() {
        return videojuegos.size();
    }
    
    @Override
    public double calcularValorInventario() {
        return videojuegos.values().stream()
                         .mapToDouble(Videojuego::getPrecio)
                         .sum();
    }
    
    private void validarExistenciaVideojuegos() {
        if (videojuegos.isEmpty()) {
            throw new VideojuegoException("No hay videojuegos registrados en el sistema");
        }
    }
}