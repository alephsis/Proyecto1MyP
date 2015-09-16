package unam.myp.test;

import org.junit.Assert;
import org.junit.Test;
import unam.myp.TokenVar;

/**
 *Clase para puebas unitarias de la clase {@link TokenVar}.
 */
public class TestTokenVar{

    private TokenVar token;
    
    /** Crea un token para la prueba */
    public TestTokenVar(){
	token = new TokenVar();
    }//Bob

    /**
     *Prueba unitaria para {@link TokenVar#setS}
     */ 
    @Test public void testsetS(){
	token.setS("lel");
	Assert.assertTrue(token.escupe().equals(""));
	token.setS("x");
	Assert.assertTrue(token.escupe().equals("x"));
	token.setS("top kek");
	Assert.assertTrue(token.escupe().equals(""));
    }
}//class
