package cesur.dam1.practica;

import java.util.ArrayList;

public class GestorTareas {
    private ArrayList<String> tareas;
    private ArrayList<Boolean> completadas;

    public GestorTareas() {
        tareas = new ArrayList<>();
        completadas = new ArrayList<>();
    }

    public void agregarTarea(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la tarea no puede estar vacío");
        }
        tareas.add(nombre);
        completadas.add(false);
    }

    public void completarTarea(int indice) {
        // BUG: Aquí falta validar si el índice es menor que 0 o mayor/igual que tareas.size()
        completadas.set(indice, true);
    }

    public void eliminarTarea(int indice) {
        // BUG: Aquí también falta validar el rango del índice antes de borrar
        tareas.remove(indice);
        completadas.remove(indice);
    }

    public int contarPendientes() {
        int pendientes = 0;
        // BUG: El bucle tiene un error clásico de límite (itera una vez de más o de menos según cómo se mire)
        for (int i = 0; i <= tareas.size(); i++) { 
            if (!completadas.get(i)) {
                pendientes++;
            }
        }
        return pendientes;
    }

    public int getTotalTareas() {
        return tareas.size();
    }

    public String getTarea(int indice) {
        return tareas.get(indice);
    }
}
