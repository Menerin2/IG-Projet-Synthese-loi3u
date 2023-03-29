package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;
import twisk.outils.TailleComposants;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public abstract class EtapeIG implements Iterable<PointDeControleIG>{
    private String nom;
    private final String identifiant;
    private double posX;
    private double posY;
    private final int largeur;
    private final int hauteur;
    private ArrayList<PointDeControleIG> points = new ArrayList<>(4);

    public EtapeIG(String nom){
        this.nom = nom;
        TailleComposants constantes = new TailleComposants();
        largeur = constantes.activiteLargeur();
        hauteur = constantes.activiteHauteur();
        this.identifiant = FabriqueIdentifiant.getInstance().getIdentifiantEtape();
        Random random = new Random();
        this.posX = random.nextInt(500);
        this.posY = random.nextInt(500);
        for(int i=1; i<5; i++){
            PointDeControleIG point = new PointDeControleIG(this, i);
            points.add(point);
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public ArrayList<PointDeControleIG> getPoints() {
        return points;
    }

    @Override
    public Iterator<PointDeControleIG> iterator() {
        return points.iterator();
    }

    @Override
    public String toString(){
        return getNom();
    }
}
