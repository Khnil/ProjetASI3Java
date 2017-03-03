package fr.insarouen.asi.prog.asiaventure.materiel.structure;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.PieceException;
import java.io.Serializable;
import java.lang.String;

/**
 * Classe de base pour représenter une exception sur l'absence d'un objet d'une pièce'.<br>
 * Cette classe hérite de la classe PieceException <br>
 *
 * @see PieceException
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class ObjetAbsentDeLaPieceException extends PieceException{

    /**
     * Constructeur ObjetAbsentDeLaPieceException. <br>
     * A la construction d'une exception sur l'absence d'un objet de la pièce, le constructeur de la classe PieceException est appelé
     * avec le string à afficher.
     *
     * @param s
     *        String à afficher
     */
  public ObjetAbsentDeLaPieceException(String s){
    super(s);
  }

  public ObjetAbsentDeLaPieceException(){

  }
}
