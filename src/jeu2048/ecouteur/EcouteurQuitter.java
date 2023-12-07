package jeu2048.ecouteur;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EcouteurQuitter implements EventHandler<ActionEvent> {

    public void handle(ActionEvent event){
        Platform.exit();
    }
}
