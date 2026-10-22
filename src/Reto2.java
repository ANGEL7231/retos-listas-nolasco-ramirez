package src; 

/**
 * Reto 2 (Versión B): Lista Doblemente Enlazada - Reproductor con anterior y siguiente.
 *@ author: Angel de Jesus Nolasco Rivera
 *@ date: 22/10/2026
 * Completa la inserción al final, inserción después de una canción dada y recorrido inverso.
 */

class NodoDoble {
    String cancion;
    NodoDoble siguiente, anterior;

    NodoDoble(String cancion) {
        this.cancion = cancion;
    }
}

class ListaDoble {
    private NodoDoble cabeza, cola;

    /**
     * Inserta una canción al final de la lista doble.
     * @param cancion Nombre de la canción.
     */
    public void insertarFinal(String cancion) {
        NodoDoble nuevo = new NodoDoble(cancion);
        if (cola == null) {
            // TODO 1: lista vacía[cite: 7]
            cabeza = nuevo;
            cola = nuevo;
        } else {
            // TODO 2: enlazar cola.siguiente con el nuevo.
            cola.siguiente = nuevo;
            // TODO 3: enlazar nuevo.anterior con la cola.
            nuevo.anterior = cola;
            // TODO 4: actualizar la cola[cite: 7]
            cola = nuevo;
        }
    }

    /**
     * Inserta una canción nueva justo después de una canción existente.
     * @param existente Canción de referencia.
     * @param nueva Canción a insertar.
     * @return true si se insertó con éxito, false si no se encontró la existente.
     */
    public boolean insertarDespuesDe(String existente, String nueva) {
        NodoDoble actual = cabeza;
        while (actual != null && !actual.cancion.equals(existente)) {
            actual = actual.siguiente;
        }
        if (actual == null) return false;

        NodoDoble nuevo = new NodoDoble(nueva);
        // TODO 5: enlazar nuevo con 'actual' y con actual.siguiente (4 enlaces en total)
        nuevo.siguiente = actual.siguiente;
        nuevo.anterior = actual;
        if (actual.siguiente != null) {
            actual.siguiente.anterior = nuevo;
        }
        actual.siguiente = nuevo;

        // TODO 6: si 'actual' era la cola, ¿qué debe actualizarse?
        if (actual == cola) {
            cola = nuevo;
        }

        return true;
    }

    public void mostrarAdelante() {
        NodoDoble actual = cabeza;
        while (actual != null) {
            System.out.print(actual.cancion + " <-> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }

    /**
     * Recorre e imprime desde la cola hasta null.
     */
    public void mostrarInverso() {
        NodoDoble actual = cola;
        while (actual != null) {
            System.out.print(actual.cancion + " <-> ");
            actual = actual.anterior;
        }
        System.out.println("null");
    }
}

public class Reto2 {
    public static void main(String[] args) {
        ListaDoble reproductor = new ListaDoble();

        System.out.println("--- PRUEBAS RETO 2 (VERSIÓN B): REPRODUCTOR DOBLE ---");
        reproductor.insertarFinal("Song 2");
        reproductor.insertarFinal("Everlong");
        reproductor.insertarFinal("Creep");
        reproductor.insertarFinal("Smells Like Teen Spirit");

        System.out.print("Reproductor hacia adelante: ");
        reproductor.mostrarAdelante();

        System.out.print("Reproductor inverso: ");
        reproductor.mostrarInverso();

        System.out.println("\nInsertando 'Come As You Are' después de 'Creep'...");
        reproductor.insertarDespuesDe("Creep", "Come As You Are");
        reproductor.mostrarAdelante();

        System.out.print("Nuevo recorrido inverso: ");
        reproductor.mostrarInverso();
    }
}