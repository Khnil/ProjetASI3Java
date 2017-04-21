package fr.insarouen.asi.prog.asiaventure.materiel.vivants;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.materiel.Executable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.Etat;
import fr.insarouen.asi.prog.asiaventure.ASIAventureException;
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
        Map<String,Porte> portes = getPiece().getPortes();
        Boolean estPasse = false;
        Porte porteElue;
        System.out.println("Choix porte debut");
        do {
            System.out.println("Choix porte");
            porteElue = choixHasardPorte(portes);
            if (porteElue==null){
                System.out.println("porte nulle");
                break;}
            try{
                System.out.println("try");
                if (porteElue.getEtat()==Etat.FERME){
                    System.out.println("try - if");
                    this.activerActivable(porteElue);}
                System.out.println("franchir");
                this.franchir(porteElue);
                System.out.println("a franchi");
                estPasse = true;
                System.out.println("est passe");
                }
            catch(ASIAventureException e){
                    // il n'est pas passe
                }
        } while (!estPasse);
        this.setPointsDeVie(this.getPointVie()-1);
        echangerObjetsPieceMonstre();
   }

/**
 * Permet de choisir une porte au hasard
 * @method choixHasardPorte
 * @param  Map<String,Porte> portes       les portes existantes
 * @return                   une porte choisie au hasard
 */
   private Porte choixHasardPorte(Map<String,Porte> portes){
    if (portes.size()==0)
        return null;
    Porte[] tableauDesPortes = portes.values().toArray(new Porte[portes.size()]);
    int indiceAlea  =   (int)(portes.size()*Math.random());
    return tableauDesPortes[indiceAlea];
   }

   private void echangerObjetsPieceMonstre() throws Throwable{
       Map<String,Objet> objetsPiece = this.getPiece().getObjets();
       Map<String,Objet> objetsMonstre = this.getObjets();
       Map<String,Objet> temporaire = new HashMap<String,Objet>();

       //on met les obbjets de la piece dans le temporaire tout en les retirant de la piece
       for (Objet obj:this.getPiece().getObjets().values()) {
           temporaire.put(obj.getNom(),getPiece().retirer(obj));
       }

       //on depose les objets de l'inventaire du monstre dans la piece
       for (Objet obj:this.getObjets().values()){
           this.deposer(obj);
       }

       //on passe les objets de la piece qui sont dans le temporaire dans l'inventaire du monstre
       for (Objet obj:temporaire.values() ) {
           this.getPiece().deposer(obj);
           this.prendre(obj);
       }
   }
}
