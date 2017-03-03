package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import java.lang.String;

/**
 * Classe de base pour représenter une exception sur l'absence d'un vivant d'une pièce.<br>
 * Cette classe hérite de la classe PieceException <br>
 *
 * @see PieceException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class VivantAbsentDeLaPieceException extends PieceException{

    /**
     * Constructeur VivantAbsentDeLaPieceException. <br>
     * A la construction d'une exception sur l'absence d'un vivant de la pièce, le constructeur de la classe PieceException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public VivantAbsentDeLaPieceException(String s){
    super(s);
  }

  public VivantAbsentDeLaPieceException(){

  }
}
