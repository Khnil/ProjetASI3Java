package fr.insarouen.asi.prog.asiaventure.materiel.vivants;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import java.lang.String;

/**
 * Classe de base pour représenter une exception sur un vivant.<br>
 * Cette classe hérite de la classe ASIAventureException <br>
 *
 * @see ASIAventureException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class VivantException extends ASIAventureException{

    /**
     * Constructeur VivantException. <br>
     * A la construction d'une exception sur un vivant, le constructeur de la classe ASIAventureException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public VivantException(String s){
    super(s);
  }

  public VivantException(){

  }
}
