package tests;

import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.ArcIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class TestMondeIG {

    @Test
    public void test(){
        MondeIG monde = new MondeIG();
        monde.ajouter("Activite");
        assert (monde.iterator().hasNext());
    }

    @Test
    public void testValidite(){
        MondeIG monde = new MondeIG();
        EtapeIG test1 = new ActiviteIG("test1");
        EtapeIG test2 = new ActiviteIG("test2");
        ArcIG testArc = new ArcIG(test1.getPoints().get(0), test1.getPoints().get(2));
        assert monde.testValiditeArc(testArc);
        testArc = new ArcIG(test1.getPoints().get(0), test2.getPoints().get(0));
        assert !monde.testValiditeArc(testArc);

    }
}
