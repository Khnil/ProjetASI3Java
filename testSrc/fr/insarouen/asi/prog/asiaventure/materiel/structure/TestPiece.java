package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.hamcrest.core.IsEqual;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.ObjetNonDeplacableException;

public class TestPiece {
    private Piece piece;
    private Monde monde;

    @Before
    public void avantTest() throws
    Exception{
        monde = new Monde("Monde");
        piece = new Piece("classe",monde);
    }

    @Test
    public void testConstructeur() throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{
        assertThat(piece.getNom(),IsEqual.equalTo("classe"));
        assertThat(piece.getMonde(),IsEqual.equalTo(monde));
    }

    @Test
    public void testDeposer() throws NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException{
        PiedDeBiche objet = new PiedDeBiche("pied",monde);
        piece.deposer(objet);
        assertThat(piece.contientObjet("pied"),IsEqual.equalTo(true));
    }

    @Test
    public void testRetirer() throws EntiteDejaDansUnAutreMondeException,NomDEntiteDejaUtiliseDansLeMondeException,ObjetNonDeplacableException,ObjetAbsentDeLaPieceException{
        PiedDeBiche objet = new PiedDeBiche("pied",monde);
        piece.deposer(objet);
        piece.retirer(objet);
        assertThat(piece.contientObjet("pied"),IsEqual.equalTo(false));
    }

    @Test(expected =ObjetAbsentDeLaPieceException.class)
    public void testRetirerObjetAbsent() throws ObjetAbsentDeLaPieceException,ObjetNonDeplacableException,NomDEntiteDejaUtiliseDansLeMondeException,EntiteDejaDansUnAutreMondeException {
        PiedDeBiche objet1 = new PiedDeBiche("pied",monde);
        PiedDeBiche objet2 = new PiedDeBiche("pied",monde);
        piece.deposer(objet2);
        piece.retirer(objet1);
    }
}
