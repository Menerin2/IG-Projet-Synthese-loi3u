package twisk.mondeIG;

import twisk.outils.FabriqueIdentifiant;
import twisk.outils.TailleComposants;

import java.util.Random;

public abstract class EtapeIG {
    private String nom;
    private final String identifiant;
    private int posX;
    private int posY;
    private final int largeur;
    private final int hauteur;

    public EtapeIG(String nom){
        this.nom = nom;
        TailleComposants constantes = new TailleComposants();
        largeur = constantes.activiteLargeur();
        hauteur = constantes.activiteHauteur();
        this.identifiant = FabriqueIdentifiant.getInstance().getIdentifiantEtape();
        Random random = new Random();
        this.posX = random.nextInt(500);
        this.posY = random.nextInt(500);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
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

    @Override
    public String toString(){
        return getNom();
    }
}
