package br.com.tdd.app;

import br.com.caelum.matematica.MatematicaMaluca;
import org.junit.Test;
import static org.junit.Assert.*;

public class MatematicaMalucaTest {
    
    @Test
    public void testContaMaluca(){
        MatematicaMaluca matematica = new MatematicaMaluca();
        
        assertEquals(124, matematica.concaMaluca(31));
        assertEquals(33, matematica.concaMaluca(11));
        assertEquals(10, matematica.concaMaluca(5));
    }
}
