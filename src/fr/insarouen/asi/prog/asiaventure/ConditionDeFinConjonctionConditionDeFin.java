package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;

/**
 * Classe de base pour représenter une condition de fin d'une partie. En faisant la jointure de plusieurs conditions de fin à la fois.<br>
 * Cette classe hérite de la classe ConditionDeFin <br>
 *
 * @see ConditionDeFin
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ConditionDeFinConjonctionConditionDeFin extends ConditionDeFin{

  /**
   * Définit l'ensemble des conditions de fin à vérifier stockées dans un tableau.
   */
    private ConditionDeFin [] conditionsAVerifier;

    /**
     * Constructeur de la classe ConditionDeFinConjonctionConditionDeFin. Définit simplement l'état de sortie de la condition de fin et les conditions de fin à vérifier.
     *
     * @param etatDuJeu
     *          L'état que le jeu aura lorsque la condition de fin sera vérifiée.
     * @param cfs
     *          L'ensemble des conditions de fin qui constituent la conjonction de conditions de fin.
     */
    ConditionDeFinConjonctionConditionDeFin(EtatDuJeu etatDuJeu, ConditionDeFin... cfs){
        super(etatDuJeu);
        conditionsAVerifier = new ConditionDeFin[cfs.length];
        for(int i=0;i< cfs.length;i++){
            this.conditionsAVerifier[i]=cfs[i];
        }
    }

    /**
     * Méthode qui vérifie si les conditions de fin de toutes les conditions de la conjonction sont vérifiées.
     * Pour cela il vérifie une à une les conditions de fin de toutes les conditions constituant la conjonction et si l'une d'entre elle n'est pas vérifiée alors l'état du jeu reste en cours.
     *
     * @return L'état du jeu lorsque les conditions sont vérifiées ou alors le fait que le jeu soit toujours en cours.
     */
    public EtatDuJeu verifierCondition(){
        EtatDuJeu etatDeSortie = this.getEtatConditionVerifiee();
        int i = 0;
        while(etatDeSortie != EtatDuJeu.ENCOURS && i<conditionsAVerifier.length){
            etatDeSortie = conditionsAVerifier[i].verifierCondition();
            i=i+1;
        }
        if(etatDeSortie==EtatDuJeu.ENCOURS){
            return this.getEtatConditionVerifiee();
        }
        else {
            return EtatDuJeu.ENCOURS;
        }
    }
}
