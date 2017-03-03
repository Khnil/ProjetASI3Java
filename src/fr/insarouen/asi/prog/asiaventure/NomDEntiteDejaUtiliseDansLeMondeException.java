package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.MondeException;
import java.lang.String;

/**
 * Classe de base pour représenter une exception sur un nom d'entité déjà présent sur le monde concerné.<br>
 * Cette classe hérite de la classe MondeException. <br>
 *
 * @see MondeException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class NomDEntiteDejaUtiliseDansLeMondeException extends MondeException{

    /**
     * Constructeur NomDEntiteDejaUtiliseDansLeMondeException. <br>
     * A la construction d'une exception sur un nom d'entité déjà utilisé, le constructeur de la classe MondeException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public NomDEntiteDejaUtiliseDansLeMondeException(String s){
    super(s);
  }

  public NomDEntiteDejaUtiliseDansLeMondeException(){

  }
}
