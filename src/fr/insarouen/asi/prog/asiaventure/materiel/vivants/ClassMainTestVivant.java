package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;

public class ClassMainTestVivant{
    public static void main ( String[] args ) throws Exception{
        Monde maison = new Monde("Maison");
        Piece chambre = new Piece("Chambre",maison);
        PiedDeBiche pourCasserLaPorte = new PiedDeBiche("PiedDeBiche",maison);
        PiedDeBiche pourTaperMonFrere = new PiedDeBiche("Ouch",maison);
        Vivant moi = new Vivant("ConstanTom",maison,20,5,chambre);
        Vivant frere = new Vivant("Frangin",maison,20,5,chambre);
        chambre.deposer(pourCasserLaPorte);
        chambre.deposer(pourTaperMonFrere);
        frere.prendre(pourCasserLaPorte);
        moi.prendre(pourTaperMonFrere);
        System.out.println("je détiens de quoi taper mon frère:"+ moi.possede(pourTaperMonFrere));
        moi.retirer("Ouch");
        chambre.deposer(pourTaperMonFrere);
        System.out.println("je l'ai fait tomber, mon frère le ramasse");
        frere.prendre(pourTaperMonFrere);
        System.out.println("il détiens de quoi me taper:"+frere.possede(pourTaperMonFrere));
        System.out.println("Nous somme tous les deux dans notre:"+moi.getPiece().getNom());
        System.out.println("J'ai "+moi.getPointVie()+" PV");
        System.out.println("Heureusement mon frère n'a que "+frere.getPointForce()+" d'attaque");
        System.out.println("Je suis en vie:"+!moi.estMort());
    }
}

//pas fini
