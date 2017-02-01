package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;

public abstract class ElementStructurel extends Entite {
  public ElementStructurel (String nom, Monde monde){
    super(nom,monde);
  }
}
