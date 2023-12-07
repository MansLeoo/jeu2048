package jeu2048;

import jeu2048.vue.Observateur;

import java.util.ArrayList;

public class SujetObserve {
    private ArrayList<Observateur> list ;
    public SujetObserve(){
        this.list = new ArrayList<>() ;
    }
    public void ajouterObservateur(Observateur obs){
        this.list.add(obs) ;
    }
    public void notifierObservateur(){
        for (Observateur obs : this.list){
            obs.reagir() ;
        }
    }
}
