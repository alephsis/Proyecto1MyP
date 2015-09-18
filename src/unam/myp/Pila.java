package unam.myp;

import java.util.NoSuchElementException;

/**
 * Clase para pilas con las funciones Mete/Saca/Mira.
 */
public class Pila<T> {

    /**
     * Clase privada Nodo para uso de la pila.
     */
    private class Nodo {
        /** El elemento del nodo. */
        public T elemento;
        /** El siguiente nodo. */
        public Nodo siguiente;

        /**
         * Construye un nodo con un elemento.
         * @param elemento el elemento del nodo.
         */
        public Nodo(T elemento) {
            this.elemento = elemento;
        }
    }//class Nodo

    /** La cabeza de la pila. */
    public Nodo cabeza;
    /** El rabo de la pila. */
    public Nodo rabo;
    /** El número de elementos en la estructra. */
    public int elementos;

    /**
     * Agrega un elemento al tope de la pila.
     * @param elemento el elemento a agregar.
     */
    public void mete(T elemento) {
    
	Nodo nvo = new Nodo (elemento);
	if(elementos == 0){
	    cabeza = rabo = nvo;	    
	}else{	   
	    nvo.siguiente = cabeza;
	    cabeza = nvo;
	}//if-else
	elementos++;
    }//mete
    
    /**
     * Elimina el elemento en el tope de la pila y lo regresa.
     * @return el elemento en el tope de la pila.
     * @throws NoSuchElementException si la pila está vacía.
     */
    public T saca() {
	if (elementos == 0) throw new NoSuchElementException();
	Nodo lel = cabeza;
	if (elementos == 1) {
	    cabeza = null;
	    elementos--;
	    return lel.elemento;
	} //if     
	cabeza = cabeza.siguiente;
	elementos--;
	return lel.elemento;
    }//saca

    /**
     * Nos permite ver el elemento al tope de la pila, sin sacarlo
     * de la misma.
     * @return el elemento en un extremo de la pila.
     * @throws NoSuchElementException si la pila está vacía.
     */
    public T mira() {
	if (elementos == 0) throw new NoSuchElementException();
	return cabeza.elemento;
    }//mira

    /**
     * Nos dice si la pila está vacía.
     * @return true si la pila no tiene elementos,
     *         false en otro caso.
     */
    public boolean esVacia() {
	return elementos == 0 ? true : false ;
    }//esVacia
    
}//class

