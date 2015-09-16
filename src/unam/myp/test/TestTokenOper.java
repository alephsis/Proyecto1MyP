package unam.myp.test;

import org.junit.Assert;
import org.junit.Test;
import unam.myp.TokenOper;

/**
 *Clase para puebas unitarias de la clase {@link TokenOper}.
 */
public class TestTokenOper{

    private TokenOper token;
    
    /** Crea un token para la prueba */
    public TestTokenOper(){
	token = new TokenOper();
    }//Bob

    /**
     *Prueba unitaria para {@link TokenOper#setS}
     */ 
    @Test public void testsetS(){
	token.setS("lel");
	Assert.assertTrue(token.escupe().equals(""));
	token.setS("+");
	Assert.assertTrue(token.escupe().equals("+"));
	token.setS("-");
	Assert.assertTrue(token.escupe().equals("-"));
	token.setS("/");
	Assert.assertTrue(token.escupe().equals("/"));
	token.setS("*");
	Assert.assertTrue(token.escupe().equals("*"));
	token.setS("^");
	Assert.assertTrue(token.escupe().equals("^"));
	token.setS("top kek");
	Assert.assertTrue(token.escupe().equals(""));
    }
}//class
