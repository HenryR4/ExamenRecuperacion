/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;

/**
 *
 * @author hisco
 * @param <T>
 */
public interface CrudOperations<T> {
    void agregar(T item);
    T buscarPorId(int id);
    List<T> consultarTodos();
    boolean actualizar(int id, T item);
    boolean eliminar(int id);
}
