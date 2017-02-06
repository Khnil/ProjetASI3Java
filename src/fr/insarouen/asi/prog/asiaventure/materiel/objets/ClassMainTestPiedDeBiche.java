package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;

public class ClassMainTestPiedDeBiche {
  public static void main ( String[] args ) {
    Monde Plage = new Monde("Plage");
    Objet objetquelconque = new Objet("conque", Plage){
        public boolean estDeplacable(){
            return true;
        }
    }; //abstract = ne peut pas être instancié
    PiedDeBiche metalrouille = new PiedDeBiche("metal rouille",Plage);
    System.out.println(objetquelconque.getNom());
    System.out.println(objetquelconque.getMonde());
    System.out.println(objetquelconque.toString());
    System.out.println(metalrouille.getNom());
    System.out.println(metalrouille.getMonde());
    System.out.println(metalrouille.toString());
    System.out.println("un pied de biche est deplacable:"+metalrouille.estDeplacable());
  }
}
