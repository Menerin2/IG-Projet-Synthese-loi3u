package twisk.vues;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.TilePane;
import twisk.mondeIG.MondeIG;

public class VueOutils extends TilePane implements Observateur{

    public VueOutils(MondeIG monde){
        Button button = new Button("+");
        button.setPrefSize(20,20);
        button.setOnAction(new EcouteurBouton(monde));
        this.getChildren().add(button);
        Tooltip tooltipActivite = new Tooltip("Ajouter une activite");
        button.setTooltip(tooltipActivite);
        monde.ajouterObservateur(this);
    }

    @Override
    public void reagir(){

    }
}
