package fr.insarouen.asi.prog.asiaventure.materiel;

import java.lang.String;
import java.lang.Object;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;
/**
  * classe définissant une entite quelconque du jeu (objet, piece, porte,...). <br>
  * Une entite est définie par:
  * <ul>
  *   <li>Un nom</li>
  *   <li>Un monde dans lequel elle est présente </li>
  * </ul>
  *
  * @see Monde
  *
  * @author Tom/Constantin
  * @version 1.0
  */

public abstract class Entite{
    /**
      * Le nom de l'entite.
      */
    private String nom;
    /**
      *Le monde dans lequel est l'entite.
      */
    private Monde monde;
    /**
      * constructeur Entite <br>
      * A la constructon de l'entite, le nom de celle ci ainsi que le monde dans lequel elle est présente sont fixés.
      *
      * @param nom
      *        nom de l'entite
      *
      * @param monde
      *        nom du monde dans lequel est l'entite
      *
      * @throws NomDEntiteDejaUtiliseDansLeMondeException
      *        Renvoie l'erreur d'un nom d'entité déjà utilisé dans monde.
      *
      */
    public Entite(String nom, Monde monde)throws NomDEntiteDejaUtiliseDansLeMondeException{
        this.nom=nom;
        this.monde=monde;
        try{
          monde.ajouter(this);
        }
        catch(EntiteDejaDansUnAutreMondeException e1){
            System.err.println("Ne devrait jamais arriver");
            System.exit(0);
        }
        catch(NomDEntiteDejaUtiliseDansLeMondeException e2){
          this.nom= nom+"1";
        }
    }

    /**
      * retourne le nom du monde dans lequel est l'entite.
      *
      * @return Le nom du monde
      */
    public Monde getMonde(){
        return this.monde;
    }

    /**
      * retourne le nom de l'entite
      *
      * @return Le nom de l'entite
      */
    public String getNom(){
        return this.nom;
    }

    /**
      * retourne un String donnant le monde complet de l'entité ainsi que le nom de celle ci.
      *
      * @return Un string avec le monde et le nom de l'entite.
      */
    public String toString(){
        String str = "";
        str=("Monde: "+monde.getNom()+"Nom de l'entite: "+nom);
        return str;
    }

    /**
      * retourne un booleen specifiant si l'objet donne est egal a l'entite courante.
      *
      * @param o
      *        L'objet qu'on compare a l'entite courante.
      *
      * @return Un booleen disant si les objets sont egaux ou non.
      */
    public boolean equals(Object o){
      boolean egales = false;
      Entite tmp = (Entite)o;
        if(this.getClass()==tmp.getClass()){
          if((this.getNom().equals(tmp.getNom())&&(this.getMonde().equals(tmp.getMonde())))){
             egales = true;
          }
        }
        return egales;
    }

    /**
      * retourne le code d'identification d'une entite.
      *
      * @return Un integer représentant le code d'identification.
      */
    public int hashCode(){
      return nom.hashCode()*13 + monde.hashCode()*7;
    }
}
