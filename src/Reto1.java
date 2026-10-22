package src; 

/**
 * Reto 1 (Versión B): Lista Enlazada Simple - Cola de canciones.
 *@ author: Angel de Jesus Nolasco Rivera
 *@date: 22/10/2026
 * Completa la inserción al inicio, el conteo y la inversión de la lista
 */

class Nodo {
    String cancion;
    Nodo siguiente;

    Nodo(String cancion) {
        this.cancion = cancion;
        this.siguiente = null;
    }
}

class ListaSimple {
    private Nodo cabeza;

    /**
     * Inserta una canción al inicio de la lista simple
     * @param cancion Nombre de la canción.
     */
    public void insertarInicio(String cancion) {
        Nodo nuevo = new Nodo(cancion);
        // TODO 1: el nuevo debe apuntar a la cabeza actual
        nuevo.siguiente = cabeza;
        // TODO 2: la cabeza ahora es el nuevo[cite: 6]
        cabeza = nuevo;
    }

    /**
     * Cuenta el número total de canciones
     * @return Total de nodos.
     */
    public int contar() {
        int total = 0;
        Nodo actual = cabeza;
        // TODO 3: condición para recorrer mientras actual no sea null
        while (actual != null) {
            // TODO 4: acumular y avanzar
            total++;
            actual = actual.siguiente;
        }
        return total;
    }

    /**
     * Invierte la lista SIN crear nodos nuevos
     */
    public void invertir() {
        Nodo anterior = null;
        Nodo actual = cabeza;
        while (actual != null) {
            Nodo proximo = actual.siguiente; // guarda la referencia antes de romper el enlace
            
            // TODO 5: invertir el enlace de 'actual'
            actual.siguiente = anterior;
            
            // TODO 6: avanzar 'anterior'
            anterior = actual;
            
            // TODO 7: avanzar 'actual'
            actual = proximo;
        }
        // TODO 8: ¿quién queda como nueva cabeza?
        cabeza = anterior;
    }

    /**
     * Muestra la lista de canciones.
     */
    public void mostrar() {
        Nodo actual = cabeza;
        while (actual != null) {
            System.out.print(actual.cancion + " -> ");
            actual = actual.siguiente;
        }
        System.out.println("null");
    }
}

public class Reto1 {
    public static void main(String[] args) {
        ListaSimple playlist = new ListaSimple();

        System.out.println("--- PRUEBAS RETO 1 (VERSIÓN B): COLA DE CANCIONES ---");
        // Agregando 4+ canciones propias
        playlist.insertarInicio("Apocalypse");
        playlist.insertarInicio("Perdido en la Oscuridad");
        playlist.insertarInicio("Las rejas no matan");
        playlist.insertarInicio("Strawberry Fields Forever");
        playlist.insertarInicio("Ten years gone");

        System.out.print("Playlist original (insertada al inicio): ");
        playlist.mostrar();
        System.out.println("Total de canciones: " + playlist.contar());

        System.out.println("\nInvirtiendo la playlist...");
        playlist.invertir();
        playlist.mostrar();
    }
}