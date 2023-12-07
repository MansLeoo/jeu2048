package jeu2048.ecouteur;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jeu2048.Jeu;
import jeu2048.alert.AlertErreur;

public class EcouteurValider implements EventHandler<ActionEvent> {
    private Jeu jeu ;
    private TextField textField ;
    private ComboBox taille ;
    public EcouteurValider( Jeu jeu,TextField textField,ComboBox taille) {
        this.jeu = jeu ;
        this.textField = textField ;
        this.taille = taille ;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        int e  = 1000;
        System.out.println(this.taille);
        String objectif = this.textField.getText() ;
        try  {
             e = Integer.parseInt(objectif);
            jeu.setObjectif(e);
        } catch (NumberFormatException ex) {
            AlertErreur alert = new AlertErreur() ;
            jeu.setObjectif(2048);
        }
        String[] tab = new String[2] ;
        tab = taille.getValue().toString().split("x");
        jeu.setSize(Integer.parseInt(tab[0]),Integer.parseInt(tab[1]));
        jeu.nouveau();
        jeu.notifierObservateur();

         Node source = (Node) actionEvent.getSource();
         Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
}
