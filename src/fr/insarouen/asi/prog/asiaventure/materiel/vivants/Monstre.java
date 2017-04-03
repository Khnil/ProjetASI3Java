package fr.insarouen.asi.prog.asiaventure.materiel.vivants;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.materiel.Executable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;

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
   * @throws NomDEntiteDejaUtiliseDansLeMondeException
   *         Propage l'exception NomDEntiteDejaUtiliseDansLeMondeException
   */
   public Monstre(String nom, Monde monde, int pv, int pf, Piece piece) throws NomDEntiteDejaUtiliseDansLeMondeException {
     super(nom,monde,pv,pf,piece);
   }

   /**
    * Cette méthode correspond à un tour d'action d'un monstre.Si le monstre n'est pas mort alors celui-ci va échanger tous les objets de son stuff avec tous les objets de la pièce dans laquelle il est, puis changer de pièce.
    * La pièce dans laquelle il va est choisie au hasard parmi toutes les portes qu'il a à sa disposition dans la pièce où il est actuellement.
    *
    */
   public void executer() throws java.lang.Throwable{
       if(this.estMort())
         throw new Throwable(String.format("Le monstre %s est mort.",this.getNom()));

       Map<String,Porte> lesPortes;
       Porte porteAFranchir;
       Boolean aFranchiPorte = false;
       lesPortes = getPiece().getPortes();
       do{
         HashMap<String,Objet> tempObjets=new HashMap<String,Objet>();
         for(Objet obj: this.getPiece().getObjets().values()){
           tempObjets.put(obj.getNom(),obj);
         }
         for(Objet obj: this.getObjets().values()){
           deposer(obj);
         }
         for(Objet obj: tempObjets.values()){
           prendre(obj);
         }  //ça compile, est ce que ça marche?
         Porte porteAuPif;
         int nbPortesDispo = this.getPiece().getPortes().size();
         int porteAPrendre = (int)Math.random()*nbPortesDispo;
         Porte[] tableauPortes= new Porte[nbPortesDispo];
         int i=0;
         for (Porte porte:this.getPiece().getPortes().values()){
           tableauPortes[i]=porte;
           i=i+1;
         }
         porteAuPif=tableauPortes[porteAPrendre];
         this.getPiece().sortir(this);
         porteAuPif.getPieceAutreCote(this.getPiece()).entrer(this);
       }while(!aFranchiPorte);
   }

}
