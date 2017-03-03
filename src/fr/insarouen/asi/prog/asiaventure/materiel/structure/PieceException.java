package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurelException;
import java.io.Serializable;
import java.lang.String;

/**
 * Classe de base pour représenter une exception sur une pièce.<br>
 * Cette classe hérite de la classe ElementStructurelException <br>
 *
 * @see ElementStructurelException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class PieceException extends ElementStructurelException{

    /**
     * Constructeur PieceException. <br>
     * A la construction d'une exception sur une pièce, le constructeur de la classe ElementStructurelException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public PieceException(String s){
    super(s);
  }

  public PieceException(){

  }
}
