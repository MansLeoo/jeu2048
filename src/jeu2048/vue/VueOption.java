package jeu2048.vue;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import jeu2048.Jeu;
import jeu2048.ecouteur.EcouteurValider;
import jeu2048.vue.Observateur;

public class VueOption extends BorderPane implements Observateur {
    private Jeu jeu ;
    public VueOption(Jeu jeu){
        this.jeu = jeu ;
        Label obj = new Label("Objectif:");
        TextField textField = new TextField ();
        textField.setText(jeu.getObjectif()+ "");
        textField.setMaxWidth(100);
        Font font = new Font(25) ;
        ObservableList<String> options = FXCollections.observableArrayList("5x5","6x6","7x7","8x8","9x9","10x10");
        obj.setFont(font);

        ComboBox choixTaille = new ComboBox(options);
        choixTaille.setValue("5x5");
        BorderPane topPane = new BorderPane() ;
        HBox centerPane = new HBox() ;
        Label taille = new Label("Taille de la grille :");
        taille.setFont(font);
        choixTaille.setStyle("-fx-font: 15px \"Serif\";");

        topPane.setStyle("-fx-padding: 50 0 0 200;");
        centerPane.setStyle("-fx-padding: 0 0 0 100;");

        topPane.setTop(obj);
        topPane.setBottom(textField);

        centerPane.getChildren().addAll(taille,choixTaille);
        centerPane.setMaxHeight(200) ;
        this.setTop(topPane);
        this.setCenter(centerPane);
        Button valider = new Button("Appliquer") ;
        valider.setOnAction(new EcouteurValider(jeu,textField,choixTaille));
        this.setBottom(valider);
    }

    @Override
    public void reagir() {

    }
}
