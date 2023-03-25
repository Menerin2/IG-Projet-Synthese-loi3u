package twisk.mondeIG;

import java.util.Objects;

public class ArcIG {

    private PointDeControleIG[] points = new PointDeControleIG[2];

    public ArcIG(PointDeControleIG depart, PointDeControleIG arrive){
        this.points[0]=depart;
        this.points[1]=arrive;
    }

    public PointDeControleIG[] getPoints() {
        return points;
    }

    public boolean isBonneEtape(EtapeIG etape){
        return getPoints()[0].getEtape().getIdentifiant().equals(etape.getIdentifiant()) ||
                getPoints()[1].getEtape().getIdentifiant().equals(etape.getIdentifiant());
    }
}
