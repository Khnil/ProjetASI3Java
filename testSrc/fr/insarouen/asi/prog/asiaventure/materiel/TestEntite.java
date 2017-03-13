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
  private Monde Poney;

  @Before
  public void avantTest() throws Exception{
      Poney = new Monde("Poney");
      entite = new Entite("Jean Paul", Poney){};
  }

  @Test
  public void testGetNom(){
      assertThat(entite.getNom(), IsEqual.equalTo("Jean Paul"));
    }

  @Test
  public void testGetMonde(){
      assertThat(entite.getMonde().getNom(), IsEqual.equalTo("Poney"));
  }

  @Test
  public void testEquals() throws Exception{
      Monde monde2 = new Monde("mondeTest2");
      Entite entite2 = new Entite("entiteTest2",monde2){};
      assertThat(entite.equals(entite), is(true));
      assertThat(entite.equals(entite2), is(false));
      }

  @Test
  public void testHashCode() {
      assertThat(entite.hashCode(), IsEqual.equalTo(entite.hashCode()));
      
  }
      }
