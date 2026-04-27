package gestor;
import java.util.List;
import java.util.ArrayList;

public class GestorTareas {
/**
* Gestor de lista de tareas (To-Do list).
* Proyecto: gestor-tareas
* Versión: 1.0
*/
 private List<String> tareas;
 private List<Boolean> completadas;
 public GestorTareas() {
 tareas = new ArrayList<>();
 completadas = new ArrayList<>();
 }
 public void agregarTarea(String nombre) {
 if (nombre == null || nombre.trim().isEmpty()) {
 throw new IllegalArgumentException("El nombre no puede estar
vacío");
 }
 tareas.add(nombre);
 completadas.add(false);
 }
 // ¿Qué pasa si índice no existe?
 public void completarTarea(int indice) {
 completadas.set(indice, true); // ← sin validación de rango
 }
 public void eliminarTarea(int indice) {
 tareas.remove(indice); // ← sin validación de rango
 completadas.remove(indice);
 }
 public int contarPendientes() {
 int count = 0;
 for (boolean c : completadas) {
 if (!c) count++;
 }
 return count;
 }
 // Devuelve cuántas tareas hay en total
 public int getTotalTareas() {
 return tareas.size();
 }
 public String getTarea(int indice) {
 return tareas.get(indice); // ← sin validación de rango
}
 public boolean estaCompletada(int indice) {
 return completadas.get(indice); // ← sin validación de rango
 }
}