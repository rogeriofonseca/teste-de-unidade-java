package br.com.tdd.app;

import br.com.caelum.leilao.dominio.Palindromo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class PalindromoTest {
    
    @Test
    public void testEhPalindromo(){

        Palindromo palindromo = new Palindromo();
        String frase = "raar";
        assertTrue(palindromo.ehPalindromo(frase));
    }

    @Test
    public void deveIdentificarPalindromoEFiltrarCaracteresInvalidos() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
            "Socorram-me subi no onibus em Marrocos");
        assertTrue(resultado);
    }

    @Test
    public void deveIdentificarPalindromo() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
            "Anotaram a data da maratona");
        assertTrue(resultado);
    }

    @Test
    public void deveIdentificarSeNaoEhPalindromo() {
        Palindromo p = new Palindromo();

        boolean resultado = p.ehPalindromo(
            "E preciso amar as pessoas como se nao houvesse amanha");
        assertFalse(resultado);
    }
}
