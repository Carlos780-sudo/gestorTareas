package cesur.dam1.practica;

import java.util.ArrayList;
import java.util.List;

public class GestorTareas {
    
    private List<String> tareas;
    private List<Boolean> completadas;
    
    public GestorTareas() {
        tareas = new ArrayList<>();
        completadas = new ArrayList<>();
    }
    
    public void agregarTarea(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
        tareas.add(nombre);
        completadas.add(false);
    }

    // ---> ESTE ES EL MÉTODO QUE TE FALTABA <---
    private void validarIndice(int indice) {
        if (indice < 0 || indice >= tareas.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }

    public void completarTarea(int indice) {
        validarIndice(indice); 
        completadas.set(indice, true);
    }
    
    public void eliminarTarea(int indice) {
        validarIndice(indice); 
        tareas.remove(indice);
        completadas.remove(indice);
    }
    
    public int contarPendientes() {
        int count = 0;
        for (boolean c : completadas) {
            if (!c) count++;
        }
        return count;
    }
    
    public int getTotalTareas() {
        return tareas.size();
    }
    
    public String getTarea(int indice) {
        validarIndice(indice); 
        return tareas.get(indice);
    }
    
    public boolean estaCompletada(int indice) {
        validarIndice(indice); 
        return completadas.get(indice);
    }
}