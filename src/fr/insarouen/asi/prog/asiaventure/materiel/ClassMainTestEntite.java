package fr.insarouen.asi.prog.asiaventure.materiel;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;

public class ClassMainTestEntite{

  public static void main(String[] args) throws Exception{
    Monde Poney = new Monde("Poney");
    Monde Poney2 = new Monde("Poney2");
    Entite entite1 = new Entite("Jean Paul", Poney){};
    Entite entite2 = new Entite("Robin", Poney){};

    System.out.println(entite1.toString());
    System.out.println(entite1.getNom());
    System.out.println(entite1.getMonde().toString());
    Poney.ajouter(entite1);
    Poney.ajouter(entite2);
    System.out.println(entite1.getMonde().toString());

    System.out.println(Poney2.toString());
    Poney2.ajouter(entite1);
    Entite entite3 = new Entite("Jean Paul", Poney2){};
    //Poney.ajouter(entite3);
  }
}
