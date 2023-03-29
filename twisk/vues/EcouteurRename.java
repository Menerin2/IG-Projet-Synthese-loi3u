package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurRename implements EventHandler {
    private MondeIG monde;
    public EcouteurRename(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(Event event) {
        if(monde.getSelectionEtape().size()==1) {
            TextInputDialog rename = new TextInputDialog("Renommez votre Etape");
            rename.setHeaderText("Entrez le nom par lequel vous voulez appeler votre Etape");
            rename.setContentText("Nom :");
            Optional<String> result = rename.showAndWait();
            for (EtapeIG etape : monde) {
                if (monde.getSelectionEtape().containsKey(etape.getIdentifiant())) {
                    result.ifPresent(etape::setNom);
                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Vous ne devez sélectionner qu'une seule Etape à la fois");
            alert.setContentText("On ne peut changer le nom de plusieurs Etapes en même temps");
            alert.showAndWait();
        }
        monde.deselectionnerTout();
        monde.notifierObservateurs();
    }
}
