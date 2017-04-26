package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;

/**
 * Classe de base pour représenter une condition de fin d'une partie définie par la présence de certains objets dans le stuff d'un vivant.<br>
 * Cette classe hérite de la classe ConditionDeFin <br>
 *
 * @see ConditionDeFin
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin{

    /**
     * Définit le vivant qui doit posséder certains objets.
     */
    private Vivant vivantQuiDoitPosseder;

    /**
     * Définit les objets que le vivant doit posséder dans son stuff.
     */
    private Objet[] objetsAPosseder;

    /**
     * Constructeur de la classe ConditionDeFinVivantPossedeObjets. Définit simplement le vivant qui doit posséder les objets, les objets à posséder ainsi que l'état de fin lorsque les conditions sont vérifiées..
     *
     * @param etatConditionVerifiee
     *          L'état que le jeu aura lorsque la condition de fin sera vérifiée.
     * @param vivant
     *          Le vivant qui doit posséder certains objets dans son stuff.
     * @param objets
     *          Les objets que le vivant doit avoir dans son stuff.
     */
    public ConditionDeFinVivantPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant, Objet[] objets){
        super(etatConditionVerifiee);
        this.vivantQuiDoitPosseder = vivant;
        this.objetsAPosseder = objets;
    }

    /**
     * Méthode qui vérifie si le vivant en question possède bien les objets définis. Si celui ci les possède elle renvoie l'état de fin. Dans le cas contraire elle renvoir ENCOURS.
     *
     * @return L'état du jeu lorsque les conditions sont vérifiées ou alors le fait que le jeu soit toujours en cours.
     */
    public EtatDuJeu verifierCondition(){
        boolean possedeTout = true;
        int i = 0;
        while (possedeTout && i<objetsAPosseder.length){
            if(!vivantQuiDoitPosseder.possede(objetsAPosseder[i])){
                possedeTout = false;
            }
            i=i+1;
        }
        if(possedeTout){
            return this.getEtatConditionVerifiee();
        }
        else{
            return EtatDuJeu.ENCOURS;
        }
    }
}
