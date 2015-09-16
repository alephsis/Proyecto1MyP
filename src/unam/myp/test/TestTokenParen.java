package unam.myp.test;

import org.junit.Assert;
import org.junit.Test;
import unam.myp.TokenParen;

/**
 *Clase para puebas unitarias de la clase {@link TokenParen}.
 */
public class TestTokenParen{

    private TokenParen token;
    
    /** Crea un token para la prueba */
    public TestTokenParen(){
	token = new TokenParen();
    }//Bob

    /**
     *Prueba unitaria para {@link TokenParen#setS}
     */ 
    @Test public void testsetS(){
	token.setS("lel");
	Assert.assertTrue(token.escupe().equals(""));
	token.setS("(");
	Assert.assertTrue(token.escupe().equals("("));
	token.setS(")");
	Assert.assertTrue(token.escupe().equals(")"));
	token.setS("top kek");
	Assert.assertTrue(token.escupe().equals(""));
    }
}//class
