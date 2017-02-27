package fr.insarouen.asi.prog.asiaventure.materiel.structure;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.PieceException;
import java.io.Serializable;
import java.lang.String;

public class ObjetAbsentDeLaPieceException extends PieceException{
  public ObjetAbsentDeLaPieceException(String s){
    super(s);
  }

  public ObjetAbsentDeLaPieceException(){

  }
}
