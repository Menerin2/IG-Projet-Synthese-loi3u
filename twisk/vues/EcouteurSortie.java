package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurSortie implements EventHandler {
    private final MondeIG monde;

    public EcouteurSortie(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(Event event) {
        for (EtapeIG etape : monde){
            if(monde.getSelectionEtape().containsKey(etape.getIdentifiant())){
                if(monde.getMapSortie().containsKey(etape.getIdentifiant())){
                    monde.plusSortie(etape);
                    System.out.println("plus");
                }else {
                    monde.estSortie(etape);
                    System.out.println("est");
                }
            }
        }
        monde.deselectionnerTout();
        monde.notifierObservateurs();
    }
}
