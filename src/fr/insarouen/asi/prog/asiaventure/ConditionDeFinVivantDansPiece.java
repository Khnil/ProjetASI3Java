package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;

/**
 * Classe de base pour représenter une condition de fin d'une partie définie par un vivant dans une pièce en particulier.<br>
 * Cette classe hérite de la classe ConditionDeFin <br>
 *
 * @see ConditionDeFin
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ConditionDeFinVivantDansPiece extends ConditionDeFin{

    /**
     * Définit le vivant qui doit se trouver dans une pièce.
     */
    private Vivant vivantALocaliser;

    /**
     * Définit la pièce dans laquelle le vivant doit se trouver.
     */
    private Piece pieceAAtteindre;

    /**
     * Constructeur de la classe ConditionDeFinVivantDansPiece. Définit simplement l'état de sortie de la condition de fin , le vivant et la pièce qui lui sont associés.
     *
     * @param etatConditionVerifiee
     *          L'état que le jeu aura lorsque la condition de fin sera vérifiée.
     * @param vivant
     *          Le vivant qui doit être dans une pièce en particulier.
     * @param piece
     *          La pièce dans laquelle le vivant doit se trouver.
     */
    public ConditionDeFinVivantDansPiece(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece){
        super(etatConditionVerifiee);
        vivantALocaliser = vivant;
        pieceAAtteindre = piece;
    }

    /**
     * Méthode qui vérifie si le vivant en question est bien dans la pièce. Si c'est le cas elle renvoie l'état de fin. Sinon elle renvoie ENCOURS.
     *
     * @return L'état du jeu lorsque les conditions sont vérifiées ou alors le fait que le jeu soit toujours en cours.
     */
    public EtatDuJeu verifierCondition(){
        if(vivantALocaliser.getPiece() == pieceAAtteindre){
            return this.getEtatConditionVerifiee();
        }
        else {
            return EtatDuJeu.ENCOURS;
        }
    }
}
