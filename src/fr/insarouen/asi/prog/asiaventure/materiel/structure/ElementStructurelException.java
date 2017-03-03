package fr.insarouen.asi.prog.asiaventure.materiel.structure;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;

import java.io.Serializable;
import java.lang.String;

/**
 * Classe de base pour représenter une exception sur un élément structurel.<br>
 * Cette classe hérite de la classe ASIAventureException. <br>
 *
 * @see ASIAventureException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ElementStructurelException extends ASIAventureException{

    /**
     * Constructeur ElementStructurelException. <br>
     * A la construction d'une exception sur un élément structurel, le constructeur de la classe ASIAventureException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public ElementStructurelException(String s){
    super(s);
  }

  public ElementStructurelException(){

  }
}
