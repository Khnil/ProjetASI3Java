package fr.insarouen.asi.prog.asiaventure.materiel;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;

public class TestEntite {

  private Entite entite ;

  @Before
  public void avantTest() throws Exception{
      Monde Poney = new Monde("Poney");
      Entite entite = new Entite("Jean Paul", Poney){};
  }

  @Test
  public void testGetNom(){
      assertThat(entite.getNom(), IsEqual.equalTo("Jean Paul"));
    }

  @Test
  public void testGetMonde(){
      assertThat(entite.getMonde().getNom(), IsEqual.equalTo("Poney"));
  }

  }
