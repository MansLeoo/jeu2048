package jeu2048.vue;

import javafx.application.Platform;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import jeu2048.Jeu;
import jeu2048.ecouteur.EcouteurNouveau;
import jeu2048.ecouteur.EcouteurOption;
import jeu2048.ecouteur.EcouteurQuitter;

public class VueMenu extends MenuBar implements Observateur{
    private Jeu jeu ;
    public VueMenu(Jeu jeu){
        super();
        Menu menu = new Menu("Jeu");
        this.jeu = jeu ;
        MenuItem nouveau = new MenuItem("Nouveau ") ;
        MenuItem quitter = new MenuItem("Quitter ") ;
        MenuItem option = new MenuItem("Options ") ;

        nouveau.setAccelerator( KeyCombination.keyCombination("Ctrl+N"));
        quitter.setAccelerator( KeyCombination.keyCombination("Ctrl+Q"));
        option.setAccelerator( KeyCombination.keyCombination("Ctrl+O"));

        quitter.setOnAction(new EcouteurQuitter());
        nouveau.setOnAction(new EcouteurNouveau(jeu));
        option.setOnAction(new EcouteurOption(jeu));
        menu.getItems().addAll(nouveau,quitter,option) ;
        this.getMenus().add(menu) ;
    }
    @Override
    public void reagir() {

    }
}
