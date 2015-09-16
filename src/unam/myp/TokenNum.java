package unam.myp;

/** 
 *Clase que crea Tokens solo para numeros
 */

public class TokenNum extends Token{
        
    /** 
     *  Modificador que recibe el contenido del token 
     *  y lo acota a solo números, en caso de que no sea
     *  número el parametro simplemente deja el token vacío
     *  @param s el contenido que estará en el token
     */

    @Override public void setS(String s){	
	try{
	    Double.parseDouble(s);
	    this.s = s;		      
	}catch(NumberFormatException nfee){
	    this.s = "";
	    System.err.println("Solo recibe números");
	}
    }

}//class    
