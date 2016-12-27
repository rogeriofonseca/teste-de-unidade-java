package br.com.tdd.app;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class LeilaoTest {

    @Test
    public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario(){
        Leilao leilao = new Leilao("Macbook pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");

        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(steveJobs, 3000));

        assertEquals(1, leilao.getLances().size());
    }

     @Test
    public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
        Leilao leilao = new Leilao("Macbook Pro 15");
        Usuario steveJobs = new Usuario("Steve Jobs");
        Usuario billGates = new Usuario("Bill Gates");

        leilao.propoe(new Lance(steveJobs, 2000));
        leilao.propoe(new Lance(billGates, 3000));
        leilao.propoe(new Lance(steveJobs, 3000));
        leilao.propoe(new Lance(billGates, 3000));
        leilao.propoe(new Lance(steveJobs, 4000));
        leilao.propoe(new Lance(billGates, 3000));
        leilao.propoe(new Lance(steveJobs, 5000));
        leilao.propoe(new Lance(billGates, 3000));
        leilao.propoe(new Lance(steveJobs, 6000));
        leilao.propoe(new Lance(billGates, 999));
        leilao.propoe(new Lance(steveJobs, 7000));

        assertEquals(10, leilao.getLances().size());
        int ultimo = leilao.getLances().size() -1;
        assertEquals(999, leilao.getLances().get(ultimo).getValor(), 0.00001);
    }
}
