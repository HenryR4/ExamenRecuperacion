
import excepciones.VideojuegoException;
import java.util.List;
import modelo.Videojuego;
import servicios.VideojuegoManager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author hisco
 */
public class Main {

    /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
        VideojuegoManager manager = new VideojuegoManager();
        
        try {
            // Prueba de registro
            System.out.println("=== Registrando videojuegos ===");
            manager.agregar(new Videojuego(0, "Fornite", 59.99, "Acción/Aventura", 
                                         "PS5", "Epic Games", 2020));
            manager.agregar(new Videojuego(0, "FIFA 24", 69.99, "Deportes", 
                                         "PS5", "EA Sports", 2023));
            manager.agregar(new Videojuego(0, "Call of Duty", 29.99, "Aventura", 
                                         "PC", "Ubisoft", 2011));
             manager.agregar(new Videojuego(0, "Far cry", 29.99, "Accion", 
                                         "Xbox", "Ubisoft", 2011));
              manager.agregar(new Videojuego(0, "Mario Kart", 29.99, "Aventura", 
                                         "Nintendo", "Nintendo", 2020));
            System.out.println("Videojuegos registrados: " + manager.contarVideojuegos());
            
            // Mostrar todos los videojuegos
            System.out.println("\n=== Lista de videojuegos ===");
            manager.consultarTodos().forEach(System.out::println);
            
            // Búsqueda por rango de precio
            System.out.println("\n=== Videojuegos entre Q30 y Q60 ===");
            List<Videojuego> porPrecio = manager.buscarPorRangoPrecio(30.0, 60.0);
            porPrecio.forEach(System.out::println);
            
            // Búsqueda por plataforma
            System.out.println("\n=== Videojuegos para PS5 ===");
            manager.buscarPorPlataforma("PS5").forEach(System.out::println);
            
            // Valor total del inventario
            System.out.printf("\nValor total del inventario: Q%.2f%n", 
                            manager.calcularValorInventario());
            
        } catch (VideojuegoException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
