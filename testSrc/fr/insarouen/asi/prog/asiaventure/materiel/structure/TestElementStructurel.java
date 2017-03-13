package fr.insarouen.asi.prog.asiaventure.materiel.structure;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsSame;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;

public class TestElementStructurel {
    private ElementStructurel elmt;
    private Monde Poney;

    @Before
    public void avantTest() throws Exception{
        Poney = new Monde("Poney");
        elmt = new ElementStructurel("elmt",Poney){};
}

    @Test
    public void testConstructeur(){
        assertThat(elmt.getNom(),IsEqual.equalTo("elmt"));
        assertThat(elmt.getMonde().getNom(),IsEqual.equalTo("Poney"));
    }
}
