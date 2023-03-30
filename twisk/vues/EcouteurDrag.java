package twisk.vues;

import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

public class EcouteurDrag implements EventHandler<MouseEvent> {
    private final VueEtapeIG vue;

    public EcouteurDrag(VueEtapeIG vue){
        this.vue = vue;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        System.out.println("DnD");
        Dragboard board = vue.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putString(vue.etape.getIdentifiant());
        content.putImage(vue.snapshot(null, null));
        vue.setId(vue.etape.getIdentifiant());
        board.setContent(content);
        mouseEvent.consume();
    }
}
