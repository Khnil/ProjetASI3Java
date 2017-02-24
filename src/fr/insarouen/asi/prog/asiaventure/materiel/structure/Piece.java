package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import java.lang.Object;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.Monde;

/**
 * Classe de base pour représenter les pieces.<br>
 *
 * @see ElementStructurel
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class Piece extends ElementStructurel implements java.io.Serializable {
    private Objet[] objets= new Objet[0];
    private Vivant[] vivants= new Vivant[0];

    /**
      * constructeur Piece <br>
      * celui ci utilise le constructeur de la classe ElementStructurel.
      *
      * @param nom
      *   nom de la Piece
      * @param monde
      *   monde associé à la Piece
      */
    public Piece(String nom, Monde monde){
        super(nom, monde);
    }

    /**
      * premet de deposer un objet dans la piece
      *
      * @param obj
      *   obj a deposer
      */
    public void deposer(Objet obj){
        objets = Arrays.copyOf(objets, objets.length+1);
        objets[objets.length-1]= obj;
    }

    /**
      * premet de retirer un objet de la piece
      *
      * @param nom
      *   nom de l'obj a retirer
      * @return l'obj retire, si un obj est retire, null sinon
      */
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

    /**
      * premet de retirer un objet de la piece
      *
      * @param obj
      *   obj a retirer
      * @return l'obj retire, si un obj est retire, null sinon
      */
    public Objet retirer(Objet obj){
        return retirer(obj.getNom());
    }

    /**
      * retourne un booleen, vrai si la piece contient l'obj, faux sinon
      *
      * @param nom
      *   nom de l'obj qui est a verifier
      * @return booleen, true si la piece contient l'obj, false sinon
      */
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

    /**
      * retourne un booleen, vrai si la piece contient l'obj, faux sinon
      *
      * @param obj
      *   obj qui est a verifier
      * @return booleen, true si la piece contient l'obj, false sinon
      */
    public boolean contientObjet(Objet obj){
        return contientObjet(obj.getNom());
    }

    /**
      * retourne une chaine de caracteres contenant les infos de la piece (nom, nom du monde, objets de la piece)
      *
      * @return chaine de caracteres avec les infos de la piece
      */
    public String toString(){
        String str="";
        str = str+getNom()+"\n";
        str = str+getMonde().getNom()+"\n";
        for (int i =0;i<objets.length;i++){
          str = str+" "+objets[i].getNom();
        }
        return str;
    }

    /**
      * permet de faire entrer un vivant dans la piece
      *
      * @param vivant
      *   le vivant a faire rentrer dans la piece
      */
    public void entrer(Vivant vivant){
        Vivant[] vivants= new Vivant[1];
        vivants[1] = vivant;
    }

    /**
      * permet de faire sortir un vivant de la piece
      *
      * @param vivant
      *   le vivant a faire sortir de la piece
      */
    public Vivant sortir(Vivant vivant){
        return sortir(vivant.getNom());
    }

    /**
      * permet de faire sortir un vivant de la piece
      *
      * @param nomVivant
      *   le nom du vivant a faire sortir de la piece
      */
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

    /**
      * retourne un booleen, vrai si la piece contient le vivant, faux sinon
      *
      * @param vivant
      *   le vivant qui est a verifier
      * @return booleen, true si la piece contient le vivant, false sinon
      */
    public boolean contientVivant(Vivant vivant){
        return contientVivant(vivant.getNom());
    }

    /**
      * retourne un booleen, vrai si la piece contient le vivant, faux sinon
      *
      * @param nomVivant
      *   le nom du vivant qui est a verifier
      * @return booleen, true si la piece contient le vivant, false sinon
      */
    public boolean contientVivant(String nomVivant){
        return true;
    }
}
