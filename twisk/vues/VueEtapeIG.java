package twisk.vues;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;


public abstract class VueEtapeIG extends VBox implements Observateur{

    private MondeIG monde;
    protected EtapeIG etape;
    private Label nom;

    public VueEtapeIG(MondeIG monde, EtapeIG etape){
        this.monde = monde;
        this.etape = etape;
        this.nom = new Label(etape.getNom() + " : "+etape.getTemps() + " + " +etape.getEcartTemps() +" temps");
        this.setOnDragDetected(new EcouteurDrag(this));
    }

    public MondeIG getMonde() {
        return monde;
    }

    public void setMonde(MondeIG monde) {
        this.monde = monde;
    }

    public EtapeIG getEtape() {
        return etape;
    }

    public void setEtape(EtapeIG etape) {
        this.etape = etape;
    }

    public Label getNom() {
        return nom;
    }

    public void setNom(Label nom) {
        this.nom = nom;
    }
}
