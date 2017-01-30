package fr.insarouen.asi.prog.asiaventure.materiel;

import java.io.Serializable;
import java.lang.String;
import java.util.Arrays;

public class Monde{
  private String nom;
  private Entite[] entites= new Entite[0];

    public Monde(String nomDuMonde){
      this.nom = nomDuMonde;
    }

    public void ajouter(Entite entite){
      entites = Arrays.copyOf(entites, entites.length+1);
      entites[entites.length-1]= entite;
    }

    public Entite getEntite(String nomEntite){
     boolean trouve = false;
     int i=0;
     Entite entiteCherchee = null;
      while(!trouve && i<entites.length){
        if(entites[i].getNom()==nomEntite){
          trouve = true;
          entiteCherchee=this.entites[i];
        }else i++;
      }
      return entiteCherchee;
    }

    public String getNom(){
      return nom;
    }

    public String toString(){
      String str=nom+"\n";
      for (int i =0;i<entites.length;i++){
        str = str+" "+entites[i].getNom();
      }
      return str;
    }
}
