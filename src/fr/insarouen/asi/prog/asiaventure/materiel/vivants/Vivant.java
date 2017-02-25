package fr.insarouen.asi.prog.asiaventure.materiel.vivants;
import java.lang.Object;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import java.lang.String;
import java.util.Arrays;

public class Vivant extends Entite{
    private int PV;
    private int PF;
    private Piece piece;
    private Objet[] objets= new Objet[0];


    public abstract Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet...objets){
        super(nom,monde);
        this.PV = pointVie;
        this.PF = pointForce;
        this.piece = piece;
        System.arraycopy(objets,0,this.objets,0,objets.length);
    }

    public void prendre(String nomObj){
        if (this.piece.contientObjet(nomObj)) {
            this.piece.retirer(nomObj);
            Objet obj = getObjet(nomObj);
            objets = Arrays.copyOf(objets, objets.length+1);
            objets[objets.length-1]= obj;
            retirer(nomObj);
        }
    }

    public void prendre(Objet obj){
        prendre(obj.getNom());
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

    public void deposer(String nomObj){
        if (!contientObjet(nomObj)) {
            Objet obj = getObjet(nomObj);
            objets = Arrays.copyOf(objets, objets.length+1);
            objets[objets.length-1]= obj;
            Objet temp = retirer(obj.getNom());
        }
    }

    public void deposer(Objet obj){
        deposer(obj.getNom());
    }

    public Piece getPiece(){
        return this.piece;
    }

    public java.util.HashMap<String,Objet> getObjets(){

    }

    public Objet getObjet(String nomObjet){
        int i=0;
        boolean estPresent = false;
        Objet obj=objets[0]; //si l'objet n'est pas present on retourne le premier de la piece par defaut.
        do{
            if (objets[i].getNom().equals(nomObjet)) {
                obj = objets[i];
                estPresent = true;
            }
            i++;
        }while (i<objets.length && !estPresent );
        return obj;
    }

    public boolean possede(Objet obj){
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

    public int getPointVie(){
        return PV;
    }

    public int getPointForce(){
        return PF;
    }

    public boolean estMort(){
        return (PV==0);
    }

    public String toString(){
        String str = "Nom du vivant: ";
        str = str+getNom()+"\n";
        str = str+"dans la piece: "+this.piece+"\n";
        str = str+"PV: "+getPointVie()+"\n";
        str = str+"PF: "+getPointForce()+"\n";
        str = str+"Inventaire: "+"\n";
        for (int i =0;i<objets.length;i++){ //a modif avec append
          str = str+" "+objets[i].getNom();
        }
        return str;
    }
}
