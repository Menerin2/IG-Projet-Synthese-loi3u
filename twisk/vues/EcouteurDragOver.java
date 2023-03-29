package twisk.vues;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import twisk.mondeIG.MondeIG;

public class EcouteurDragOver implements EventHandler<DragEvent> {

    private MondeIG monde;
    public EcouteurDragOver(MondeIG monde){
        this.monde = monde;
    }
    @Override
    public void handle(DragEvent dragEvent) {
        if (dragEvent.getGestureSource() != monde && dragEvent.getDragboard().hasImage()){
            dragEvent.acceptTransferModes(TransferMode.MOVE);
        }
        dragEvent.consume();
    }
}
