package unam.myp.test;

import org.junit.Assert;
import org.junit.Test;
import unam.myp.Jardinero;
import unam.myp.Lista;
import unam.myp.Token;
import java.util.Random;


/**
 *Clase para puebas unitarias de {@link Jardinero}
 */

public class TestJardinero {

    /**
     *Prueba unitaria para {@link Jardinero#divide}
     */ 

    private Jardinero pedro;
    private Random random;
    private Lista<Token> l;

    /** Crea un jardinero para cada prueba */
    public TestJardinero(){
	pedro = new Jardinero();
	random = new Random();
        l = new Lista<Token>();
    }//Bob
    
    @Test public void testDivide(){
	l = pedro.divide("sin(cos(tan(x*3)))");	
	Assert.assertTrue(l.toString().compareTo("[sin,(,cos,(,tan,(,x,*,3,),),)]") == 0);
	l = pedro.divide("sqr(456.345435/x^sec(x))");	
	Assert.assertTrue(l.toString().compareTo("[sqr,(,456.345435,/,x,^,sec,(,x,),)]") == 0);
	l = pedro.divide("tan(cos(x+lel))");	
	Assert.assertNull(l);	
	l = pedro.divide("cot(sec(csc(x+.123123-4.)))");       
	Assert.assertTrue(l.toString().compareTo("[cot,(,sec,(,csc,(,x,+,.123123,-,4.,),),)]") == 0);
    }

    /**
     *Prueba unitaria para {@link Jardinero#checaParen}
     */  
    @Test public void testChecaParen(){
	Assert.assertTrue(pedro.checaParen(pedro.divide("sin(cos(4+(123.7)))")));
	Assert.assertTrue(!pedro.checaParen(pedro.divide("cos(87162))(()")));
	Assert.assertTrue(!pedro.checaParen(pedro.divide(")()()(()")));
    }

}
