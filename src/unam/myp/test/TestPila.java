package unam.myp.test;

import unam.myp.Pila;
import java.util.Random;
import org.junit.Assert;
import org.junit.Test;
import java.util.NoSuchElementException;

/**
 *Clase para puebas unitarias de la clase {@link Pila}.
 */
public class TestPila{

    private Pila<Integer> pila;
    private Random random;
    private int total;
    
    /** 
     *  Construye una pila para cada prueba 
     *  con un número de elementos entre 10 y 99
     */
    
    public TestPila(){
	pila = new Pila<Integer>();
	random = new Random();
	total = 10 + random.nextInt(90);
    }//Bob
    
    /**
     *Prueba unitaria para {@link Pila#mete}
     */  
    @Test public void testMete(){
	for(int i = 0;i<total;i++)
	    pila.mete(i);	    	
	Assert.assertTrue(pila.elementos == total);
	for(int i = total - 1;i>=0;i--)
	    Assert.assertTrue(pila.saca() == i);
	Assert.assertTrue(pila.esVacia());
    }

    /**
     *Prueba unitaria para {@link Pila#saca}
     */  
    @Test public void testSaca(){
        try {
            pila.saca();
            Assert.fail();
        } catch (NoSuchElementException nsee) {}
        for (int i = 0; i < total; i++) 
	    pila.mete(i);        	
	for(int i = total - 1;!pila.esVacia();i--)
	    Assert.assertTrue(pila.saca() == i);
    }

    /**
     *Prueba unitaria para {@link Pila#mira}
     */  
    @Test public void testMira(){
	try{
	    pila.mira();
	    Assert.fail("Falaste miserablemente");
	}catch(NoSuchElementException nsee){}
	for(int i  = 0 ;i<total;i++){
	    pila.mete(i);
	    Assert.assertTrue(pila.mira() == i);
	}//for
    }
 
    /**
     *Prueba unitaria para {@link Pila#esVacia}
     */  
    @Test public void testEsVacia(){
	Assert.assertTrue(pila.esVacia());
	pila.mete(random.nextInt(total));
	Assert.assertTrue(!pila.esVacia());
	pila.saca();
	Assert.assertTrue(pila.esVacia());
    }
    
}//class
