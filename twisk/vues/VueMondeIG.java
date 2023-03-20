package twisk.vues;

import javafx.scene.layout.Pane;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class VueMondeIG extends Pane implements Observateur{

    private MondeIG monde;

    public VueMondeIG(MondeIG monde){
        this.monde = monde;
        for (EtapeIG etape : monde){
            VueEtapeIG vue = new VueActiviteIG(this.monde, etape);
            getChildren().add(vue);
        }
        monde.ajouterObservateur(this);
    }
    @Override
    public void reagir() {
        getChildren().clear();
        for(EtapeIG etape : monde){
            VueEtapeIG vue = new VueActiviteIG(this.monde, etape);
            getChildren().add(vue);
        }
    }

    public MondeIG getMonde(){
        return this.monde;
    }
}
