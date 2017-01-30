package fr.insarouen.asi.prog.asiaventure.materiel;

import java.lang.String;
import java.lang.Object;

public class Entite{
    private String nom;
    private Monde monde;

    public Entite(String nom, Monde monde){
        this.nom=nom;
        this.monde=monde;
    }

    public Monde getMonde(){
        return this.monde;
    }

    public String getNom(){
        return this.nom;
    }

    public String toString(){
        String str = "";
        str=("Monde: "+monde.toString()+"Personnage: "+nom);
        return str;
    }

    public boolean equals(Object o){
      boolean egales = false;
      Entite tmp = (Entite)o;
        if(this.getClass()==tmp.getClass()){
          if((this.getNom().equals(tmp.getNom())&&(this.getMonde().equals(tmp.getMonde())))){
             egales = true;
          }
        }
        return egales;
    }

    public int hashCode(){
      return nom.hashCode()*13 + monde.hashCode()*7;
    }
}
