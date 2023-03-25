package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurEtape implements EventHandler {

    private MondeIG monde;
    private EtapeIG etape;

    public EcouteurEtape(MondeIG monde, EtapeIG etape){
        this.monde = monde;
        this.etape = etape;
    }
    @Override
    public void handle(Event event) {
        if(monde.getSelectionne().containsKey(etape.getIdentifiant())){
            monde.estDeselectionne(etape);
        }else{
            monde.estSelectionne(etape);
        }
        monde.notifierObservateurs();
    }
}
