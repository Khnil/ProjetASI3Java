package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;

/**
 * Classe de base pour représenter une condition de fin d'une partie définie par un vivant dans une pièce en particulier avec certains objets dans son stuff.<br>
 * Cette classe hérite de la classe ConditionDeFinConjonctionConditionDeFin <br>
 *
 * @see ConditionDeFinConjonctionConditionDeFin
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ConditionDeFinVivantDansPieceEtPossedeObjets extends ConditionDeFinConjonctionConditionDeFin {

  /**
   * Constructeur de la classe ConditionDeFinVivantDansPieceEtPossedeObjets. Définit simplement l'état de sortie de la condition de fin , le vivant et la pièce qui lui sont associés, ainsi que les objets qui doivent être dans le stuff du vivant.
   *
   * @param etatConditionVerifiee
   *          L'état que le jeu aura lorsque la condition de fin sera vérifiée.
   * @param vivant
   *          Le vivant qui doit être dans une pièce en particulier.
   * @param piece
   *          La pièce dans laquelle le vivant doit se trouver.
   * @param objets
   *          Les objets qui doivent être dans le stuff du vivant.
   */
    public ConditionDeFinVivantDansPieceEtPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant, Piece piece,Objet... objets){
        super(etatConditionVerifiee, new ConditionDeFinVivantDansPiece(etatConditionVerifiee, vivant, piece), new ConditionDeFinVivantPossedeObjets(etatConditionVerifiee, vivant, objets));
    }
}
