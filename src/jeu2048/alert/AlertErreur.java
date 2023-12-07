package jeu2048.alert;

import javafx.scene.control.Alert;

public class AlertErreur {

    public AlertErreur(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Valeur Incorect");
        alert.setHeaderText(null);
        alert.setContentText("La valeur rentré dois être composé uniquement de chiffres");
        alert.showAndWait();
    }
}
