/**
*Reto 1
*author Uriel Ramírez
*@date 20 octubre 2026
*/
package src;
class Nodo {
 	String cancion;
 	Nodo siguiente;

	Nodo(String cancion) { 
	this.cancion = cancion; 
	}
}

class ListaSimple {
	private Nodo cabeza;
 	public void insertarInicio(String cancion) {
		Nodo nuevo = new Nodo(cancion);

 		// TODO 1: el nuevo debe apuntar a la cabeza actual
		nuevo.siguiente = cabeza;
 	
		// TODO 2: la cabeza ahora es el nuevo
		cabeza = nuevo;
 		}

		public int contar() {
 			int acumular = 0;
 			Nodo actual = cabeza;
 	
		while (actual !=null) {
 	
			// TODO 4: acumular y avanzar
			acumular++;
			actual = actual.siguiente;
	
 		}
 		return acumular;
	}
 	
	// Invierte la lista SIN crear nodos nuevos
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
 	public void mostrar() { 
		/* complete el recorrido */
		Nodo actual = cabeza;
		
		while (actual != null) {
		System.out.print(actual.cancion + " > ");
		actual = actual.siguiente;
		}
		System.out.println("null");
	}
}

public class Reto1 {
	public static void main(String[] args) {
	ListaSimple cola = new ListaSimple();

	System.out.println("*** Lista Vacia ***");
	cola.mostrar();
	System.out.println("Total: " + cola.contar());
	cola.invertir();
	cola.mostrar();

	System.out.println("\n*** Insercion al inicio **");
        cola.insertarInicio("Arabella");
        cola.mostrar();
	
        System.out.println("\n***Invertir con un solo nodo***");
        cola.invertir();
        cola.mostrar();
        cola.insertarInicio("Sex Tape");
        cola.insertarInicio("Bombtrack");
        cola.insertarInicio("Crying Lightning");
        cola.mostrar();
        System.out.println("Canciones: " + cola.contar());

        System.out.println("\n***Inversion***");
        cola.invertir();
        cola.mostrar();
        System.out.println("Total tras invertir: " + cola.contar());

      	}

}

