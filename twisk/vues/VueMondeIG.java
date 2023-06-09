package twisk.vues;

import javafx.scene.layout.Pane;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class VueMondeIG extends Pane implements Observateur{

    private final MondeIG monde;

    public VueMondeIG(MondeIG monde){
        this.monde = monde;
        for (EtapeIG etape : monde){
            VueEtapeIG vue = new VueActiviteIG(this.monde, etape);
            getChildren().add(vue);
            for(PointDeControleIG point : etape.getPoints()){
                VuePointDeControleIG vuePoint = new VuePointDeControleIG(monde, point);
                getChildren().add(vuePoint);
            }
        }
        this.setOnDragOver(new EcouteurDragOver(monde));
        this.setOnDragDropped(new EcouteurDragDrop(monde));
        monde.ajouterObservateur(this);
    }
    @Override
    public void reagir() {
        getChildren().clear();
        for(ArcIG arc : monde.getArcs()){
            VueArcIG vueArc = new VueArcIG(monde, arc);
            getChildren().add(vueArc);
        }
        for(EtapeIG etape : monde){
            VueEtapeIG vue = new VueActiviteIG(this.monde, etape);
            getChildren().add(vue);
            for(PointDeControleIG point : etape.getPoints()){
                VuePointDeControleIG vuePoint = new VuePointDeControleIG(monde, point);
                getChildren().add(vuePoint);
            }
        }
    }

    public MondeIG getMonde(){
        return this.monde;
    }
}
