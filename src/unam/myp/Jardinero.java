package unam.myp;

import java.util.NoSuchElementException;

/**
 * Clase Jardinero que es utilizada para crear el árbol 
 * sintáctico del polinomio de entrada
 */

public class Jardinero {

    /**
     * Método publico que recibe una cadena(un polinomio) 
     * y la divide en los respectivos tokens.
     * @param s la cadena a dividir
     * @return una lista de tokens si es posible
     *         de lo contrario regresa null
     */
    public Lista<Token> divide(String s){
	Lista<Token> lista = new Lista<Token>();
	s = s.replaceAll(" ","");
	if(s.length() == 0)return null;
	String c = "";
	Token token = new Token();	
	for(int i = 0 ; i < s.length() ; i++){	    
	    try{
		c = s.valueOf(s.charAt(i));
		if(c.compareTo("(") == 0 || 
		   c.compareTo(")") == 0){
		    token = new TokenParen();
		    token.setS(c);
		    lista.agrega(token);
		    continue;
		}else if(c.compareTo("+") == 0 ||
			 c.compareTo("-") == 0 ||
			 c.compareTo("/") == 0 ||
			 c.compareTo("*") == 0 ||
			 c.compareTo("^") == 0){
		    token = new TokenOper();
		    token.setS(c);
		    lista.agrega(token);
		    continue;
		}else if(c.compareTo("x") == 0){
		    token = new TokenVar();
		    token.setS(c);
		    lista.agrega(token);
		    continue;
		}else if(c.compareTo("s") == 0){
		    if(s.valueOf(s.charAt(i+1)).compareTo("i") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("n") == 0){			
			    token = new TokenFunc();
			    token.setS("sin");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		    if(s.valueOf(s.charAt(i+1)).compareTo("e") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("c") == 0){			
			    token = new TokenFunc();
			    token.setS("sec");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		    if(s.valueOf(s.charAt(i+1)).compareTo("q") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("r") == 0){			
			    token = new TokenFunc();
			    token.setS("sqr");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		}else if(c.compareTo("c") == 0){
		    if(s.valueOf(s.charAt(i+1)).compareTo("o") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("s") == 0){			
			    token = new TokenFunc();
			    token.setS("cos");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}		
		    if(s.valueOf(s.charAt(i+1)).compareTo("s") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("c") == 0){			
			    token = new TokenFunc();
			    token.setS("csc");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		    if(s.valueOf(s.charAt(i+1)).compareTo("o") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("t") == 0){			
			    token = new TokenFunc();
			    token.setS("cot");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		}else if(c.compareTo("t") == 0){
		    if(s.valueOf(s.charAt(i+1)).compareTo("a") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("n") == 0){			
			    token = new TokenFunc();
			    token.setS("tan");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}		
		}else if(c.compareTo(".") == 0){	    	       
		    int j = 1;
		    try{
			while(true){
			    Double.parseDouble(s.valueOf(s.charAt(i+j)));
			    j++;
			}//while
		    }catch(NumberFormatException nfee){
			token = new TokenNum();
			token.setS(s.substring(i,i+j));
			lista.agrega(token);
			i+=(j-1);
			continue;
		    }catch(StringIndexOutOfBoundsException sioore){
			token = new TokenNum();
			token.setS(s.substring(i,i+j));
			lista.agrega(token);
			i+=(j-1);
			continue;
		    }
		}else if(Character.isDigit(s.charAt(i))){
		    int k = 0;
		    try{
			while(true){
			    if(!Character.isDigit(s.charAt(i+k)) &&  0 != s.valueOf(s.charAt(i+k)).compareTo("."))
				break;
			    k++;
			}//while 
			token = new TokenNum();
			token.setS(s.substring(i,i+k));
			lista.agrega(token);
			i+=(k-1);
			continue;
		    }catch(StringIndexOutOfBoundsException sioore){			
			token = new TokenNum();
			token.setS(s.substring(i,i+k));
			lista.agrega(token);
			i+=(k-1);
			continue;
		    }
		}
	    }catch(NumberFormatException nfe){}	    
	    catch(StringIndexOutOfBoundsException sioore){}
	    return null;
	}//for
	return lista;
    }//divide 
    
    /**
     *  Método que recibe una lista de Tokens y revisa si los 
     *  paréntesis son correctos con base a la gramática.
     *  @param l una lista de Tokens a evaluar
     *  @return true si son correctos false en otro caso     
     */
    
    public boolean checaParen(Lista<Token> l){
	Pila<String> pila = new Pila<String>();
	for (Token t : l) {
	    if (t.escupe().compareTo("(") == 0) pila.mete(")");
	    else if (t.escupe().compareTo(")") == 0) 
		if(!checa(")",pila)) return false;
	}
	if (pila.esVacia())
	    return true;	
	return false;      
    }//checaParen
    /**
     * Método privado que recibe un parentesis cerrado y
     * revisa si el que abre está en el tope de la pila
     * @param s el parentesis cerrado
     * @param pila la pila a revisar
     * @return true si el parentesis que abre está y false en otro caso
     */
    private boolean checa(String s, Pila<String> pila){
	if (pila.esVacia())
	    return false;
	String s2 = pila.saca();  
	if (s2.compareTo(s) != 0)return false;	  
	return true;
    }//checa
    
    /**
     *  Método que recibe una lista de Tokens agrupados
     *  según una gramática infija y nos regresa una 
     *  agrupada según una lista prefija
     *  @param l la lista infija a agrupar
     *  @return la lista prefija
     */
    
    public Lista<Token> aPrefija(Lista<Token> l){
	if (l == null) return null;
	String infijo = "";
	for(Token t: l){
	    if(t instanceof TokenNum){
		infijo += "("+t.escupe()+")"; 
		continue;
	    }
	    infijo += t.escupe();
	}
	return divide2(I2P(infijo));
    }//aPrefija

    /**
     *  Método privado auxiliar que es casi identico a divide
     *  pero que marca los negativos unarios
     *  @param s la cadena a dividir
     *  @return la lista ya dividida con los negativos unarios marcados  
     */

    public Lista<Token> divide2(String s){
	Lista<Token> lista = new Lista<Token>();
	s = s.replaceAll(" ","");
	if(s.length() == 0)return null;
	String c = "";
	Token token = new Token();	
	for(int i = 0 ; i < s.length() ; i++){	    
	    try{
		c = s.valueOf(s.charAt(i));
		if(c.compareTo("(") == 0 || 
		   c.compareTo(")") == 0){
		    token = new TokenParen();
		    token.setS(c);
		    lista.agrega(token);
		    continue;
		}else if(c.compareTo("+") == 0 ||			 
			 c.compareTo("/") == 0 ||
			 c.compareTo("*") == 0 ||
			 c.compareTo("^") == 0){
		    token = new TokenOper();
		    token.setS(c);
		    lista.agrega(token);
		    continue;
		}else if(c.compareTo("-") == 0){
		    if(s.valueOf(s.charAt(i-1)).compareTo("(") == 0)
			if(s.valueOf(s.charAt(i+1)).compareTo(")") == 0){			
			    token = new Token();
			    token.setS("(-)");
			    lista.eliminaUltimo();
			    lista.agrega(token);
			    i++;
			    continue;			    
			}			    
		}else if(c.compareTo("x") == 0){
		    token = new TokenVar();
		    token.setS(c);
		    lista.agrega(token);
		    continue;
		}else if(c.compareTo("s") == 0){
		    if(s.valueOf(s.charAt(i+1)).compareTo("i") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("n") == 0){			
			    token = new TokenFunc();
			    token.setS("sin");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		    if(s.valueOf(s.charAt(i+1)).compareTo("e") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("c") == 0){			
			    token = new TokenFunc();
			    token.setS("sec");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		    if(s.valueOf(s.charAt(i+1)).compareTo("q") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("r") == 0){			
			    token = new TokenFunc();
			    token.setS("sqr");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		}else if(c.compareTo("c") == 0){
		    if(s.valueOf(s.charAt(i+1)).compareTo("o") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("s") == 0){			
			    token = new TokenFunc();
			    token.setS("cos");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}		
		    if(s.valueOf(s.charAt(i+1)).compareTo("s") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("c") == 0){			
			    token = new TokenFunc();
			    token.setS("csc");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		    if(s.valueOf(s.charAt(i+1)).compareTo("o") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("t") == 0){			
			    token = new TokenFunc();
			    token.setS("cot");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}
		}else if(c.compareTo("t") == 0){
		    if(s.valueOf(s.charAt(i+1)).compareTo("a") == 0)
			if(s.valueOf(s.charAt(i+2)).compareTo("n") == 0){			
			    token = new TokenFunc();
			    token.setS("tan");
			    lista.agrega(token);
			    i+=2;
			    continue;
			}		
		}else if(c.compareTo(".") == 0){	    	       
		    int j = 1;
		    try{
			while(true){
			    Double.parseDouble(s.valueOf(s.charAt(i+j)));
			    j++;
			}//while
		    }catch(NumberFormatException nfee){
			token = new TokenNum();
			token.setS(s.substring(i,i+j));
			lista.agrega(token);
			i+=(j-1);
			continue;
		    }catch(StringIndexOutOfBoundsException sioore){
			token = new TokenNum();
			token.setS(s.substring(i,i+j));
			lista.agrega(token);
			i+=(j-1);
			continue;
		    }
		}else if(Character.isDigit(s.charAt(i))){
		    int k = 0;
		    try{
			while(true){
			    if(!Character.isDigit(s.charAt(i+k)) &&  0 != s.valueOf(s.charAt(i+k)).compareTo("."))
				break;
			    k++;
			}//while 
			token = new TokenNum();
			token.setS(s.substring(i,i+k));
			lista.agrega(token);
			i+=(k-1);
			continue;
		    }catch(StringIndexOutOfBoundsException sioore){			
			token = new TokenNum();
			token.setS(s.substring(i,i+k));
			lista.agrega(token);
			i+=(k-1);
			continue;
		    }
		}
	    }catch(NumberFormatException nfe){}	    
	    catch(StringIndexOutOfBoundsException sioore){}
	    return null;
	}//for
	return lista;
    }//divide 
    
    /**
     *  Método privado que recibe una expresion infija y
     *  regresa esa expresión pero ya prefija
     *  @param la cadena infija a transformar
     *  @return text la cadena ya prefija
     */
    
    private String I2P(String infijo){	
        Pila<Character> p1 = Infijo2Prefijo(infijo);
        String text = "";
        while (!p1.esVacia())
            text += p1.saca();
        return text;
 
    }
    
    /**
     *  Método privado que recibe una expresion infija y
     *  regresa una pila para armar la expresion prefija
     *  @param la cadena infija a transformar
     *  @return la pila de ayuda
     */    
    
    private Pila<Character> Infijo2Prefijo(String infijo) {
        infijo = '(' + infijo ;
        int tamaño = infijo.length();
        Pila<Character> PilaDefinitiva = new Pila<Character>();
        Pila<Character> PilaTemp = new Pila<Character>();
        PilaTemp.mete(')'); 
        for (int i = tamaño-1; i > -1; i--) {
            char caracter = infijo.charAt(i);	    
            switch (caracter) {
            case ')':
                PilaTemp.mete(caracter);
		PilaDefinitiva.mete(caracter);
                break;
            case '-':
		if((i == 0) || (infijo.charAt(i-1) == '(') || (infijo.charAt(i-1) == '+') ||
		   (infijo.charAt(i-1) == '-') || (infijo.charAt(i-1) == '*') ||
		   (infijo.charAt(i-1) == '/') || (infijo.charAt(i-1) == '^')){
		    PilaDefinitiva.mete(')');
		    PilaDefinitiva.mete(caracter);
		    PilaDefinitiva.mete('(');
		}else{
                while (Jerarquia(caracter) > Jerarquia(PilaTemp.mira()))
                    PilaDefinitiva.mete(PilaTemp.saca());
                PilaTemp.mete(caracter);
		}
                break;		
            case '+':case '^':case '*':case '/':
                while (Jerarquia(caracter) > Jerarquia(PilaTemp.mira()))
                    PilaDefinitiva.mete(PilaTemp.saca());
                PilaTemp.mete(caracter);
                break;
            case '(':
                while (PilaTemp.mira() != ')')
                    PilaDefinitiva.mete(PilaTemp.saca());
                PilaTemp.saca();
		PilaDefinitiva.mete(caracter);
                break;
            default:
                PilaDefinitiva.mete(caracter);
            }
        }
	PilaDefinitiva.saca();
        return PilaDefinitiva;
    }

    /**
     *  Método privado que recibe un caracter y
     *  nos da la jerarquia correspondiente
     *  @param elemento el caracter al cual queremos catalogar
     *  @return la jerarquia del caracter
     */
 
    private int Jerarquia(char elemento) {
        int r = 0;
        switch (elemento) {
        case ')':
            r = 5; break;
        case '^':
            r = 2; break;
        case '*': case '/':
            r = 3; break;
        case '+': case '-':
            r = 4; break;
        case '(':
            r = 1; break;
        }
        return r;
    }
    
    /**
     *  Método que recibe una expresion que debe de
     *  ser evaluada y regresa el resultado de dicha evaluación 
     *  para una cierta variable x dada
     *  @param s la expresión a evaluar
     *  @param x la variable x
     *  @return el valor de la expresión para ese x o 
     *  NEGATIVE_INFINITY si no es posible evaluarla
     */

    public Double evalua(String s, Double x){
	Double ni = Double.NEGATIVE_INFINITY;
	Lista<Token> lista = divide(s);
	if(!checaParen(lista))return ni;
        lista = aPrefija(lista);
	if(lista == null)return ni;
	Pila<Double> pila = new Pila<Double>();
	Double ret = 0.0;
	Lista<Token> temp = new Lista<Token>();
	for(Token t : lista){
	    if(!(t instanceof TokenParen))
		temp.agregaInicio(t);	    
	}//for each
	lista = temp;
	for(Token t : lista){
	    if(t instanceof TokenNum)
	    	pila.mete(Double.parseDouble(t.escupe()));
	    else if(t instanceof TokenVar){
	    	pila.mete(x);
	    }//else if
	    else if((t instanceof TokenOper) || (t instanceof TokenFunc)){
	    	String cad = t.escupe();
	    	switch (cad) {
	    	case "+":
	    	    pila.mete(pila.saca() + pila.saca());
	    	    break;
	    	case "-":
	    	    pila.mete(pila.saca() - pila.saca());
	    	    break;		    
	    	case "(-)":
	    	    pila.mete(pila.saca()*(-1));
	    	    break;
	    	case "*":
	    	    pila.mete(pila.saca() * pila.saca());
	    	    break;
	    	case "/":
		    Double d = pila.saca();		    
	    	    pila.mete(d / pila.saca());
	    	    break;
	    	case "^":
		    Double d2 = pila.saca();
	    	    pila.mete(Math.pow(d2,pila.saca()));
	    	    break;
	    	case "sin":
	    	    pila.mete(Math.sin(pila.saca()));
	    	    break;
	    	case "cos":
	    	    pila.mete(Math.cos(pila.saca()));
	    	    break;
	    	case "tan":
	    	    pila.mete(Math.tan(pila.saca()));
	    	    break;
	    	case "cot":
	    	    pila.mete(Math.tan(pila.saca()));
	    	    break;
	    	case "sec":
	    	    pila.mete(Math.cos(pila.saca()));
	    	    break;
	    	case "csc":
	    	    pila.mete(Math.sin(pila.saca()));
	    	    break;
	    	case "sqr":
	    	    pila.mete(Math.sqrt(pila.saca()));
	    	}//switch	
	    }//else if
	}//for each
	return pila.saca();	
    }//evalua
        
}//class
