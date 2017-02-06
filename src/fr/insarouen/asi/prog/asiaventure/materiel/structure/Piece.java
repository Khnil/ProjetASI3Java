package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import java.lang.Object;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.Monde;

public class Piece extends ElementStructurel implements java.io.Serializable {
    private Objet[] objets= new Objet[0];
    private Vivant[] vivants= new Vivant[0];

    public Piece(String nom, Monde monde){
        super(nom, monde);
    }

    public void deposer(Objet obj){
        objets = Arrays.copyOf(objets, objets.length+1);
        objets[objets.length-1]= obj;
    }

    public Objet retirer(String nom){
        Objet obj = null;
        Objet[] tempObjets = new Objet[objets.length-1];
        if (contientObjet(nom)){
            boolean estpresent = false;
            int i=0;
            do {
                if(objets[i].getNom().equals(nom)){
                    estpresent=true;
                    i++;
                }
            }while (!estpresent);

            obj = objets[i-1];
            System.arraycopy(objets,0,tempObjets,0,i);
            System.arraycopy(objets,i+1,tempObjets,i,objets.length-i-1);
        }
        objets = tempObjets;
        return obj;
    }

    public Objet retirer(Objet obj){
        return retirer(obj.getNom());
    }

    public boolean contientObjet(String nom){
        boolean estpresent = false;
        if (objets.length != 0){
            int i=0;
            do{
                if (objets[i].getNom().equals(nom)){
                    estpresent = true;
                }
                i++;
            }while(!estpresent && i<objets.length);
        }
        return estpresent;
    }

    public boolean contientObjet(Objet obj){
        return contientObjet(obj.getNom());
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

    public void entrer(Vivant vivant){
        Vivant[] vivants= new Vivant[1];
        vivants[1] = vivant;
    }

    public Vivant sortir(Vivant vivant){
        return sortir(vivant.getNom());
    }

    public Vivant sortir(String nomVivant){
        Vivant vivant = null;
        Vivant[] tmpvivants = new Vivant[vivants.length-1];
        if (contientVivant(nomVivant)){
            boolean estpresent = false;
            int i=0;
            do {
                if(vivants[i].getNom().equals(nomVivant)){
                    estpresent=true;
                    i++;
                }
            }while (!estpresent);

            vivant = vivants[i-1];
            System.arraycopy(vivants,0,tmpvivants,0,i);
            System.arraycopy(objets,i+1,tmpvivants,i,vivants.length-i-1);
        }
        vivants = tmpvivants;
        return vivant;
    }

    public boolean contientVivant(Vivant vivant){
        return contientVivant(vivant.getNom());
    }

    public boolean contientVivant(String nomVivant){
        return true;
    }
}
