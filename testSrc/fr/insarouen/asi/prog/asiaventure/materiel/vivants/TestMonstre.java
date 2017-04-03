package fr.insarouen.asi.prog.asiaventure.materiel.vivants;

import java.util.*;

import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Monstre;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.hamcrest.core.Is;
import org.hamcrest.core.IsSame;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TestMonstre {
    private Monstre monstre;
    private Monde monde;
    private Piece piece,piece2,piece3;
    private Porte porte,porteFermee;
    private Serrure serrure;

    @Before
    public void avantTest() throws Exception{
        monde = new Monde("Monde");
        piece = new Piece("piece",monde);
        piece2 = new Piece("piece2",monde);
        piece3 = new Piece("piece3",monde);
        serrure = new Serrure("serrure",monde);
        monstre = new Monstre("Monstre",monde,20,10,piece);
        porte = new Porte("porte",monde,piece,piece2);
        porteFermee = new Porte("porteFermee",monde,serrure,piece2,piece3);
    }

    @Test
    public void testConstructeur(){
      assertThat(monstre.getPointVie(),IsEqual.equalTo(20));
      assertThat(monstre.getPointForce(),IsEqual.equalTo(10));
      assertThat(monstre.getPiece(),IsSame.sameInstance(piece));
      assertThat(monstre.getNom(),IsEqual.equalTo("Monstre"));
      assertThat(monstre.getMonde(),IsSame.sameInstance(monde));
    }

    @Test(expected=Throwable.class)
    public void testExcuterMonstreMort() throws Throwable{
      Monstre monstre2 = new Monstre("monstreMort",monde,0,10,piece);
      monstre2.executer();
    }

    @Test
    public void testExecuter() throws Throwable{
        PiedDeBiche pdb = new PiedDeBiche("pdb",monde);
        PiedDeBiche pdb2 = new PiedDeBiche("pdb2",monde);
        PiedDeBiche pdb3 = new PiedDeBiche("pdb3",monde);

        Map<String,Objet> save = new HashMap<>();
        save.put(pdb.getNom(),pdb);
        Map<String,Objet> save2 = new HashMap<>();
        save2.put(pdb2.getNom(),pdb2);
        Map<String,Objet> save3 = new HashMap<>();
        save3.put(pdb3.getNom(),pdb3);

        piece.deposer(pdb);
        monstre.prendre(pdb);
        piece2.deposer(pdb2);
        piece3.deposer(pdb3);

        assertThat(piece.contientObjet(pdb),is(false));
        assertThat(piece2.contientObjet(pdb2),is(true));
        assertThat(piece3.contientObjet(pdb3),is(true));
        assertThat(monstre.getObjets(),IsEqual.equalTo(save));

        monstre.executer();

        assertThat(monstre.getPointVie(),IsEqual.equalTo(19));
        assertThat(monstre.getPiece().getObjets(),IsEqual.equalTo(save));
        assertThat(monstre.getObjets(),IsEqual.equalTo(save3));
    }
}
