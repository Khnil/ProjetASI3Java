package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurel;
import java.lang.Object;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;

public class ClassMainTestPiece{
    public static void main ( String[] args ) throws Exception{
        Monde maison = new Monde("Maison");
        Piece chambre = new Piece("Chambre",maison);
        PiedDeBiche pourCasserLaPorte = new PiedDeBiche("PiedDeBiche",maison);
        PiedDeBiche pourTaperMonFrere = new PiedDeBiche("Ouch",maison);
        chambre.deposer(pourCasserLaPorte);
        System.out.println("doit ecrire false: "+chambre.contientObjet("Ouch"));
        System.out.println("doit ecrire false: "+chambre.contientObjet(pourTaperMonFrere));
        System.out.println("doit ecrire true: "+chambre.contientObjet("PiedDeBiche"));
        System.out.println("doit ecrire true: "+chambre.contientObjet(pourCasserLaPorte));
        chambre.deposer(pourTaperMonFrere);
        chambre.retirer(pourCasserLaPorte);
        chambre.retirer(pourTaperMonFrere);
        System.out.println("doit ecrire false: "+chambre.contientObjet(pourCasserLaPorte));
        System.out.println("doit ecrire false: "+chambre.contientObjet(pourTaperMonFrere));
    }
}
