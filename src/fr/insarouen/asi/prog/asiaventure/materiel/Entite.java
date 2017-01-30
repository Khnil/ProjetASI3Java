package fr.insarouen.asi.prog.asiaventure.materiel;

import java.lang.string;

public class Entite{
    private String nom;
    private Monde monde;

    public Entite(String nom, Monde monde){
        this.nom=nom;
        this.monde=monde;
    }

    public String getMonde(){
        return monde;
    }

    public String getNom(){
        return nom;
    }

    public String toString(){
        String str = "";
        for (int i=0;i<nom.length+monde.length;i++) {
            str=("Monde: "+monde+"Personnage: "+nom);
        }
        return str;
    }

    public Boolean equals(){

    }
}
