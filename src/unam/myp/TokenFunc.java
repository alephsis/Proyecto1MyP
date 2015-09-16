package unam.myp;

/** 
 *Clase que crea Tokens solo para funciones
 */

public class TokenFunc extends Token{
        
    /** 
     *  Modificador que recibe el contenido del token 
     *  y lo acota a solo funciones, en caso de que no sea
     *  función el parametro simplemente deja el token vacío
     *  @param s el contenido que estará en el token
     */

    public void setS(String s){	
	if(s.equals("sen") || s.equals("cos") || s.equals("tan") ||
	   s.equals("sec") || s.equals("csc") || s.equals("cot") ||
	   s.equals("sqr")){ 
	    this.s = s;
	    return;
	}//if
	System.err.println("Solo recibe funciones");	    
	this.s = "";	    
    }
    
}//class    
