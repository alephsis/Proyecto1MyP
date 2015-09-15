package unam.myp;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase genérica para listas doblemente ligadas.
 */

public class Lista<T> implements Iterable<T>{

    /* Clase Nodo privada para uso interno de la clase Lista. */
    private class Nodo {

        /* El elemento del nodo. */
        public T elemento;
        /* El nodo anterior. */
        public Nodo anterior;
        /* El nodo siguiente. */
        public Nodo siguiente;

        /* Construye un nodo con el elemento especificado. */
        public Nodo(T elemento) {
            this.elemento = elemento;
        }
    }
    
    /* Clase Iterador privada para iteradores. */
    private class Iterador<T> implements Iterator<T>{

        /* La lista a iterar. */
        Lista<T> lista;
        /* Elemento anterior. */
        private Lista<T>.Nodo anterior;
        /* Elemento siguiente. */
        private Lista<T>.Nodo siguiente;

        /* El constructor recibe una lista para inicializar su siguiente con la
         * cabeza. */
        public Iterador(Lista<T> lista) {
            
	    this.lista = lista;	    
	    this.siguiente = lista.cabeza;
        }

        /* Existe un siguiente elemento, si siguiente no es nulo. */
         public boolean hasNext() {
            
	    return this.siguiente == null ? false : true;
        }

        /* Regresa el elemento del siguiente, a menos que sea nulo, en cuyo caso
         * lanza la excepción NoSuchElementException. */
         public T next() {
            
	    if (siguiente == null) {
		throw new NoSuchElementException();
	    }else{
	        this.anterior = this.siguiente;
		this.siguiente = this.siguiente.siguiente;
		return this.anterior.elemento;
	    }
        }
	
        /* Existe un elemento anterior, si anterior no es nulo. */
         public boolean hasPrevious() {
            
	    return this.anterior == null ? false : true;
        }

        /* Regresa el elemento del anterior, a menos que sea nulo, en cuyo caso
         * lanza la excepción NoSuchElementException. */
         public T previous() {
            
	    if (anterior == null) {
		throw new NoSuchElementException();
	    }else{
	        this.siguiente = this.anterior;
		this.anterior = this.anterior.anterior;
		return this.siguiente.elemento;
	    }

        }

        /* No implementamos el método remove(); sencillamente lanzamos la
         * excepción UnsupportedOperationException. */
         public void remove() {
            throw new UnsupportedOperationException();
        }

        /* Mueve el iterador al inicio de la lista; después de llamar este
         * método, y si la lista no es vacía, hasNext() regresa verdadero y
         * next() regresa el primer elemento. */
         public void start() {
            
	    this.siguiente = this.lista.cabeza;
	    this.anterior = null;
	}
	
        /* Mueve el iterador al final de la lista; después de llamar este
1         * método, y si la lista no es vacía, hasPrevious() regresa verdadero y
         * previous() regresa el último elemento. */
         public void end() {
            
	    this.anterior = this.lista.rabo;
	    this.siguiente = null;
	}
    }    	
    /* Primer elemento de la lista. */
    private Nodo cabeza;
    /* Último elemento de la lista. */
    private Nodo rabo;
    /* Número de elementos en la lista. */
    private int longitud;

    /**
     * Regresa la longitud de la lista. El método es idéntico a {@link
     * #getElementos}.
     * @return la longitud de la lista, el número de elementos que contiene.
     */
    public int getLongitud() {
        
	return this.longitud;
    }

    /**
     * Regresa el número de elementos en la lista. El método es idéntico a
     * {@link getLongitud}.
     * @return el número de elementos en la lista.
     */
     public int getElementos() {
        
	return this.longitud;
    }

    /**
     * Agrega un elemento al final de la lista. El método es idéntico a {@link
     * #agregaFinal}.
     * @param elemento el elemento a agregar.
     */
     public void agrega(T elemento) {
             
	if(this.longitud == 0){
	    cabeza  = new Lista<T>.Nodo (elemento);
	    rabo = cabeza;
	}else{
	    rabo.siguiente = new Lista<T>.Nodo (elemento);
	    rabo.siguiente.anterior = rabo;
	    rabo = rabo.siguiente;	    
	}
	this.longitud++;	
    }

    /**
     * Agrega un elemento al inicio de la lista. Si la lista no tiene elementos,
     * el elemento a agregar será el primero y el último a la vez.
     * @param elemento el elemento a agregar.
     */
    public void agregaInicio(T elemento) {
        
	if(this.longitud == 0){
	    this.cabeza = this.rabo = new Lista<T>.Nodo (elemento);
	}else{	    
	    cabeza.anterior = new Lista<T>.Nodo (elemento);
	    cabeza.anterior.siguiente  = cabeza;
	    cabeza = cabeza.anterior;
	}
	longitud++;		
    }

    /**
     * Elimina un elemento de la lista. Si el elemento no está contenido en la
     * lista, el método no hace nada. Si el elemento aparece varias veces en la
     * lista, el método elimina el primero.
     * @param elemento el elemento a eliminar.
     */
     public void elimina(T elemento) {
              	
	Nodo target = this.buscaNodo (elemento);
	if(target == null)return;
	if(target == cabeza){ 
	    this.eliminaPrimero();	    
	    return;
	}
	if(target == rabo){
	    this.eliminaUltimo();		    
	    return;
	}
	target.siguiente.anterior = target.anterior;
	target.anterior.siguiente = target.siguiente;
	longitud--;
    }
    
    private Nodo buscaNodo(T elemento){
	if(!this.contiene(elemento))return null;
	Nodo temp = cabeza;
	while (temp != null){
	    if(temp.elemento.equals(elemento))break;
	    temp = temp.siguiente;
	}
	return temp;
    }
    /**
     * Elimina el primer elemento de la lista y lo regresa.
     * @return el primer elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaPrimero() {
        
	if (longitud == 0) {
	    throw new NoSuchElementException();
	}else{
	    if(longitud == 1){
		Nodo temp = cabeza;
		cabeza = rabo = null;
		longitud--;
		return temp.elemento;		
	    }else{
		Nodo temp = cabeza;
		cabeza = cabeza.siguiente;	       
		cabeza.anterior = null;
		longitud--;
		return temp.elemento;		
	    }		    		    	    
	}
    }
    
    /**
     * Elimina el último elemento de la lista y lo regresa.
     * @return el último elemento de la lista antes de eliminarlo.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T eliminaUltimo() {
        
	if (longitud == 0) {
	    throw new NoSuchElementException();
	}else{
	    if(longitud == 1){
		Nodo temp = cabeza;
		cabeza = rabo = null;
		longitud--;
		return temp.elemento;		
	    }else{
		Nodo temp = rabo;
		rabo = rabo.anterior;
		rabo.siguiente = null;
		longitud--;
		return temp.elemento;		
	    }
	}		    		    	    	
    }

    /**
     * Nos dice si un elemento está en la lista.
     * @param elemento el elemento que queremos saber si está en la lista.
     * @return <tt>true</tt> si <tt>elemento</tt> está en la lista,
     *         <tt>false</tt> en otro caso.
     */
     public boolean contiene(T elemento) {
        
	if(this.indiceDe(elemento)==-1)return false;
	return true;
    }

    /**
     * Regresa el primer elemento de la lista.
     * @return el primer elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getPrimero() {
        
	if (longitud == 0)throw new NoSuchElementException();
	return this.cabeza.elemento;
    }

    /**
     * Regresa el último elemento de la lista.
     * @return el último elemento de la lista.
     * @throws NoSuchElementException si la lista es vacía.
     */
    public T getUltimo() {
        
	if (longitud == 0)throw new NoSuchElementException();
	return this.rabo.elemento;
    }

    /**
     * Regresa el <em>i</em>-ésimo elemento de la lista.
     * @param i el índice del elemento que queremos.
     * @return el <em>i</em>-ésimo elemento de la lista, si <em>i</em> es mayor
     *         o igual que cero y menor que el número de elementos en la lista.
     * @throws ExcepcionIndiceInvalido si el índice recibido es menor que cero,
     *         o mayor que el número de elementos en la lista menos uno.
     */
    public T get(int i) {
        
	if (i < 0 || i > this.longitud -1) throw new IndexOutOfBoundsException();
	int counter = 0;
	Nodo temp = this.cabeza;
	while (counter < i){
	    temp = temp.siguiente;
	    counter++;
	}//while
	return temp.elemento;
    }

    /**
     * Regresa el índice del elemento recibido en la lista.
     * @param elemento el elemento del que se busca el índice.
     * @return el índice del elemento recibido en la lista, o -1 si el elemento
     *         no está contenido en la lista.
     */
    public int indiceDe(T elemento) {
        	
	if (this.longitud == 0)return -1;
	int indice = -1;       
	Iterator <T> it = iterator();	
	int counter = 0;
	while(it.hasNext()){
	    if (elemento.equals(it.next())){
		indice = counter;	       
		return indice;
	    }
	    counter++;
	}
	return indice;
    }
        
    /**
     * Regresa una representación en cadena de la lista.
     * @return una representación en cadena de la lista.
     */
     public String toString() {
        
	if (this.longitud == 0) return "[]";
	String s = "[";
	for (T e : this){
	    s+=e.toString() + ", ";
	}	
	return s.substring(0,s.length()-2) + "]";
    }
    
    /**
     * Regresa un iterador para recorrer la lista.
     * @return un iterador para recorrer la lista.
     */
     public Iterator<T> iterator() {
        return new Iterador<T>(this);
    }
    
}    
    
