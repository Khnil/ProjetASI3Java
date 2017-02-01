package fr.insarouen.asi.prog.asiaventure;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;

public class ClassMainTestEntite{

  public static void main(String[] args){
    Monde Poney = new Monde("Poney");
    Entite entite1 = new Entite("Jean Paul", Poney);
    Entite entite2 = new Entite("Robin", Poney);

    System.out.println(entite1.toString());
    System.out.println(entite1.getNom());
    System.out.println(entite1.getMonde().toString());
    Poney.ajouter(entite1);
    Poney.ajouter(entite2);
    System.out.println(entite1.getMonde().toString());
  }
}
