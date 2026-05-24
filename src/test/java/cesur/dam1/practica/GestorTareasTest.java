package cesur.dam1.practica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GestorTareasTest {
     private GestorTareas gestor;

    @BeforeEach
    void setUp() {
        gestor = new GestorTareas();
    }

    // --- PRUEBAS DE CAJA BLANCA: BUCLE DE contarPendientes() ---

    @Test
    @DisplayName("contarPendientes debe devolver 0 si la lista está vacía")
    void testContarPendientesListaVacia() {
        assertEquals(0, gestor.contarPendientes(), "Una lista vacía debería tener 0 tareas pendientes.");
    }

    @Test
    @DisplayName("contarPendientes debe contar correctamente mezclando tareas completadas y pendientes")
    void testContarPendientesConVariasTareas() {
        gestor.agregarTarea("Tarea 1");
        gestor.agregarTarea("Tarea 2");
        gestor.agregarTarea("Tarea 3");
        
        gestor.completarTarea(1); // Completamos la segunda tarea
        
        // El bucle iterará 3 veces evaluando la ruta verdadera y falsa del if
        assertEquals(2, gestor.contarPendientes(), "Debería haber 2 tareas pendientes.");
    }

    @Test
    @DisplayName("contarPendientes debe devolver 0 si todas las tareas están completadas")
    void testContarPendientesTodasCompletadas() {
        gestor.agregarTarea("Tarea 1");
        gestor.completarTarea(0);
        
        assertEquals(0, gestor.contarPendientes(), "No debería haber tareas pendientes.");
    }

    // --- PRUEBAS DE CAJA BLANCA: EXCEPCIONES ---

    @Test
    @DisplayName("completarTarea con un índice negativo debe lanzar IndexOutOfBoundsException")
    void testCompletarTareaIndiceNegativo() {
        gestor.agregarTarea("Prueba");
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.completarTarea(-1));
    }

    @Test
    @DisplayName("eliminarTarea con un índice fuera de rango debe lanzar IndexOutOfBoundsException")
    void testEliminarTareaIndiceFueraDeRango() {
        gestor.agregarTarea("Prueba");
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.eliminarTarea(1)); // El índice 1 no existe (es 0)
    }

    @Test
    @DisplayName("getTarea solicitando una tarea en una lista vacía debe lanzar IndexOutOfBoundsException")
    void testGetTareaListaVacia() {
        assertThrows(IndexOutOfBoundsException.class, () -> gestor.getTarea(0));
    }
}

