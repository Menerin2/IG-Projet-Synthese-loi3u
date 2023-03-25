package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
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
        monde.notifierObservateurs();
    }

    public void supprimerTout(MondeIG monde){
        String[] ids = new String[10];
        int cpt = 0;
        for(EtapeIG etape : monde){
            if(monde.getSelectionne().containsKey(etape.getIdentifiant())){
                ids[cpt] = etape.getIdentifiant();
                monde.getSelectionne().remove(etape.getIdentifiant());
                monde.getArcs().removeIf(arc -> arc.isBonneEtape(etape));
                cpt++;
            }
        }
        for(int i = 0; i<cpt; i++){
            monde.getMap().remove(ids[i]);
        }
    }
}
