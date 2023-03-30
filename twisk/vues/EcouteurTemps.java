package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

import java.util.Optional;

public class EcouteurTemps implements EventHandler {
    private MondeIG monde;
    public EcouteurTemps(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(Event event) {
        if(monde.getSelectionEtape().size()==1) {
            TextInputDialog tps = new TextInputDialog("Changez le temps");
            tps.setHeaderText("Entrez le temps que durera votre Etape");
            tps.setContentText("Temps :");
            Optional<String> result = tps.showAndWait();
            for (EtapeIG etape : monde) {
                if (monde.getSelectionEtape().containsKey(etape.getIdentifiant())) {
                    if(result.isPresent()){
                        String input = result.get();
                        if (input.matches("\\d+")) {
                            etape.setTemps(input);
                        }else{
                            System.out.println("non");
                        }
                    }
                }
            }
        }else{
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Vous ne devez sélectionner qu'une seule Etape à la fois");
            alert.setContentText("On ne peut changer le temps de plusieurs Etapes en même temps");
            alert.showAndWait();
        }
        monde.deselectionnerTout();
        monde.notifierObservateurs();
    }
}
