package fr.insarouen.asi.prog.asiaventure.materiel;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.Monde;

public abstract class ElementStructurel extends Entite {
  public ElementStructurel (String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super Entite(nom,monde);
  }
}
