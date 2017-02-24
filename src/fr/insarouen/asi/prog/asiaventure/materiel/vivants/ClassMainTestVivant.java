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

    }
}

//pas fini
