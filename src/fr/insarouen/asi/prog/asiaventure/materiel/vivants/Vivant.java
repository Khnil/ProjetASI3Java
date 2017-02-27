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
    private Objet[] stuff= new Objet[0];


    public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet ... objets){
        super(nom,monde);
        this.PV = pointVie;
        this.PF = pointForce;
        this.piece = piece;
        System.arraycopy(stuff,0,this.stuff,0,stuff.length);
    }

    public static final Objet rien(Monde monde){
      return new Objet("rien",monde){
          public boolean estDeplacable(){
              return false;
          }
        };
      }

    public void prendre(String nomObj){
        if (this.piece.contientObjet(nomObj)) {
            Objet obj = this.piece.retirer(nomObj);
            Objet[] temp = new Objet[this.stuff.length+1];
            System.arraycopy(stuff,0,temp,0,this.stuff.length);
            temp[this.stuff.length]=obj;
            this.stuff=temp;
            }
    }

    public void prendre(Objet obj){
        prendre(obj.getNom());
    }

    public boolean contientObjet(String nom){
        boolean estpresent = false;
        if (this.getPiece().getObjets().length != 0){
            int i=0;
            do{
                if (this.getPiece().getObjets()[i].getNom().equals(nom)){
                    estpresent = true;
                }
                i++;
            }while(!estpresent && i<this.getPiece().getObjets().length);
        }
        return estpresent;
    }



    public Objet retirer(String nom){
        Objet obj = rien(getMonde());
        if (stuff.length != 0){
          Objet[] tempObjets = new Objet[stuff.length-1];
          if (contientObjet(nom)){
              boolean estpresent = false;
              int i=0;
              do {
                  if(stuff[i].getNom().equals(nom)){
                      estpresent=true;
                      i++;
                  }
              }while (!estpresent);

              obj = stuff[i-1];
              System.arraycopy(stuff,0,tempObjets,0,i);
              System.arraycopy(stuff,i+1,tempObjets,i,stuff.length-i-1);
          }
          stuff = tempObjets;
        }
        return obj;
    }

    public void deposer(String nomObj){
        if (!contientObjet(nomObj)) {
            Objet obj = getObjet(nomObj);
            stuff = Arrays.copyOf(stuff, stuff.length+1);
            stuff[stuff.length-1]= obj;
            Objet temp = retirer(obj.getNom());

        }
    }

    public void deposer(Objet obj){
        deposer(obj.getNom());
    }

    public Piece getPiece(){
        return this.piece;
    }

    /*public java.util.HashMap<String,Objet> getObjets(){

    }*/

    public Objet getObjet(String nomObjet){
        int i=0;
        boolean estPresent = false;
        Objet obj = null;
        if(stuff.length !=0){
          obj=stuff[0]; //si l'objet n'est pas present on retourne le premier de l'inventaire par defaut
          do{
              if (stuff[i].getNom().equals(nomObjet)) {
                  obj = stuff[i];
                  estPresent = true;
              }
              i++;
          }while (i<stuff.length && !estPresent );
        }
        return obj;
    }

    /*public boolean possede(Objet obj){
        boolean estpresent = false;
        int i=0;
        if(this.stuff.length!=0){
          do{
              if (this.stuff[i]==obj){
                  estpresent = true;
              }
              i++;
          }while(!estpresent && i<this.stuff.length);
        }
        return estpresent;
    }*/

    public boolean possede(Objet obj){
      for(int i=0;i<this.stuff.length;i++){
        if (stuff[i]==obj){
          return true;
        }
      }
      return false;
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
        return "";
    }
}
