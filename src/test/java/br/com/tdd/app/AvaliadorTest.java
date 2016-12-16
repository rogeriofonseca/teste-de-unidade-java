package br.com.tdd.app;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import java.util.List;
import junit.framework.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AvaliadorTest {

    @Test
    public void testMaiorLance(){
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,250.0));
        leilao.propoe(new Lance(joao,300.0));
        leilao.propoe(new Lance(jose,400.0));

        // Executando a acao do Avaliador
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // compara a saida com o esperado
        double maiorEsperado = 400;
        double menorEsperado = 250;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void testDeveDevolverMediaDosLances(){
        // cenario: 3 lances em ordem crescente
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("José");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,250.0));
        leilao.propoe(new Lance(joao,300.0));
        leilao.propoe(new Lance(jose,400.0));

        // Executando a acao do Avaliador
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        double mediaDeLances = 316.6666666666667;
        assertEquals(mediaDeLances, leiloeiro.getMediaDosLances(leilao), 0.00001);
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance(){

        Usuario rogerio = new Usuario("Rogério");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(rogerio, 1000.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances(){
        Usuario rogerio = new Usuario("Rogério");
        Usuario joao = new Usuario("João");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(rogerio, 100.0));
        leilao.propoe(new Lance(joao, 200.0));
        leilao.propoe(new Lance(rogerio, 300.0));
        leilao.propoe(new Lance(joao, 400.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> maiores = leiloeiro.getTresMaiores();
        assertEquals(3, maiores.size());
        assertEquals(400.0, maiores.get(0).getValor(), 0.00001);
        assertEquals(300.0, maiores.get(1).getValor(), 0.00001);
        assertEquals(200.0, maiores.get(2).getValor(), 0.00001);
    }

    @Test
    public void deveDevolverTodosLancesCasoNaoHajaNoMinimo3() {
        Usuario joao = new Usuario("Rogério"); 
        Usuario maria = new Usuario("Maria"); 
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(maria,450.0));
        leilao.propoe(new Lance(maria,700.0));

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(700.0, leiloeiro.getMaiorLance(), 0.0001);
        assertEquals(450.0, leiloeiro.getMenorLance(), 0.0001);
    }

    @Test
    public void deveDevolverListaVaziaCasoNaoHajaLances() {
        Usuario joao = new Usuario("Rogério"); 
        Usuario maria = new Usuario("Maria"); 
        Leilao leilao = new Leilao("Playstation 3 Novo");

        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(0, leilao.getLances().size());
    }

}
