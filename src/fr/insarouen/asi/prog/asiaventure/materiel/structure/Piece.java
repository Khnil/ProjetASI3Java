package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import java.lang.Object;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.VivantAbsentDeLaPieceException;

public class Piece extends ElementStructurel implements java.io.Serializable {

    private Objet[] objets= new Objet[0];
    private Vivant[] vivants= new Vivant[0];

    /**
     * Lors de la construction d'une pièce, le constructeur de la classe ElementStructurel est appelé avec le nom de la pièce et le monde associé.
     *
     * @param nom
     *        Le nom de l'ElementStructurel
     * @param monde
     *        Le monde concerné
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom déjà utilisé dans monde.
     */
    public Piece(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom, monde);
    }

    /**
     * Cette fonction ajoute obj dan la liste des objets présxents dans la pièce. Elle agrandit le tableau objets d'une case pour mettre obj dans la dernière case qui vient d'être créée.
     *
     * @param obj
     *        L'objet que l'on cherche à ajouter à la pièce.
     *
     */
    public void deposer(Objet obj){
        objets = Arrays.copyOf(objets, objets.length+1);
        objets[objets.length-1]= obj;
    }

    /**
     * Cette fonction retire l'objet de nom 'nom' de la pièce. Elle diminue également la taille du tableau objets d'une case. Elle retourne enfin l'objet en question.
     * Pour ce faire elle vérifie la présence de l'objet au préalable dans la pièce avant de le supprimer du tableau. Si celui ci n'est pas dans la pièce la méthode renvoie une exception et la fonction renvoie null.
     * De même si l'objet n'est pas déplacable (et donc impossible à enlever de la pièce) la méthode renvoie une exception.
     *
     * @param nom
     *      Le nom de l'objet que l'on cherche à retirer.
     *
     * @return L'objet dont le nom est 'nom' ou null si celui ci n'est pas présent.
     *
     * @throws ObjetAbsentDeLaPieceException
     *      Renvoie l'exception d'un objet absent de la pièce.
     * @throws ObjetNonDeplacableException
     *      Renvoie l'exception de si l'objet n'est pas déplacable.
     */
    public Objet retirer(String nom) throws ObjetAbsentDeLaPieceException,
                     ObjetNonDeplacableException{
        Objet obj = null;
        boolean estpresent = false;
        int i=0;
        Objet[] tempObjets = new Objet[objets.length-1];
        if (objets.length !=0){
          if (contientObjet(nom)){
              do {
                  if(objets[i].getNom().equals(nom)){
                      estpresent=true;
                  }
                  i++;
              }while (!estpresent);
            }
          if(!estpresent) {
            throw new ObjetAbsentDeLaPieceException("L'objet "+nom+" à retirer n'est pas dans la pièce "+this.getNom()+".");
          }
              obj = objets[i-1];
          if(!obj.estDeplacable()){
            throw new ObjetNonDeplacableException("L'objet "+nom+" n'est pas déplacable.");
          }
              System.arraycopy(objets,0,tempObjets,0,i-1);
              System.arraycopy(objets,i,tempObjets,i-1,objets.length-i);
          }
          objets = tempObjets;
          return obj;
    }

    /**
     * Il s'agit de la fonction retirer sur un objet mais avec l'objet en entrée et non son nom.
     *
     * @param obj
     *        L'objet que l'on cherche à retirer.
     *
     * @return L'objet que l'on a retiré de la pièce.
     *
     * @throws ObjetAbsentDeLaPieceException
     *      Renvoie l'exception d'un objet absent de la pièce.
     * @throws ObjetNonDeplacableException
     *      Renvoie l'exception de si l'objet n'est pas déplacable.
     */
    public Objet retirer(Objet obj) throws ObjetAbsentDeLaPieceException,
                     ObjetNonDeplacableException{
        return retirer(obj.getNom());
    }

    /**
     * Cette méthode vérifie la présence de l'objet de nom "nom" dans le tableau objets et retourne la réponse sous forme de booléen.
     *
     * @param nom
     *        Le nom de l'objet dont on cherche à vérifier la présence.
     *
     * @return Un booléen
     *
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
     *Cette méthode vérifie la présence de l'objet obj dans le tableau objets et retourne la réponse sous forme de booléen.
     *
     * @param obj
     *        L'objet dont on cherche à vérifier la présence dans la pièce.
     *
     */
    public boolean contientObjet(Objet obj){
        return contientObjet(obj.getNom());
    }

    /**
     *Cette méthode renvoie un string listant les caractéristiques de la pièce. son nom, le monde dans lequel ell est ainsi que les objets et les vivants qu'elle contient.
     *
     * @return Un string listant les caractéristiques de la pièce.
     *
     */
    public String toString(){
        String str="";
        str = str+getNom()+"\n";
        str = str+getMonde().getNom()+"\n";
        for (int i =0;i<objets.length;i++){
          str = str+" "+objets[i].getNom();
        }
        for (int i =0;i<vivants.length;i++){
          str = str+" "+vivants[i].getNom();
        }
        return str;
    }

    /**
     *Cette méthode Fait entrer le vivant dans la pièce. Pour cela il grandit le tableau vivants d'une case et place le nouveau vivant dans la dernière case du tableau.
     *
     * @param vivant
     *      Le vivant qui entre dans la pièce.
     *
     */
    public void entrer(Vivant vivant){
        vivants = Arrays.copyOf(vivants, vivants.length+1);
        vivants[vivants.length-1]= vivant;
    }

    public Vivant sortir(Vivant vivant) throws VivantAbsentDeLaPieceException{
        return sortir(vivant.getNom());
    }

    public Vivant sortir(String nomVivant) throws VivantAbsentDeLaPieceException{
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

            if(!estpresent) {
              throw new VivantAbsentDeLaPieceException("Le vivant "+nomVivant+" n'est pas dans la pièce "+this.getNom()+".");
            }

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

    public Objet[] getObjets(){
      return objets;
    }
}
