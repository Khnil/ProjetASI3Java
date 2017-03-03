package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
  * classe definissant l'objet Pied de biche
  * Un pied de biche herite de la classe objet.
  *
  * @see Objet
  *
  * @author Tom/Constantin
  *
  * @version 1.0
  */
public class PiedDeBiche extends Objet {

    /**
      * constructeur PiedDeBiche <br>
      * celui ci utilise le constructeur de la classe objet.
      *
      * @param nom
      *     Le nom du pied de biche.
      * @param monde
      *     Le monde dans lequel est le pied de biche.
      * @throws NomDEntiteDejaUtiliseDansLeMondeException
      *     Renvoie l'exception d'un nom d'objet déjà utilisé dans monde.
      */
    public PiedDeBiche(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
      super(nom,monde);
    }

    /**
      * retourne un boolean definissant si celui ci est deplacable ou non. Un pied de biche est en effet deplacable
      *
      * @return Le booleen true.
      */
    public boolean estDeplacable(){
      return true;
    }
  }
