package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.shape.Arc;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurSuppr implements EventHandler {
    private MondeIG monde;
    public EcouteurSuppr(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(Event event) {
        supprimerTout(monde);
        monde.deselectionnerTout();
        monde.notifierObservateurs();
    }

    public void supprimerTout(MondeIG monde){
        String[] ids = new String[10];
        int cpt = 0;
        for(EtapeIG etape : monde){
            if(monde.getSelectionEtape().containsKey(etape.getIdentifiant())){
                ids[cpt] = etape.getIdentifiant();
                monde.getSelectionEtape().remove(etape.getIdentifiant());
                monde.getArcs().removeIf(arc -> arc.isBonneEtape(etape));
                cpt++;
            }
        }
        for(int i = 0; i<cpt; i++){
            monde.getMap().remove(ids[i]);
        }
        for(ArcIG arc : monde.getSelectionArc()){
            monde.getArcs().remove(arc);
        }
    }
}
