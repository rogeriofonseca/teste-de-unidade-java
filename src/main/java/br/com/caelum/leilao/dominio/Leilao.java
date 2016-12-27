package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

    private String descricao;
    private List<Lance> lances;

    public Leilao(String descricao) {
        this.descricao = descricao;
        this.lances = new ArrayList<Lance>();
    }

    public void propoe(Lance lance) {
        Usuario usuario = lance.getUsuario();
        if(lances.isEmpty() || podeEfetuarLance(usuario)){
            lances.add(lance);
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Lance> getLances() {
        return Collections.unmodifiableList(lances);
    }

    public Lance ultimoLanceDado(){
        return lances.get(lances.size()-1);
    }

    public boolean podeEfetuarLance(Usuario usuario){
        return (!ultimoLanceDado().getUsuario().equals(usuario) && qtdLancesDo(usuario) < 5);
    }

    public int qtdLancesDo(Usuario usuario){

        int total = 0;
        for(Lance lance : lances){
            if(lance.getUsuario().equals(usuario)) total++;
        }

        return total;
    }
}
