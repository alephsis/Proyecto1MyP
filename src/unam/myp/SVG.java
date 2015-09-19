package unam.myp;

public class SVG{

    public String dameLinea(double x1, double y1, double x2, double y2, String color){
	return	"<line x1=\""+x1+"\" y1=\""+y1+"\" x2=\""+x2+"\" y2=\""+y2+"\" stroke=\""+color+"\" stroke-width=\"1\" />\n";
    }//dameLinea

    public String dameCirculo(double x,double y,double r,String color){
	return "<circle cx=\"" + x +"\" cy=\"" + y + "\" r=\""+ r +"\"fill=\"" + color  + "\"/>\n";
    }//dameCirculo
    
    public String dameCuadrado(double x,double y,double base,double altura,String color){
	return  "<rect x=\""+x+"\" y=\""+y+
	    "\"width=\""+base+"\"height =\""+altura+"\" fill =\"transparent\" stroke = \"blue\" stroke-width = \"10\"/>\n";
    }//dameCuadrado

}//class SVG
