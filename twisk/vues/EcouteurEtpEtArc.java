package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class EcouteurEtpEtArc implements EventHandler {

    private MondeIG monde;
    private EtapeIG etape;
    private ArcIG arc;

    public EcouteurEtpEtArc(MondeIG monde, EtapeIG etape){
        this.monde = monde;
        this.etape = etape;
    }

    public EcouteurEtpEtArc(MondeIG monde, ArcIG arc){
        this.monde = monde;
        this.arc = arc;
    }
    @Override
    public void handle(Event event) {
        if(etape == null) {
            if (monde.getSelectionArc().contains(arc)) {
                monde.estDeselectionne(arc);
            } else {
                monde.estSelectionne(arc);
            }
        }else {
            if(monde.getSelectionEtape().containsKey(etape.getIdentifiant())){
                monde.estDeselectionne(etape);
            }else{
                monde.estSelectionne(etape);
            }
        }
        monde.notifierObservateurs();
    }
}
