package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.Monde;

public abstract class Objet extends Entite {
  public Objet(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
  }
  public abstract boolean estDeplacable();
}
