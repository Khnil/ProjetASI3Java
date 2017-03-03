package fr.insarouen.asi.prog.asiaventure.materiel.objets;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
import java.lang.String;


/**
 * Classe de base pour représenter une exception sur les objets.<br>
 * Cette classe hérite de la classe ASIAventureException <br>
 *
 * @see ASIAventureException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ObjetException extends ASIAventureException{

    /**
     * Constructeur ObjetException. <br>
     * A la construction d'une exception sur Objet, le constructeur de la classe ASIAventureException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public ObjetException(String s){
    super(s);
  }

  public ObjetException(){

  }
}
