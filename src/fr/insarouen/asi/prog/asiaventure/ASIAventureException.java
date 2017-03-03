package fr.insarouen.asi.prog.asiaventure;
import java.io.Serializable;
import java.lang.String;

/**
 * Classe de base pour représenter une exception dans le projet.<br>
 * Cette classe hérite de la classe Exception du package java.lang. <br>
 *
 * @see java.lang.Exception
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ASIAventureException extends java.lang.Exception{

    /**
     * Constructeur ASIAventureException. <br>
     * A la construction d'une exception, le constructeur de la classeException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public ASIAventureException(String s){
    super(s);
  }

  public ASIAventureException(){

  }
}
