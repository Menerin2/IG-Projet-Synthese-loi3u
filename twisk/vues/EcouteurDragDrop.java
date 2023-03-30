package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.mondeIG.PointDeControleIG;
import twisk.outils.TailleComposants;

public class EcouteurDragDrop implements EventHandler<DragEvent> {
    private final MondeIG monde;

    public EcouteurDragDrop(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard board = dragEvent.getDragboard();
        EtapeIG etape = monde.getMap().get(board.getString());
        etape.setPosX(truePosX(dragEvent.getX()));
        etape.setPosY(truePosY(dragEvent.getY()));
        bougerPoints(etape);
        dragEvent.setDropCompleted(true);
        dragEvent.consume();
        monde.notifierObservateurs();
    }

    private double truePosX(double posX){
        TailleComposants var = new TailleComposants();
        return posX-var.activiteLargeur()/2;
    }

    private double truePosY(double posY){
        TailleComposants var = new TailleComposants();
        return posY-var.activiteHauteur()/2;
    }

    private void bougerPoints(EtapeIG etape){
        int cpt=1;
        for (PointDeControleIG point : etape.getPoints()){
            point.bougerPoint(cpt);
            cpt++;
        }
    }
}
