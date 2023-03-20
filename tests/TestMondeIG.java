package tests;

import org.junit.jupiter.api.Test;
import twisk.mondeIG.ActiviteIG;
import twisk.mondeIG.EtapeIG;
import twisk.mondeIG.MondeIG;

public class TestMondeIG {

    @Test
    public void test(){
        MondeIG monde = new MondeIG();
        monde.ajouter("Activite");
        assert (monde.iterator().hasNext());
    }
}
