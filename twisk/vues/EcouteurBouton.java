package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurBouton implements EventHandler {

    private MondeIG monde;

    public EcouteurBouton(MondeIG monde){
        this.monde = monde;
    }

    @Override
    public void handle(Event event) {
        monde.ajouter("Activite");
    }
}
