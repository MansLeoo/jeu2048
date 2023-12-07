package jeu2048.alert;

import javafx.scene.control.Alert;

public class AlertGagnee {


    public AlertGagnee() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Félicitation");
        alert.setHeaderText(null);
        alert.setContentText("Félicitation, Vous avez atteint votre objectif ! ");
        alert.showAndWait();
    }

}
