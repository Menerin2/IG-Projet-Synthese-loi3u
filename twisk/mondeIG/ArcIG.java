package twisk.mondeIG;

public class ArcIG {

    private PointDeControleIG[] points = new PointDeControleIG[2];

    public ArcIG(PointDeControleIG depart, PointDeControleIG arrive){
        this.points[0]=depart;
        this.points[1]=arrive;
    }

    public PointDeControleIG[] getPoints() {
        return points;
    }
}
