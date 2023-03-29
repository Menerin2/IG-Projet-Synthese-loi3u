package twisk.vues;

import javafx.scene.layout.HBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;
import twisk.outils.TailleComposants;

public class VueActiviteIG extends VueEtapeIG{

    HBox boite = new HBox();

    public VueActiviteIG(MondeIG monde, EtapeIG etape) {
        super(monde, etape);
        TailleComposants constantes = new TailleComposants();
        getChildren().addAll(getNom(), boite);
        super.relocate(etape.getPosX(), etape.getPosY());
        this.setPrefSize(constantes.activiteLargeur(), constantes.activiteHauteur());
        boite.setPrefSize(constantes.boxLargeur(), constantes.boxHauteur());
        boite.setStyle("-fx-border-color: #0059FF; -fx-background-insets: 0 0 -1 0, 0, 1, 2; -fx-background-radius: 3px, 3px, 2px, 1px;");
        if(monde.getSelectionEtape().containsKey(etape.getIdentifiant())){
            this.setStyle("-fx-background-color: #8e91c8;");
        }else{
            this.setStyle("-fx-background-color: #ffffff;");
        }
        this.setOnMouseClicked(new EcouteurEtpEtArc(monde, etape));
    }

    @Override
    public void reagir() {

    }
}