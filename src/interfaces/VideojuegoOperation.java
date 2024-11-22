/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import modelo.Videojuego;

/**
 *
 * @author hisco
 */

public interface VideojuegoOperation {
    List<Videojuego> buscarPorGenero(String genero);
    List<Videojuego> buscarPorRangoPrecio(double precioMin, double precioMax);
    List<Videojuego> buscarPorPlataforma(String plataforma);
    List<Videojuego> buscarPorDesarrolladora(String desarrolladora);
    int contarVideojuegos();
    double calcularValorInventario();
}