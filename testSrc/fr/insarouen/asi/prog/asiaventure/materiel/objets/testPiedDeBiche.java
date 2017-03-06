package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsSame;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;

public class TestPiedDeBiche {
    private Monde Plage;
    private Objet objetquelconque;
    private PiedDeBiche metalrouille;

    @Before
    public void avantTest() throws Exception{
        Plage = new Monde("Plage");
        objetquelconque = new Objet("conque", Plage){
          public boolean estDeplacable(){
          return true;
          }
        };
        metalrouille = new PiedDeBiche("metal rouille",Plage);
    }

    @Test
    public void testConstructeur(){
        assertThat(metalrouille.getNom(),IsEqual.equalTo("metal rouille"));
        assertThat(metalrouille.getMonde(),IsSame.sameInstance(Plage));
    }

    @Test
    public void testEstDeplacable(){
        assertThat(metalrouille.estDeplacable(),is(true));
    }
}
