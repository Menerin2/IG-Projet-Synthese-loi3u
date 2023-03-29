package twisk.vues;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import twisk.mondeIG.MondeIG;

import java.awt.*;

public class VueMenu extends MenuBar implements Observateur{

    private MondeIG monde;

    public VueMenu(MondeIG monde){
        this.monde = monde;

        Menu fichier = new Menu("Fichier");
        MenuItem quit = new MenuItem("Quitter");
        quit.setOnAction(new EcouteurQuit());
        fichier.getItems().add(quit);

        Menu edition = new Menu("Édition");
        MenuItem suppr = new MenuItem("Supprimer");
        suppr.setOnAction(new EcouteurSuppr(monde));
        MenuItem rename = new MenuItem("Renommer la séléction");
        rename.setOnAction(new EcouteurRename(monde));
        MenuItem enleve = new MenuItem("Enlever la selection");
        enleve.setOnAction(new EcouteurEnlever(monde));
        edition.getItems().addAll(suppr, rename, enleve);

        this.getMenus().addAll(fichier, edition);
    }

    @Override
    public void reagir() {

    }
}
