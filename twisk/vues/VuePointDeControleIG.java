package twisk.vues;

import javafx.scene.shape.Circle;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class VuePointDeControleIG extends Circle implements Observateur{

    private MondeIG monde;

    public VuePointDeControleIG(MondeIG monde, PointDeControleIG point){
        this.monde = monde;
        this.setCenterX(point.getPos()[0]);
        this.setCenterY(point.getPos()[1]);
        this.setRadius(5);
        this.setOnMouseClicked(new EcouteurPoint(monde, point));
    }

    @Override
    public void reagir() {

    }
}
