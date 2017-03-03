package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import java.lang.String;

/**
 * Classe de base pour représenter une exception sur la non déplacabilité des objets.<br>
 * Cette classe hérite de la classe ObjetException <br>
 *
 * @see ObjetException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ObjetNonDeplacableException extends ObjetException{

    /**
     * Constructeur ObjetNonDeplacableException. <br>
     * A la construction d'une exception sur la non déplaçabilité, le constructeur de la classe ObjetException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public ObjetNonDeplacableException(String s){
    super(s);
  }

  public ObjetNonDeplacableException(){

  }
}
