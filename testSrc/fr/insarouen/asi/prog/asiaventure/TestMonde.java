package fr.insarouen.asi.prog.asiaventure;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsSame;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;

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

    @Test(expected = NomDEntiteDejaUtiliseDansLeMondeException.class)
    public void testAjouterNomDEntiteDejaUtiliseDansLeMonde() throws Exception{
      PiedDeBiche pdb = new PiedDeBiche("pdb",monde);
      monde.ajouter(pdb);
    }

    @Test(expected = EntiteDejaDansUnAutreMondeException.class)
    public void testAjouterEntiteDejaDansUnAutreMondeException() throws Exception{
      PiedDeBiche pdb = new PiedDeBiche("pdb",monde);
      Monde monde2 = new Monde("Monde2");
      monde2.ajouter(pdb);
    }

    @Test
    public void testGetNom(){
        assertThat(monde.getNom(),IsEqual.equalTo("Monde"));
    }

    @Test
    public void testGetEntite() throws Exception{
      PiedDeBiche pdb = new PiedDeBiche("pdb",monde);
      assertThat(monde.getEntite("pdb"),IsSame.sameInstance((Entite) pdb));
    }


}
