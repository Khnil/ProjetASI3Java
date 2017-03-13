package fr.insarouen.asi.prog.asiaventure.materiel;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import java.lang.String;

/**
 * Classe de base pour représenter une exception sur une activation.<br>
 * Cette classe hérite de la classe ASIAventureException. <br>
 *
 * @see ASIAventureException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ActivationException extends ASIAventureException{

    /**
     * Constructeur ActivationException. <br>
     * A la construction d'une exception sur une activation, le constructeur de la classe ASIAventureException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public ActivationException(String s){
    super(s);
  }

  public ActivationException(){

  }
}
