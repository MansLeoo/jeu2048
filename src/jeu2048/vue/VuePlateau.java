package jeu2048.vue;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import jeu2048.Jeu;
import jeu2048.ecouteur.EcouteurCase;


import java.util.Random;

import static java.lang.Math.pow;

public class VuePlateau extends GridPane implements Observateur {
    private Button plateau[][];
    private Jeu jeu ;
    public VuePlateau(Jeu jeu) {

        this.jeu = jeu ;
        this.reagir();
    }

    @Override
    public void reagir() {
        this.getChildren().clear();
        this.setStyle("-fx-background-color: lightgray; -fx-border-color: black;");
        this.setMaxHeight(90*jeu.getLig()-10);
        this.setMaxWidth(jeu.getCol()*90-10);
        this.setHgap(10);
        this.setVgap(10);
        DropShadow shadow = new DropShadow() ;
        this.plateau = new Button[jeu.getLig()][jeu.getCol()] ;
        for (int i = 0; i < jeu.getLig(); i++) {
            for (int j = 0; j < jeu.getCol(); j++) {
                Button b = new Button(""+ jeu.getCase(i,j)) ;
                b.setOnAction(new EcouteurCase(jeu,i,j));
                b.setPrefSize(80,80);
                b.setEffect(shadow);
                b.setStyle(" -fx-border-color:  #FEFEFE; -fx-text-fill: #FEFEFE");
                b.setText(""+jeu.getCase(i,j));
                applyColor(b,jeu.getCase(i,j));
                this.add(b,j,i) ;

            }
        }
    }
    public void applyColor(Button b , int i){
        String color = "" ;
        if ( i < 10){
            color = "#FFDAB9" ;
        }
        else if(i < 100){
            color = "#FFA07A" ;
        } else if (i < 1000) {
            color ="#FF8C00" ;
        }else{
            color = "#FF4500" ;
        }
        b.setStyle("-fx-background-color:" + color + ";");
    }
}