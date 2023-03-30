package twisk.vues;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import twisk.mondeIG.MondeIG;

public class VueMenu extends MenuBar implements Observateur{
    private MondeIG monde;
    private MenuItem rename;
    private MenuItem temps;
    private MenuItem ecart;

    public VueMenu(MondeIG monde){
        this.monde = monde;

        Menu fichier = new Menu("Fichier");
        MenuItem quit = new MenuItem("Quitter");
        quit.setOnAction(new EcouteurQuit());
        fichier.getItems().add(quit);

        Menu edition = new Menu("Édition");
        MenuItem suppr = new MenuItem("Supprimer");
        suppr.setOnAction(new EcouteurSuppr(monde));
        rename = new MenuItem("Renommer la séléction");
        rename.setOnAction(new EcouteurRename(monde));
        MenuItem enleve = new MenuItem("Enlever la selection");
        enleve.setOnAction(new EcouteurEnlever(monde));
        edition.getItems().addAll(suppr, rename, enleve);

        Menu world = new Menu("Menu");
        MenuItem entre = new MenuItem("Entréé");
        entre.setOnAction(new EcouteurEntree(monde));
        MenuItem sortie = new MenuItem("Sortie");
        sortie.setOnAction(new EcouteurSortie(monde));
        world.getItems().addAll(entre, sortie);

        Menu para = new Menu("Parametres");
        temps = new MenuItem("Changer temps");
        temps.setOnAction(new EcouteurTemps(monde));
        ecart = new MenuItem("Changer ecart temps");
        ecart.setOnAction(new EcouteurEcart(monde));
        para.getItems().addAll(temps, ecart);

        rename.setDisable(estDisable());
        temps.setDisable(estDisable());
        ecart.setDisable(estDisable());

        this.getMenus().addAll(fichier, edition, world, para);
        monde.ajouterObservateur(this);
    }

    @Override
    public void reagir() {
        rename.setDisable(estDisable());
        temps.setDisable(estDisable());
        ecart.setDisable(estDisable());
    }

    public boolean estDisable(){
        return !(monde.getSelectionEtape().size() == 1);
    }
}
