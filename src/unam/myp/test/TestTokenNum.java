package unam.myp.test;

import org.junit.Assert;
import org.junit.Test;
import unam.myp.TokenNum;

/**
 *Clase para puebas unitarias de la clase {@link TokenNum}.
 */
public class TestTokenNum{

    private TokenNum token;
    
    /** Crea un token para la prueba */
    public TestTokenNum(){
	token = new TokenNum();
    }//Bob

    /**
     *Prueba unitaria para {@link TokenNum#setS}
     */ 
    @Test public void testsetS(){
	token.setS("lel");
	Assert.assertTrue(token.escupe().equals(""));
	token.setS("5");
	Assert.assertTrue(token.escupe().equals("5"));
	token.setS("80.");
	Assert.assertTrue(token.escupe().equals("80."));
	token.setS("2.6");
	Assert.assertTrue(token.escupe().equals("2.6"));
	token.setS(".7");
	Assert.assertTrue(token.escupe().equals(".7"));
	token.setS("top kek");
	Assert.assertTrue(token.escupe().equals(""));
    }
}//class
