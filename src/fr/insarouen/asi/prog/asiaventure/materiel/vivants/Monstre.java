package fr.insarouen.asi.prog.asiaventure.materiel.vivants;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.materiel.Executable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Porte;

/**
 * Classe qui permet de décrire un monstre.Celui ci est un vivant apparaissant sans stuff. <br>
 * Cette classe hérite de la classe Vivant. elle possède donc ses caractéristiques.
 * Cette classe implémente l'interface Executable.
 *
 * @see Vivant
 * @see Executable
 *
 * @author Tom / Constantin
 * @version 1.0
 */

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
       if(this.estMort())
         throw new Throwable(String.format("Le monstre %s est mort.",this.getNom()));

       Map<String,Porte> lesPortes;
       Porte porteAFranchir;
       Boolean aFranchiPorte = false;
       lesPortes = getPiece().getPortes();
       do{


       }while(!aFranchiPorte);
   }

}
