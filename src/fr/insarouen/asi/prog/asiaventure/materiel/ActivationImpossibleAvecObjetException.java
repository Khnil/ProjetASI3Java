package fr.insarouen.asi.prog.asiaventure.materiel;

import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleException;

/**
 * Classe de base pour représenter une exception sur une activation impossible avec l'objet donné.<br>
 * Cette classe hérite de la classe ActivationImpossibleException. <br>
 *
 * @see ActivationImpossibleException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ActivationImpossibleAvecObjetException extends ActivationImpossibleException{

    /**
     * Constructeur ActivationImpossibleAvecObjetException. <br>
     * A la construction d'une exception sur une activation impossible avec l'objet donné, le constructeur de la classe ASIAventureException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public ActivationImpossibleAvecObjetException(String s){
    super(s);
  }

  public ActivationImpossibleAvecObjetException(){

  }
}
