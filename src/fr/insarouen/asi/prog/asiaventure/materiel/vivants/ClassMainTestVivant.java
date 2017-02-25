package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;

public class ClassMainTestVivant{
    public static void main ( String[] args ){
        Monde maison = new Monde("Maison");
        Piece chambre = new Piece("Chambre",maison);
        PiedDeBiche pourCasserLaPorte = new PiedDeBiche("PiedDeBiche",maison);
        PiedDeBiche pourTaperMonFrere = new PiedDeBiche("Ouch",maison);
        Vivant moi = new Vivant("ConstanTom",maison,20,5,chambre,pourTaperMonFrere);
        Vivant frere = new Vivant("Frangin",maison,20,5,chambre);
        chambre.deposer(pourCasserLaPorte);
        moi.prendre(pourCasserLaPorte); // le vivant prend l'item sur lui
        System.out.println("doit ecrire false: "+chambre.contientObjet("pourCasserLaPorte")); // l'item n'est plus present dans la chambre
        System.out.println("doit ecrire true: "+moi.contientObjet("pourCasserLaPorte")); // l'item est present dans l'inventaire du vivant
        moi.deposer("pourCasserLaPorte"); // le vivant depose l'item dans la piece
        System.out.println("doit ecrire true: "+chambre.contientObjet("pourCasserLaPorte")); // l'item est present dans la chambre
        System.out.println("doit ecrire false: "+moi.contientObjet("pourCasserLaPorte")); // l'item n'est plus present dans l'inventaire du vivant
        System.out.println("doit ecrire true: "+ (moi.getPointVie()==20)); // PV
        System.out.println("doit ecrire true: "+ (moi.getPointForce()==5)); // PF
        System.out.println("doit ecrire false: "+ moi.estMort()); // le vivant est vivant
    }
}

//pas fini
