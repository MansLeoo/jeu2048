package jeu2048.ecouteur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import jeu2048.Jeu;

import java.util.Random;

import static java.lang.Math.pow;

public class EcouteurCase implements EventHandler<ActionEvent> {
    private int lig;
    private int col;
    private Jeu jeu ;
    public EcouteurCase(Jeu jeu ,int lig, int col) {
        this.jeu = jeu ;
        this.lig = lig ;
        this.col = col ;
    }

    public void handle(ActionEvent event) {
        jeu.jouer(this.lig,this.col);
    }


}