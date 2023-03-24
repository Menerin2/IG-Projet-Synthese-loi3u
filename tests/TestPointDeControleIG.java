package tests;

import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.PointDeControleIG;

public class TestPointDeControleIG {

    @Test
    public void test(){
        EtapeIG etapeTest = new ActiviteIG("test");
        int cpt = 0;
        for(PointDeControleIG point : etapeTest.getPoints()){
            cpt++;
        }
        assert cpt==4;
    }



}
