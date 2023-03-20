package twisk.vues;

import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueActiviteIG extends VueEtapeIG{

    HBox boite = new HBox();

    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        getChildren().addAll(getNom(), boite);
        super.relocate(etape.getPosX(), etape.getPosY());
        setStyle("-fx-border-color: #0059FF; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
    }

    @Override
    public void reagir() {

    }
}