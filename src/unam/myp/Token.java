package unam.myp;

/**
 * Clase para los tokens en los que se 
 * divide la entrada del polinomio
 */

public class Token {
    
    /** el contenido del token */
    String s;
    
    /** Constructor que crea el token con una cadena vacía */
    public Token(){
	this.s = "";
    }//Bob
    
    /** Metodo que nos da el contenido 
     *@return s el contenido del Token
     */
    public String escupe(){
	return s;
    }//escupe
    
    /** Modificador que cambia el contenido del token 
     *  @param s la cadena que irá en el Token
     */
    public void setS(String s){
	this.s = s;
    }//setS

    /**
     *  Método que nos da una representación en 
     *  cadena del token 
     *  @return s el contenido del Token
     */        
    public String toString(){
	return s;
    }//escupe
        
}//class
