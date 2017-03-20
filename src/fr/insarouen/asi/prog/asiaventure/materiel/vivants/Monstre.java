package fr.insarouen.asi.prog.asiaventure.materiel.vivants;

import fr.insarouen.asi.prog.asiaventure.materiel.Executable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;

public class Monstre extends Vivant implements Executable{
  /**
   * Constructeur Monstre.<br>
   *
   * @param nom
   *        Le nom à associer au Monstre
   * @param monde
   *        Le Monde auquel appartient le Monstre
   * @param pv
   *        Les points de vie du Monstre
   * @param pf
   *        Les points de force du Monstre
   * @param piece
   *        La Piece dans laquelle se situe le Monstre
   */
   public Monstre(String nom, Monde monde, int pv, int pf, Piece piece) throws NomDEntiteDejaUtiliseDansLeMondeException {
     super(nom,monde,pv,pf,piece);
   }

   public void executer() throws java.lang.Throwable{

   }
   
}
