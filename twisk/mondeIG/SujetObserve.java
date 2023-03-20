package twisk.mondeIG;

import twisk.vues.Observateur;

import java.util.ArrayList;

public class SujetObserve {

    private final ArrayList<Observateur> obs = new ArrayList<>();

    public SujetObserve(){

    }

    public void ajouterObservateur(Observateur v){
        obs.add(v);
    }

    void notifierObservateurs(){
        for(Observateur ob : obs){
            ob.reagir();
        }
    }
}
