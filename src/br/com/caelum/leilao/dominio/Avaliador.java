package br.com.caelum.leilao.dominio;

public class Avaliador {
    
    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    
    public void avalia(Leilao leilao){
        if(lance.getValor() > maiorDeTodos) maiorDeTodos = lance.getValor();
        if(lance.getValor() < menorDeTodos) menorDeTodos = lance.getValor();
    }
    
    public double getMaiorLance() { return maiorDeTodos; }
    public double getMenorLance() { return menorDeTodos; }
    
}
