package src; 

/**
 * Reto 3 (Versión B): Lista Enlazada Circular - Reproducción en bucle.
 *@ author: Angel de Jesus Nolasco Rivera
 *@ date: 22/10/2026
 * Completa la inserción, rotación (avance de canción) y eliminación de la canción actual.
 */
class NodoCircular {
    String cancion;
    NodoCircular siguiente;

    NodoCircular(String cancion) {
        this.cancion = cancion;
    }
}

class ListaCircular {
    private NodoCircular actual; // canción en reproducción
    private NodoCircular cola;

    /**
     * Inserta una canción en la lista circular de reproducción.
     * @param cancion Nombre de la canción.
     */
    public void insertar(String cancion) {
        NodoCircular nuevo = new NodoCircular(cancion);
        if (cola == null) {
            // TODO 1: un solo nodo apunta a sí mismo; defina 'actual' y 'cola'
            actual = nuevo;
            cola = nuevo;
            nuevo.siguiente = nuevo;
        } else {
            // TODO 2: el nuevo se coloca entre la cola y la cabeza (cola.siguiente)
            NodoCircular cabeza = cola.siguiente;
            cola.siguiente = nuevo;
            nuevo.siguiente = cabeza;
            // TODO 3: actualizar la cola
            cola = nuevo;
        }
    }

    /**
     * Avanza n canciones (rota la reproducción).
     * @param n Número de posiciones a avanzar.
     */
    public void rotar(int n) {
        for (int i = 0; i < n; i++) {
            // TODO 4: avanzar 'actual' (¿necesita comprobar null para llegar al final?)
            if (actual != null) {
                actual = actual.siguiente;
            }
        }
    }

    /**
     * Elimina la canción en reproducción y pasa a la siguiente[cite: 8].
     */
    public void eliminarActual() {
        if (cola == null) return;

        if (actual == actual.siguiente) {
            // TODO 5: era el único nodo[cite: 8]
            actual = null;
            cola = null;
            return;
        }

        // TODO 6: busque el nodo anterior a 'actual' (recorra el círculo)[cite: 8]
        NodoCircular previo = cola;
        while (previo.siguiente != actual) {
            previo = previo.siguiente;
        }

        // TODO 7: salte 'actual', actualice la cola si era necesario y avance 'actual'[cite: 8]
        previo.siguiente = actual.siguiente;
        if (actual == cola) {
            cola = previo;
        }
        actual = actual.siguiente;
    }

    public void mostrarBucle() {
        if (cola == null) {
            System.out.println("Playlist vacía");
            return;
        }
        NodoCircular head = cola.siguiente;
        NodoCircular temp = head;
        do {
            String indicador = (temp == actual) ? " [SONANDO]" : "";
            System.out.print(temp.cancion + indicador + " -> ");
            temp = temp.siguiente;
        } while (temp != head);
        System.out.println("(vuelve al inicio del bucle)");
    }
}

public class Reto3 {
    public static void main(String[] args) {
        ListaCircular playlistBucle = new ListaCircular();

        System.out.println("--- PRUEBAS RETO 3 (VERSIÓN B): BUCLE DE REPRODUCCIÓN ---");
        playlistBucle.insertar("Track 1: Intro");
        playlistBucle.insertar("Track 2: Action");
        playlistBucle.insertar("Track 3: Suspense");
        playlistBucle.insertar("Track 4: Credits");

        System.out.print("Estado inicial del bucle: ");
        playlistBucle.mostrarBucle();

        System.out.println("\nRotando 2 canciones...");
        playlistBucle.rotar(2);
        playlistBucle.mostrarBucle();

        System.out.println("\nEliminando la canción actual que se está reproduciendo...");
        playlistBucle.eliminarActual();
        playlistBucle.mostrarBucle();
    }
}