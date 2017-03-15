package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import java.lang.String;

/**
 * Classe de base pour représenter une exception sur une porte fermée dans une pièce.<br>
 * Cette classe hérite de la classe PieceException <br>
 *
 * @see ElementStructurelException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class PorteFermeException extends ElementStructurelException{

    /**
     * Constructeur PorteFermeException. <br>
     * A la construction d'une exception sur une porte fermée dans une pièce, le constructeur de la classe PieceException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public PorteFermeException(String s){
    super(s);
  }

  public PorteFermeException(){

  }
}
