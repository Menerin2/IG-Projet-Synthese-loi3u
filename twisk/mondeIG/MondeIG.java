package twisk.mondeIG;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MondeIG {

    private Map<String, EtapeIG> map;
    private int cpt = 0;

    public MondeIG(){
        this.map = new HashMap<>();
        EtapeIG etape = new ActiviteIG("Act"+cpt++, 80, 40);
        map.put(etape.getIdentifiant(), etape);
    }

    public void ajouter(String type){
        EtapeIG etape = null;
        switch (type){
            case "Activite" :
                etape = new ActiviteIG("Act"+cpt++, 80, 40);
                break;
        }
        assert etape != null;
        map.put(etape.getIdentifiant(), etape);
    }

}
