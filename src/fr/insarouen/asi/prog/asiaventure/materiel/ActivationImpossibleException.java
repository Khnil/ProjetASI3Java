package fr.insarouen.asi.prog.asiaventure.materiel;

import fr.insarouen.asi.prog.asiaventure.materiel.ActivationException;
import java.lang.String;

/**
 * Classe de base pour représenter une exception sur une activation impossible.<br>
 * Cette classe hérite de la classe ActivationException. <br>
 *
 * @see ActivationException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ActivationImpossibleException extends ActivationException{

    /**
     * Constructeur ActivationImpossibleException. <br>
     * A la construction d'une exception sur une activation impossible, le constructeur de la classe ActivationException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public ActivationImpossibleException(String s){
    super(s);
  }

  public ActivationImpossibleException(){

  }
}
