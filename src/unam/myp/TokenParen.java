package unam.myp;

/** 
 *Clase que crea Tokens solo para paréntesis
 */

public class TokenParen extends Token{
        
    /** 
     *  Modificador que recibe el contenido del token 
     *  y lo acota a solo paréntesis, en caso de que no sea
     *  paréntesis el parametro simplemente deja el token vacío
     *  @param s el contenido que estará en el token
     */

    public void setS(String s){	
	if(s.equals("(") || s.equals(")")){ 
	    this.s = s;
	    return;
	}//if
	System.err.println("Solo recibe paréntesis");	    
	this.s = "";	    
    }
    
}//class    
