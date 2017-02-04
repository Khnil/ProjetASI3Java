package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;

public class ClassMainTestPiedDeBiche {
  public static void main ( String[] args ) {
    Monde plage = new Monde("Plage");
    //Objet objetquelconque = new Objet("conque", plage); abstract = ne peut pas être instancié
    PiedDeBiche metalrouille = new PiedDeBiche("metal rouille",plage);
    /*system.out.println(objetquelconque.nom());
    system.out.println(objetquelconque.monde());
    system.out.println(objetquelconque.toString());*/
    System.out.println(metalrouille.getNom());
    System.out.println(metalrouille.getMonde());
    System.out.println(metalrouille.toString());
    System.out.println("un pied de biche est deplacable:"+metalrouille.estDeplacable());
  }
}
