package unam.myp;

/** 
 *Clase que crea Tokens solo para la variable x
 */

public class TokenVar extends Token{
        
    /** 
     *  Modificador que recibe el contenido del token 
     *  y lo acota a solo la variable x, en caso de que no sea
     *  esta, el parametro simplemente deja el token vacío
     *  @param s el contenido que estará en el token
     */

    public void setS(String s){	
	if(s.equals("x")){ 
	    this.s = s;
	    return;
	}//if
	System.err.println("Solo recibe a la variable \"x\"");	    
	this.s = "";	    
    }
    
}//class    
