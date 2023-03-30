package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;

public class EcouteurEnlever implements EventHandler {

    private final MondeIG monde;

    public EcouteurEnlever(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(Event event) {
        monde.deselectionnerTout();
        monde.notifierObservateurs();
    }
}
