package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurel;
import java.lang.Object;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.Monde;

public class Piece extends ElementStructurel implements java.io.Serializable {
    private Objet[] objets= new Objet[0];

    public Piece(String nom, Monde monde){
        super(nom, monde);
    }

    public void deposer(Objet obj){
        objets = Arrays.copyOf(objets, objets.length+1);
        objets[objets.length-1]= obj;
    }

    public Objet retirer(Objet obj){
        int i=0;
        boolean estPresent = false;
        do{
            if (objets[i] == obj) {
                objets[i] = null;
                estPresent = true;
            }
            i++;
        }while (i<objets.length && !estPresent );
      Objet[] tempObjets = new Objet[objets.length-1];
      int compteur = 0;
      for (int j=0;j<tempObjets.length;j++) {
        if (objets[j]!=null) {
          tempObjets[compteur]=objets[j];
          compteur++;
        }
      }
      objets = tempObjets;
      return obj;
    }

    public Objet retirer(String nom){
        int i=0;
        boolean estPresent = false;
        Objet obj=objets[0]; //si l'objet n'est pas present on retourne le premier de la piece par defaut.
        do{
            if (objets[i].getNom() == nom) {
                obj = objets[i];
                objets[i] = null;
                estPresent = true;
            }
            i++;
        }while (i<objets.length && !estPresent );
      Objet[] tempObjets = new Objet[objets.length-1];
      int compteur = 0;
      for (int j=0;j<tempObjets.length;j++) {
        if (objets[j]!=null) {
          tempObjets[compteur]=objets[j];
          compteur++;
        }
      }
      objets = tempObjets;
      return obj;
    }

    public boolean contientObjet(Objet obj){
        boolean estpresent = false;
        int i=0;
        do{
            if (objets[i]==obj){
                estpresent = true;
            }
            i++;
        }while(!estpresent && i<objets.length);
        return estpresent;
    }

    public boolean contientObjet(String nom){
        boolean estpresent = false;
        int i=0;
        do{
            if (objets[i].getNom()==nom){
                estpresent = true;
            }
            i++;
        }while(!estpresent && i<objets.length);
        return estpresent;
    }

    public String toString(){
        String str="";
        str = str+getNom()+"\n";
        str = str+getMonde().getNom()+"\n";
        for (int i =0;i<objets.length;i++){
          str = str+" "+objets[i].getNom();
        }
        return str;
    }
}
