package unam.myp;

import javax.swing.JOptionPane;
import java.io.*;

/**
 * Clase que hace la página que muestra el SVG 
 * con la página
 */

public class Main {
 
    public static BufferedWriter bw;    

    /**
     * Método main que pide la entrada y genera la pagina
     */
    
    public static void main(String[] args) {
        String text = JOptionPane.showInputDialog("Dame la expresión:");	
	creaPag(text);
    }    

    /**
     * Método que imprime que hubo un error al leer
     */
    
    private static void error(){	
	System.err.println("\nFormato incorrecto");
	System.exit(0);
    }
        
    /**
     * Método que hace todo el trabajo de crear la pagina
     * @param exp la expresion a graficar
     */
    
    public static void creaPag(String exp){
	SVG svg =new SVG();
	Jardinero j = new Jardinero();
	try{
	    creaArchivo("index.html");
	    escribe(
		    "<!DOCTYPE html>\n" +
		    "<html>\n" +
		    "<head>\n" +
		    "<title>Pagina chingona</title>\n" +
		    "<meta http-equiv=\"Content-Type\" content=\"text/html;charset=utf-8\" >\n" +
		    "</head>\n" +
		    "<body>\n" +
		    "<svg width=\"1000\" height=\"1000\">");	    
	    for(Double i = -400.0; i<400 ; i+= 0.01){
		if((500 - j.evalua(exp,i))>100 && (500 - j.evalua(exp,i))<900)
		    escribe(svg.dameCirculo(i+500,500 - j.evalua(exp,i) ,0.5,"black"));
	    }//for
	    escribe(svg.dameCuadrado(100,100,800,800,"red"));
	    escribe(svg.dameLinea(100,500,900,500,"blue"));
	    escribe(svg.dameLinea(500,100,500,900,"blue"));
	    escribe(
		    "</svg>" +
		    "</body>\n" +
		    "</html>");
	    cierra();	    
	}catch(IOException e){
	    System.out.println(e.getMessage());
	    error();
	}//try-catch
    }//creaPag               
    
    /**
     * Método que crea el archivo a escribir
     * @param la ruta que por defecto el la raíz
     */
    
    public static void creaArchivo(String ruta) throws IOException {    
	File archivo = new File(ruta);
	if(archivo.exists()) {	
	    bw = new BufferedWriter(new FileWriter(archivo));
	    System.out.println("El fichero de texto ya estaba creado"
			       + " y está siendo sobreescrito");
	} else {
	    bw = new BufferedWriter(new FileWriter(archivo));
	    System.out.println("La página está siendo creada por favor espera");
	}
	        
    }//creaArchivo
    
    /**
     * Escribe en el archivo
     * @param aEscribir la cadena a escribir
     */
    
    public static void escribe(String aEscribir) throws IOException {    	
	bw.write(aEscribir);//para escribir en el archivo  
	bw.newLine();	
    }//escribe            

    /** Cierra el BufferedWriter */
    
    public static void cierra() throws IOException {
	bw.close();	
    }       
    
}//main

