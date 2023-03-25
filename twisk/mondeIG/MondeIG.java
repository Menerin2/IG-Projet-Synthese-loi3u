package twisk.mondeIG;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MondeIG extends SujetObserve implements Iterable<EtapeIG>{

    private Map<String, EtapeIG> map;
    private Map<String, EtapeIG> selectionne;

    private ArrayList<ArcIG> arcs = new ArrayList<>(10);
    private int cpt = 0;
    private PointDeControleIG pointClick;
    private int estTouche;

    public MondeIG(){
        this.map = new HashMap<>();
        this.selectionne = new HashMap<>();
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

    public void ajouter(PointDeControleIG pt1, PointDeControleIG pt2){
        ArcIG arc = new ArcIG(pt1, pt2);
        if(testValiditeArc(arc)){
        } else {
            arcs.add(arc);
        }
        setEstTouche(0);
    }
    public boolean isEqual(EtapeIG etape1, EtapeIG etape2){
        return etape1.getIdentifiant().equals(etape2.getIdentifiant());
    }
    public boolean testValiditeArc(ArcIG arc){
        if(isEqual(arc.getPoints()[0].getEtape(), arc.getPoints()[1].getEtape())){
            return true;
        }
        return false;
    }
    public void estSelectionne(EtapeIG etape){
        selectionne.put(etape.getIdentifiant(), etape);
    }

    public void estDeselectionne(EtapeIG etape){
        selectionne.remove(etape.getIdentifiant());
    }

    public Map<String, EtapeIG> getMap(){
        return map;
    }

    public int getCpt(){
        return cpt;
    }

    public ArrayList<ArcIG> getArcs() {
        return arcs;
    }

    public int getEstTouche() {
        return estTouche;
    }

    public void setEstTouche(int estTouche) {
        this.estTouche = estTouche;
    }

    public PointDeControleIG getPointClick() {
        return pointClick;
    }

    public void setPointClick(PointDeControleIG pointClick) {
        this.pointClick = pointClick;
    }

    public void estTouche(PointDeControleIG point){
        this.pointClick = point;
        this.estTouche = 1;
    }

    public Map<String, EtapeIG> getSelectionne() {
        return selectionne;
    }

    @Override
    public Iterator iterator() {
        return getMap().values().iterator();
    }

    public Iterator iteratorArc(){
        return getArcs().iterator();
    }
}
