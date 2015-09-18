package unam.myp.test;

import org.junit.Assert;
import org.junit.Test;
import unam.myp.TokenFunc;

/**
 *Clase para puebas unitarias de la clase {@link TokenFunc}.
 */
public class TestTokenFunc{

    private TokenFunc token;
    
    /** Crea un token para la prueba */
    public TestTokenFunc(){
	token = new TokenFunc();
    }//Bob

    /**
     *Prueba unitaria para {@link TokenFunc#setS}
     */ 
    @Test public void testsetS(){
	token.setS("lel");
	Assert.assertTrue(token.escupe().equals(""));
	token.setS("sin");
	Assert.assertTrue(token.escupe().equals("sin"));
	token.setS("cos");
	Assert.assertTrue(token.escupe().equals("cos"));
	token.setS("tan");
	Assert.assertTrue(token.escupe().equals("tan"));
	token.setS("sec");
	Assert.assertTrue(token.escupe().equals("sec"));
	token.setS("csc");
	Assert.assertTrue(token.escupe().equals("csc"));
	token.setS("cot");
	Assert.assertTrue(token.escupe().equals("cot"));
	token.setS("sqr");
	Assert.assertTrue(token.escupe().equals("sqr"));
	token.setS("top kek");
	Assert.assertTrue(token.escupe().equals(""));
    }
}//class
