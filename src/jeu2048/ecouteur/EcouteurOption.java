package jeu2048.ecouteur;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jeu2048.Jeu;

public class EcouteurOption implements EventHandler<ActionEvent> {
    private Jeu jeu ;
    public EcouteurOption(Jeu jeu){
        this.jeu = jeu ;
    }
    public void handle(ActionEvent event){
        System.out.println("option");
        jeu.lanceOption() ;
    }
}