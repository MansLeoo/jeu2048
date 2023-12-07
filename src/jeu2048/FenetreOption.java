package jeu2048;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import jeu2048.vue.VueOption;

public class FenetreOption  {
    public FenetreOption(Jeu jeu){
        BorderPane border = new BorderPane() ;
        Stage fenOpt = new Stage() ;
        fenOpt.setTitle("Options");
        Scene opt = new Scene(border,500,500);
        border.setCenter(new VueOption(jeu));
        fenOpt.setScene(opt);
        fenOpt.show();

    }

}
