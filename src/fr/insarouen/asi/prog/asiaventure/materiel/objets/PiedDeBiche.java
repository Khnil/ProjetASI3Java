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
      */
    public PiedDeBiche(String nom, Monde monde){
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
