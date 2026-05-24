package cesur.dam1.practica;

// Importamos las herramientas de JUnit 5
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class GestorTareasTest {

    // PRUEBA 1: Verificar que una tarea válida se añade bien (Caja Negra)
    @Test
    void testAgregarTareaValida() {
        GestorTareas gestor = new GestorTareas();
        
        gestor.agregarTarea("Estudiar Entornos de Desarrollo");
        
        // Comprobamos que el total de tareas pase a ser 1
        assertEquals(1, gestor.getTotalTareas(), "El total de tareas debería ser 1.");
        // Comprobamos que el texto guardado sea el correcto
        assertEquals("Estudiar Entornos de Desarrollo", gestor.getTarea(0));
    }

    // PRUEBA 2: Comprobar que no se admitan textos vacíos (Caja Negra)
    @Test
    void testAgregarTareaNombreVacioLanzaExcepcion() {
        GestorTareas gestor = new GestorTareas();
        
        // El código original ya controla esto saltando un IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            gestor.agregarTarea("   ");
        }, "Debería saltar una excepción si el nombre solo tiene espacios.");
    }

    // PRUEBA 3: Forzar el bug al completar un índice inválido (Caja Blanca)
    // ⚠️ NOTA: Esta prueba va a fallar (saldrá en ROJO) porque el código original no está protegido.
    @Test
    void testCompletarTareaIndiceInvalido() {
        GestorTareas gestor = new GestorTareas();
        gestor.agregarTarea("Hacer el trabajo final");
        
        // Intentamos completar la posición 99 (que no existe)
        // Debería lanzar una excepción controlada, pero el programa romperá con IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> {
            gestor.completarTarea(99);
        });
    }

    // PRUEBA 4: Comprobar el método de contar tareas pendientes (Caja Blanca)
    // ⚠️ NOTA: Esta prueba también fallará en rojo por culpa del bug en el bucle 'for' del código original.
    @Test
    void testContarPendientes() {
        GestorTareas gestor = new GestorTareas();
        gestor.agregarTarea("Tarea 1");
        gestor.agregarTarea("Tarea 2");
        
        // Como no hemos completado ninguna, debería haber 2 pendientes
        assertEquals(2, gestor.contarPendientes(), "Debería haber 2 tareas pendientes.");
    }
}
