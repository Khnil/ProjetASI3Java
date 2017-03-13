package fr.insarouen.asi.prog.asiaventure.materiel.objets;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.hamcrest.core.IsSame;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;

public class TestObjet {
    private Monde Plage;
    private Objet objetquelconque;

    @Before
    public void avantTest() throws Exception{
        Plage = new Monde("Plage");
        objetquelconque = new Objet("conque", Plage){
            public boolean estDeplacable(){
                return false;
            }
        };
    }

    @Test
    public void testConstructeur() throws Exception{
        assertThat(objetquelconque.getNom(), IsEqual.equalTo("conque"));
        assertThat(objetquelconque.getMonde(),IsSame.sameInstance(Plage));
    }
}
