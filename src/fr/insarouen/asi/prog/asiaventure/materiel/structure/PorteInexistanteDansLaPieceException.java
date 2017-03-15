package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import java.lang.String;

/**
 * Classe de base pour représenter une exception sur l'absence d'une porte dans une pièce.<br>
 * Cette classe hérite de la classe PieceException <br>
 *
 * @see PieceException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class PorteInexistanteDansLaPieceException extends PieceException{

    /**
     * Constructeur PorteInexistanteDansLaPieceException. <br>
     * A la construction d'une exception sur l'absence d'une porte dans la pièce, le constructeur de la classe PieceException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public PorteInexistanteDansLaPieceException(String s){
    super(s);
  }

  public PorteInexistanteDansLaPieceException(){

  }
}
