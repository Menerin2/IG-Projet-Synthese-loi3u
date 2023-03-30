package twisk.outils;

public class FabriqueIdentifiant {

    private int noEtape;
    private static final FabriqueIdentifiant instance = new FabriqueIdentifiant();

    public FabriqueIdentifiant(){
        this.noEtape = 1;
    }

    public static FabriqueIdentifiant getInstance(){
        return instance;
    }

    public String getIdentifiantEtape(){
        return "etape" + noEtape++;
    }

}
