package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurEntree implements EventHandler {
    private final MondeIG monde;
    public EcouteurEntree(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(Event event) {
        for (EtapeIG etape : monde){
            if(monde.getSelectionEtape().containsKey(etape.getIdentifiant())){
                if(monde.getMapEntree().containsKey(etape.getIdentifiant())){
                    monde.plusEntree(etape);
                    System.out.println("plus");
                }else {
                    monde.estEntree(etape);
                    System.out.println("est");
                }
            }
        }
        monde.deselectionnerTout();
        monde.notifierObservateurs();
    }
}
