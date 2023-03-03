package tests;

import org.junit.jupiter.api.Test;
import twisk.outils.FabriqueIdentifiant;

import java.util.Objects;

public class TestFabriqueIdentifiant {

    @Test
    public void test(){
        FabriqueIdentifiant fabrique = new FabriqueIdentifiant();
        String strTest = fabrique.getIdentifiantEtape();
        assert Objects.equals(strTest, "etape1");
        strTest = fabrique.getIdentifiantEtape();
        assert Objects.equals(strTest, "etape2");
    }
}
