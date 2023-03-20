package tests;

import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;

import java.util.Objects;

public class TestEtapeIG {

    @Test
    public void testConstructeur(){
        EtapeIG etape = new ActiviteIG("defaut");
        assert etape.getHauteur() == 40;
        assert etape.getLargeur() == 80;
        assert Objects.equals(etape.getNom(), "defaut");
        assert Objects.equals(etape.getIdentifiant(), "etape1");
        assert etape.getPosX()>0 && etape.getPosX()<400;
        assert etape.getPosY()>0 && etape.getPosY()<400;
    }
}
