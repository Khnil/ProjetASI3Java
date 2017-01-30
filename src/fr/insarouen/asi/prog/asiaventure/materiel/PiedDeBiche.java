package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.Monde;

public class PiedDeBiche extends Objet {
    public PiedDeBiche(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
      super(nom,monde);
    }
    public boolean estDeplacable(){
      return true;
    }
  }
