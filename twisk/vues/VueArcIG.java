package twisk.vues;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.MondeIG;

public class VueArcIG extends Pane implements Observateur{

    private final Line line = new Line();

    public VueArcIG(MondeIG monde, ArcIG arc){
        line.setStartX(arc.getPoints()[0].getPos()[0]);
        line.setStartY(arc.getPoints()[0].getPos()[1]);
        line.setEndX(arc.getPoints()[1].getPos()[0]);
        line.setEndY(arc.getPoints()[1].getPos()[1]);
        Polyline polyline = makeArrow();
        this.getChildren().addAll(line, polyline);
        if(monde.getSelectionArc().contains(arc)){
            line.setStyle("-fx-stroke: #8e91c8;");
            polyline.setStyle("-fx-stroke: #8e91c8;");
        }else{
            line.setStyle("-fx-stroke: #000000;");
            polyline.setStyle("-fx-stroke: #000000;");
        }

        polyline.setOnMouseClicked(new EcouteurEtpEtArc(monde, arc));
    }


    private Polyline makeArrow() {
        double sx = line.getStartX();
        double sy = line.getStartY();
        double ex = line.getEndX();
        double ey = line.getEndY();
        double lineAngle = Math.atan((sy - ey) / (sx - ex));
        double arrowAngle = sx > ex ? Math.toRadians(35) : -Math.toRadians(215);
        double length = 20;
        double gx = (ex + length * Math.cos(lineAngle - arrowAngle));
        double gy = (ey + length * Math.sin(lineAngle - arrowAngle));
        double dx = (ex + length * Math.cos(lineAngle + arrowAngle));
        double dy = (ey + length * Math.sin(lineAngle + arrowAngle));
        return new Polyline(ex, ey, dx, dy, gx, gy, ex, ey);
    }

    @Override
    public void reagir() {

    }
}
