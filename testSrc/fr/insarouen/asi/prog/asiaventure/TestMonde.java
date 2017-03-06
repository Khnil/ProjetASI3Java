package fr.insarouen.asi.prog.asiaventure;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

public class TestMonde {
    public Monde monde;

    @Before
    public void avantTest() throws
    Exception{
        monde = new Monde("Monde");
    }

    @Test
    public void testConstructeur(){
        assertThat(monde.getNom(),IsEqual.equalTo("Monde"));
    }

    @Test
    public void testAjouter() throws NomDEntiteDejaUtiliseDansLeMondeException{
        Entite entite = new Entite("truc",monde){};
        assertThat(monde.getEntite("truc"),IsEqual.equalTo(entite));
    }

    @Test(expected=NomDEntiteDejaUtiliseDansLeMondeException.class)
    public void testAjouterDeuxFois() throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{
        Entite entite1 = new Entite("e1",monde){};
        Entite entite2 = new Entite("e1",monde){};
    }
}
