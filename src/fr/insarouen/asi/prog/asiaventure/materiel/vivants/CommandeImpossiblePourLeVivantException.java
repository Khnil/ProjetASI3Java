package fr.insarouen.asi.prog.asiaventure.materiel.vivants;

import java.lang.String;

/**
 * Classe de base pour représenter une exception sur l'impossibilité d'utiliser une commande pour un vivant.<br>
 * Cette classe hérite de la classe VivantException <br>
 *
 * @see VivantException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class CommandeImpossiblePourLeVivantException extends VivantException{

    /**
     * Constructeur CommandeImpossiblePourLeVivantException. <br>
     * A la construction d'une exception sur une commande impossible pour le vivant, le constructeur de la classe VivantException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public CommandeImpossiblePourLeVivantException(String s){
    super(s);
  }

  public CommandeImpossiblePourLeVivantException(){

  }
}
