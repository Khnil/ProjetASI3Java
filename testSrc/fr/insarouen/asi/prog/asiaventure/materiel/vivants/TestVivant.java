package fr.insarouen.asi.prog.asiaventure.materiel.vivants;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsSame;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;

import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.ObjetNonPossedeParLeVivantException;

public class TestVivant {
    private Monde maison;
    private Piece chambre;
    private PiedDeBiche pourCasserLaPorte;
    private Vivant moi;

    @Before
    public void avantTest() throws Exception{
        maison = new Monde("Maison");
        chambre = new Piece("Chambre",maison);
        pourCasserLaPorte = new PiedDeBiche("PiedDeBiche",maison);
        moi = new Vivant("ConstanTom",maison,20,5,chambre);
        chambre.deposer(pourCasserLaPorte);
    }

    @Test
    public void testConstructeur(){
        /*assertThat(moi.getNom(), IsEqual.equalTo("ConstanTom"));
        assertThat(moi.getMonde(), IsEqual.equalTo("maison")); il faut modif les fcts pour les mettre en final et éviter de les retester*/
        assertThat(moi.getPointVie(), IsEqual.equalTo(20));
        assertThat(moi.getPointForce(), IsEqual.equalTo(5));
        assertThat(moi.getPiece(), IsSame.sameInstance(chambre));
        assertThat(moi.getObjets().size(), IsEqual.equalTo(0));
        assertThat(chambre.contientVivant(moi), is(true));
    }

    @Test
    public void testPrendre() throws Exception{
        moi.prendre(pourCasserLaPorte);
        assertThat(moi.possede(pourCasserLaPorte), is(true));
    }

    @Test
    public void testPrendreCh() throws Exception{
        moi.prendre("PiedDeBiche");
        assertThat(moi.possede(pourCasserLaPorte), is(true));
    }

    @Test(expected=ObjetAbsentDeLaPieceException.class)
    public void testObjetAbsentDeLaPiece() throws Exception{
        PiedDeBiche pdb = new PiedDeBiche("pdb", maison);
        moi.prendre(pdb);
    }

    @Test(expected=ObjetNonDeplacableException.class)
    public void testPrendreObjetNonDeplacable() throws Exception{
        Objet obj = new Objet("obj", maison){
            public boolean estDeplacable(){
                return false;
            }
        };
        chambre.deposer(obj);
        moi.prendre(obj);
    }

    @Test(expected=ObjetNonPossedeParLeVivantException.class)
    public void testPrendreObjetAbsentDeLaPiece() throws Exception{
        PiedDeBiche pdb = new PiedDeBiche("pdb", maison);
        moi.deposer(pdb);
    }

    @Test
    public void testDeposer() throws Exception{
        moi.prendre("PiedDeBiche");
        moi.deposer(pourCasserLaPorte);
        assertThat(moi.possede(pourCasserLaPorte), is(false));
    }

    @Test
    public void testDeposerCh() throws Exception{
        moi.prendre("PiedDeBiche");
        moi.deposer("PiedDeBiche");
        assertThat(moi.possede(pourCasserLaPorte), is(false));
    }

    @Test
    public void testGetPiece(){
        assertThat(moi.getPiece(), IsSame.sameInstance(chambre));
    }

    @Test
    public void testGetPointVie(){
        assertThat(moi.getPointVie(), IsEqual.equalTo(20));
    }

    @Test
    public void testGetPointForce(){
        assertThat(moi.getPointForce(), IsEqual.equalTo(5));
    }

    @Test
    public void testestMort(){
        assertThat(moi.estMort(), is(false));
    }

    @Test
    public void testPossede() throws Exception{
        assertThat(moi.possede(pourCasserLaPorte), is(false));
        moi.prendre("PiedDeBiche");
        assertThat(moi.possede(pourCasserLaPorte), is(true));
    }

    @Test
    public void testGetObjet() throws Exception{
        moi.prendre("PiedDeBiche");
        assertThat(moi.getObjet("PiedDeBiche"), IsSame.sameInstance((Objet) pourCasserLaPorte));
    }
}
