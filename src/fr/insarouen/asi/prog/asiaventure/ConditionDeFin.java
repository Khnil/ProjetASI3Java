package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;

/**
 * Classe de base pour représenter une condition de fin d'une partie.<br>
 * Cette classe implémente l'interface Serializable. <br>
 *
 * @see java.io.Serializable
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public abstract class ConditionDeFin extends java.lang.Object implements java.io.Serializable{

   /**
    * Definit l'état de sortie du jeu lorsque la condition de fin est remplie.
    */
    private EtatDuJeu etatDeSortie;

    /**
     * Constructeur de la classe ConditionDeFin. Définit simplement l'état de sortie de la condition de fin.
     *
     * @param etatDuJeu
     *          L'état que le jeu aura lorsque la condition de fin sera vérifiée.
     */
    public ConditionDeFin(EtatDuJeu etatDuJeu){
        this.etatDeSortie=etatDuJeu;
    }

    /**
     * Cette méthode renvoie l'état de sortie du jeu lorsque la condition est remplie.
     *
     * @return L'état de sortie sous la forme d'un EtatDuJeu.
     */
    public EtatDuJeu getEtatConditionVerifiee(){
        return this.etatDeSortie;
    }

    /**
     * Méthode qui vérifie si la condition est remplie ou non. Méthode abstraite.
     */
    public abstract EtatDuJeu verifierCondition();
}
