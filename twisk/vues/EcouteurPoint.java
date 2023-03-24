package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class EcouteurPoint implements EventHandler {
    private MondeIG monde;
    private PointDeControleIG point;
    public EcouteurPoint(MondeIG monde, PointDeControleIG point){
        this.monde = monde;
        this.point = point;
    }
    @Override
    public void handle(Event event) {
        if(monde.getEstTouche()==1){
            monde.ajouter(monde.getPointClick(), point);
        }
        else{
            monde.estTouche(point);
        }
        monde.notifierObservateurs();
    }
}
