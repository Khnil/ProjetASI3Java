package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.MondeException;
import java.lang.String;

/**
 * Classe de base pour représenter une exception sur une entite déjà présente dans un autre monde.<br>
 * Cette classe hérite de la classe MondeException. <br>
 *
 * @see MondeException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class EntiteDejaDansUnAutreMondeException extends MondeException{

    /**
     * Constructeur EntiteDejaDansUnAutreMondeException. <br>
     * A la construction d'une exception sur une entite déjà présente autre part, le constructeur de la classe MondeException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public EntiteDejaDansUnAutreMondeException(String s){
    super(s);
  }

  public EntiteDejaDansUnAutreMondeException(){

  }
}
