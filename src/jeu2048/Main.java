package jeu2048;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import jeu2048.vue.VueMenu;
import jeu2048.vue.VuePlateau;
import jeu2048.vue.VueStats;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("jeu2048.Jeu-2048");
        BorderPane root = new BorderPane() ;

        Jeu jeu = new Jeu(5,5,2048) ;
        jeu.nouveau();
        VuePlateau plateau = new VuePlateau(jeu) ;
        VueMenu menu = new VueMenu(jeu);
        VueStats stats = new VueStats(jeu);
        root.setCenter(plateau) ;
        root.setTop(menu);
        root.setBottom(stats);
        jeu.ajouterObservateur(plateau);
        jeu.ajouterObservateur(menu);
        jeu.ajouterObservateur(stats);
        Scene mainScen = new Scene(root, 1920, 1080);
        primaryStage.setScene(mainScen);

        primaryStage.show();



    }

    public static void main(String[] args) {
        launch(args);
    }

}