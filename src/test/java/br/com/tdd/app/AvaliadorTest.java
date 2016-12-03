package br.com.tdd.app;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.Assert;
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
        
        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.00001);
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.00001);
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
        Assert.assertEquals(mediaDeLances, leiloeiro.getMediaDosLances(leilao), 0.00001);
    }
}
