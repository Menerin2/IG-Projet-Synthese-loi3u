package twisk.vues;

import javafx.scene.shape.Circle;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;

public class VuePointDeControleIG extends Circle implements Observateur{

    public VuePointDeControleIG(PointDeControleIG point){
        this.setCenterX(point.getPos()[0]);
        this.setCenterY(point.getPos()[1]);
        this.setRadius(5);
    }
    @Override
    public void reagir() {

    }
}
