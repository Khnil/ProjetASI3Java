package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;

/**
 * Classe de base pour représenter une condition de fin d'une partie définie par la mort d'un vivant.<br>
 * Cette classe hérite de la classe ConditionDeFin <br>
 *
 * @see ConditionDeFin
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public abstract class ConditionDeFinVivantMort extends ConditionDeFin{

  /**
   * Définit le vivant qui doit mourir pour remplir la condition de fin.
   */
    Vivant vivantQuiPeutMourir;

    /**
     * Constructeur de la classe ConditionDeFinVivantMort. Définit simplement le vivant qui doit mourir pour remplir la condition de fin.
     *
     * @param etatConditionVerifiee
     *          L'état que le jeu aura lorsque la condition de fin sera vérifiée.
     * @param vivant
     *          Le vivant qui doit mourir.
     */
    public ConditionDeFinVivantMort(EtatDuJeu etatConditionVerifiee, Vivant vivant){
        super(etatConditionVerifiee);
        this.vivantQuiPeutMourir=vivant;
    }

    /**
     * Méthode qui vérifie si le vivant en question est bien mort ou vivant. Si celui ci est mort elle renvoie l'état de fin. Dans le cas contraire elle renvoir ENCOURS.
     *
     * @return L'état du jeu lorsque les conditions sont vérifiées ou alors le fait que le jeu soit toujours en cours.
     */
    public EtatDuJeu verifierCondition(){
        if (vivantQuiPeutMourir.estMort()){
            return this.getEtatConditionVerifiee();
        }
        else {
            return EtatDuJeu.ENCOURS;
        }
    }
}
