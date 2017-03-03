package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import java.lang.String;

/**
 * Classe de base pour représenter une exception sur un monde.<br>
 * Cette classe hérite de la classe ASIAventureException. <br>
 *
 * @see ASIAventureException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class MondeException extends ASIAventureException{

    /**
     * Constructeur MondeException. <br>
     * A la construction d'une exception sur un monde, le constructeur de la classe ASIAventureException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public MondeException(String s){
    super(s);
  }

  public MondeException(){

  }
}
