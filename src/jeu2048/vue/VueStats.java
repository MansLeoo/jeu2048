package jeu2048.vue;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import jeu2048.Jeu;

public class VueStats extends BorderPane implements Observateur{
    private Jeu jeu ;
    Label stats ;
    Label obj ;
    public VueStats(Jeu jeu) {
        this.jeu = jeu ;


        this.stats = new Label("Partie Jouées : "+ jeu.getNbPartie() +"          Partie gagnées  : " + jeu.getNbGagnees() );
        this.obj = new Label("Objectif : " + jeu.getObjectif());

        this.stats.setFont(new Font(30));
        this.obj.setFont(new Font(30));

        stats.setStyle("-fx-padding: 0 0 50 0;");
        obj.setStyle("-fx-padding: 0 0 150 850;");
        this.setCenter(stats);
        this.setBottom(obj);
    }
    @Override
    public void reagir() {
        this.stats.setText("Partie Jouées : "+ jeu.getNbPartie() +"          Partie gagnées  : " + jeu.getNbGagnees() );
        this.obj.setText("Objectif : " + jeu.getObjectif());

    }
}
