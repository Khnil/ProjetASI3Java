package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;

public class ConditionDeFinVivantDansPieceEtPossedeObjets extends ConditionDeFinConjonctionConditionDeFin {

    public ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece,Objet... objets){
        super(etatConditionVerifiee, new ConditionDeFinVivantDansPiece(etatConditionVerifiee, vivant, piece), new ConditionDeFinVivantPossedeObjets(etatConditionVerifiee, vivant, objets));
    }
}
