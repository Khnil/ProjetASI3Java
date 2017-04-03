package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;

public class ConditionDeFinVivantDansPiece extends ConditionDeFin{

    private Vivant vivantALocaliser;
    private Piece pieceAAtteindre;

    public ConditionDeFinVivantDansPiece(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece){
        super(etatConditionVerifiee);
        vivantALocaliser = vivant;
        pieceAAtteindre = piece;
    }

    public EtatDuJeu verifierCondition(){
        if(vivantALocaliser.getPiece() == pieceAAtteindre){
            return this.getEtatConditionVerifiee();
        }
        else {
            return EtatDuJeu.ENCOURS;
        }
    }
}
