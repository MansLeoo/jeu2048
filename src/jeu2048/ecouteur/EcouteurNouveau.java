package jeu2048.ecouteur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jeu2048.Jeu;

public class EcouteurNouveau implements EventHandler<ActionEvent> {
    private Jeu jeu ;
    public EcouteurNouveau(Jeu jeu){
       this.jeu = jeu ;
    }
    public void handle(ActionEvent event) {
        jeu.nouveau();


    }
}