package twisk.mondeIG;

public class PointDeControleIG {

    private double[] pos = new double[2];
    private String id;
    private EtapeIG etape;

    public PointDeControleIG(EtapeIG etape, int diretion){
        this.etape = etape;
        this.id = etape.getIdentifiant()+diretion;
        donnerPosition(diretion, pos);
    }

    public void donnerPosition(int direction, double[] pos){
        double tempX, tempY;
        switch (direction){
            case 1:
                tempX = etape.getPosX();
                tempY = etape.getPosY()+0.5*etape.getHauteur();
                break;
            case 2:
                tempX = etape.getPosX()+0.5*etape.getLargeur();
                tempY = etape.getPosY();
                break;
            case 3:
                tempX = etape.getPosX()+etape.getLargeur();
                tempY = etape.getPosY()+0.5*etape.getHauteur();
                break;
            case 4:
                tempX = etape.getPosX()+0.5*etape.getLargeur();
                tempY = etape.getPosY()+etape.getHauteur();
                break;
            default:
                tempX = -1;
                tempY = -1;
        }
        pos[0]=tempX;
        pos[1]=tempY;
    }

    public double[] getPos() {
        return pos;
    }

    public EtapeIG getEtape(){
        return etape;
    }
}
