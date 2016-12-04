package br.com.caelum.leilao.dominio;

public class Palindromo {
    
    public boolean ehPalindromo(String frase) {
        
        String fraseFiltrada = frase
                .toUpperCase().replace(" ", "").replace("-", "");
        int tamanhoDaFrase = fraseFiltrada.length()-1;
        for(int i = 0; i < tamanhoDaFrase; i++) {
            if(fraseFiltrada.charAt(i) != fraseFiltrada.charAt(tamanhoDaFrase -i)) {
                return false;
            }
        }
        
        return true;
    }
}