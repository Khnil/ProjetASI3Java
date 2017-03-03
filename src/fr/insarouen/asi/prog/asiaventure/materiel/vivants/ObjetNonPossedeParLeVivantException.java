package fr.insarouen.asi.prog.asiaventure.materiel.vivants;

import java.lang.String;

/**
 * Classe de base pour représenter une exception sur l'absence d'un objet dans le stuff d'un vivant.<br>
 * Cette classe hérite de la classe VivantException <br>
 *
 * @see VivantException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ObjetNonPossedeParLeVivantException extends VivantException{

    /**
     * Constructeur ObjetNonPossedeParLeVivantException. <br>
     * A la construction d'une exception sur un objet non possédé par le vivant, le constructeur de la classe VivantException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public ObjetNonPossedeParLeVivantException(String s){
    super(s);
  }

  public ObjetNonPossedeParLeVivantException(){

  }
}
