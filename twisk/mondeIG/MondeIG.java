package twisk.mondeIG;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG>{

    private Map<String, EtapeIG> map;
    private int cpt = 0;

    public MondeIG(){
        this.map = new HashMap<>();
        EtapeIG etape = new ActiviteIG("Act"+cpt++);
        map.put(etape.getIdentifiant(), etape);
    }

    public void ajouter(String type){
        EtapeIG etape = null;
        switch (type){
            case "Activite" :
                etape = new ActiviteIG("Act"+cpt++);
                break;
        }
        assert etape != null;
        map.put(etape.getIdentifiant(), etape);
        notifierObservateurs();
    }

    public Map<String, EtapeIG> getMap(){
        return map;
    }

    public int getCpt(){
        return cpt;
    }

    @Override
    public Iterator iterator() {
        return getMap().values().iterator();
    }
}
