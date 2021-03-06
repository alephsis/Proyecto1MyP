package unam.myp.test;

import java.util.*;
import org.junit.Assert;
import org.junit.Test;
import unam.myp.Lista;

/**
 *Clase para puebas unitarias de la clase {@link Lista}.
 */
public class TestLista{

    private Random random;
    private int total;
    private Lista<Integer> lista;
    
    /**
     *Crea una lista para cada prueba con elementos aleatorios en
     *rengo entre 10 y 100
     */
    public TestLista(){
	random = new Random();
	total = 10+random.nextInt(90);
	lista = new Lista<Integer>();
    }//Bob

    /**
     *Prueba unitaria para {@link Lista#getLongitud}
     */  
    @Test public void testGetLongitud(){
	for(int i=0;i<total;i++)
	    lista.agrega(random.nextInt(50));
	Assert.assertTrue(lista.getLongitud() == total);
	for (int j=0;j<total/2;j++)
	    lista.eliminaPrimero();
	Assert.assertTrue(lista.getLongitud() == total - total/2);	
    }
    /**
     *Prueba unitaria para {@link Lista#agrega}
     */  
    @Test public void testAgrega(){
	for(int i=0;i<total;i++){
	    int j=random.nextInt(total);
	    lista.agrega(j);
	    Assert.assertTrue(lista.contiene(j));
	    Assert.assertTrue(lista.getLongitud() == i+1);
	}
    }
    /**
     *Prueba unitaria para {@link Lista#agregaInicio}
     */  
    @Test public void testAgregaInicio(){
	for(int i=0;i<total;i++){
	    int j=random.nextInt(total);
	    lista.agregaInicio(j);
	    Assert.assertTrue(lista.get(0) == j);
	    Assert.assertTrue(lista.getLongitud() == i+1);
	}
    }
    /**
     *Prueba unitaria para {@link Lista#Elimina}
     */  
    @Test public void testElimina(){
	for(int i=0;i<total;i++)
	    lista.agrega(i);
	for(int j = total-1;j>=0;j--){
	    lista.elimina(j);
	    Assert.assertTrue(!lista.contiene(j));
	}
	Assert.assertTrue(lista.getLongitud() == 0);
    }

    /**
     *Prueba unitaria para {@link Lista#get}
     */  
    @Test public void testGet(){
	for(int i=0;i<total;i++)
	    lista.agrega(i);
	for(int j=0;j<10;j++){
	    int b =0 ;
	    b = lista.get(random.nextInt(total));
	    Assert.assertTrue(lista.get(b)==b);
	}
	try{
	    lista.get(-1);
	    Assert.fail("Fallaste Miserblemente");
	}catch(IndexOutOfBoundsException ioobe){}
	try{
	    lista.get(total);
	    Assert.fail("Fallaste Miserblemente");
	}catch(IndexOutOfBoundsException ioobe){}	
    }

    /**
     *Prueba unitaria para {@link Lista#contiene}
     */  
    @Test public void testContiene(){
	for(int i=0;i<total;i++)
	    lista.agrega(i);
	for(int j=0;j<10;j++){	 	    
	    Assert.assertTrue(lista.contiene(random.nextInt(total)));
	    Assert.assertTrue(!lista.contiene(total+random.nextInt(total)));
	}	
	
    }

    /**
     *Prueba unitaria para {@link Lista#indiceDe}
     */  
    @Test public void testIndiceDe(){
	for(int i=0;i<total;i++)
	    lista.agrega(i);
	for(int j=0;j<10;j++){
	    int b =0 ;
	    b = lista.get(random.nextInt(total));
	    Assert.assertTrue(lista.indiceDe(b) == b);
	    Assert.assertTrue(lista.indiceDe(b+total) == -1);
	}
    }

    
}//class
