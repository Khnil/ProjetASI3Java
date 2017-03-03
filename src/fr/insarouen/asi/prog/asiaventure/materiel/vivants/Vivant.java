package fr.insarouen.asi.prog.asiaventure.materiel.vivants;
import java.lang.Object;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import java.lang.String;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.ObjetNonDeplacableException;


/**
 * Classe qui permet de décrire un vivant.<br>
 * Celui ci est composé:
 * <ul>
 *    <li> D'un nom </li>
 *    <li> D'un monde dans lequel il est présent. </li>
 *    <li> D'un nombre de points de vie(PV)</li>
 *    <li> D'un nombre de points de force(PF)</li>
 *    <li> D'une pièce dans laquelle il est présent.</li>
 *    <li> D'un stuff étant une liste d'objets déplacables</li>
 * </ul>
 * Cette classe hérite de la classe Entite.
 *
 * @see Entite
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class Vivant extends Entite{
    private int PV;
    private int PF;
    private Piece piece;
    private Objet[] stuff= new Objet[0];

    /**
     * Lors de la construction d'un vivant, le constructeur de la classe Entite est appelé avec le nom du vivant et le monde associé.
     * On associe au vivant ensuite un nombre de PV et de PF, une pièce dans laquelle il est et son stuff de départ.
     *
     * @param nom
     *        Le nom de l'ElementStructurel
     * @param monde
     *        Le monde concerné
     * @param pointVie
     *        Le nombre de points de vie du vivant.
     * @param pointForce
     *        Le nombre de points de force du vivant.
     * @param piece
     *        La pièce dans laquelle le vivant est présent à sa création.
     * @param objets
     *        La liste des objets du vivant au moment de sa création.
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom déjà utilisé dans monde.
     */
    public Vivant(String nom, Monde monde, int pointVie, int pointForce, Piece piece, Objet ... objets) throws NomDEntiteDejaUtiliseDansLeMondeException {
        super(nom,monde);
        this.PV = pointVie;
        this.PF = pointForce;
        this.piece = piece;
        System.arraycopy(stuff,0,this.stuff,0,stuff.length);
    }

    /**
     * Cette méthode fait prendre au vivant l'objet de nom 'nomObj' de la pièce et le met dans son stuff. Pour celà il retire l'objet de la pièce dans laquelle il est (à l'aide de la fonction retirer) et ajoute cet objet dans le tableau stuff.
     * Si l'objet en question n'est pas dans la pièce ou si il n'est pas déplacable la méthode renvoie un exception.
     *
     * @param nomObj
     *        Le nom de l'objet à prendre.
     *
     * @throws ObjetAbsentDeLaPieceException
     *        Renvoie l'exception d'un objet à prendre qui n'est pas dans la pièce.
     * @throws ObjetNonDeplacableException
     *        Renvoie l'exception d'un objet qui n'est pas déplacable et donc impossible à prendre.
     */
    public void prendre(String nomObj) throws ObjetAbsentDeLaPieceException,
                    ObjetNonDeplacableException{
        if (this.piece.contientObjet(nomObj)) {
            Objet obj = this.piece.retirer(nomObj);
            Objet[] temp = new Objet[this.stuff.length+1];
            System.arraycopy(stuff,0,temp,0,this.stuff.length);
            temp[this.stuff.length]=obj;
            this.stuff=temp;
            }
    }

    /**
     * Cette méthode fait prendre au vivant l'objet obj de la pièce et le met dans son stuff. Pour celà il retire l'objet de la pièce dans laquelle il est (à l'aide de la fonction retirer) et ajoute cet objet dans le tableau stuff.
     * Si l'objet en question n'est pas dans la pièce ou si il n'est pas déplacable la méthode renvoie un exception.
     *
     * @param obj
     *        L'objet à prendre.
     *
     * @throws ObjetAbsentDeLaPieceException
     *        Renvoie l'exception d'un objet à prendre qui n'est pas dans la pièce.
     * @throws ObjetNonDeplacableException
     *        Renvoie l'exception d'un objet qui n'est pas déplacable et donc impossible à prendre.
     */
    public void prendre(Objet obj) throws ObjetAbsentDeLaPieceException,
                    ObjetNonDeplacableException{
        prendre(obj.getNom());
    }

    /**
     * Cette méthode vérifie la présence de l'objet de nom "nom" dans le tableau objets de la pièce où le vivant est et retourne la réponse sous forme de booléen.
     *
     * @param nom
     *        Le nom de l'objet dont on cherche à vérifier la présence.
     *
     * @return Un booléen
     *
     */
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


    /**
     * Cette fonction retire l'objet de nom 'nom' du stuff du vivant. Elle diminue également la taille du tableau stuff d'une case. Elle retourne enfin l'objet en question.
     * Pour ce faire elle vérifie la présence de l'objet au préalable dans sonj stuff avant de le supprimer du tableau. Si celui ci n'est pas dans le stuff la fonction renvoie null.
     *
     * @param nom
     *      Le nom de l'objet que l'on cherche à retirer.
     *
     * @return L'objet dont le nom est 'nom' ou null si celui ci n'est pas présent.
     *
     */
    public Objet retirer(String nom){
        Objet obj = null;
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

    /**
     * Cette méthode retire l'objet de nom nomObj du stuff du vivant. Si celui ci n'a pas l'objet alors il ne peut être retiré et la méthode renvoie un exception. De même si l'objet est déjà présent dans la pièce la fonction ne fait rien.
     *
     * @param nomObj
     *      Le nom de l'objet que l'on cherche à retirer.
     *
     * @throws ObjetNonPossedeParLeVivantException
     *      Renvoie l'exception d'un objet qui n'est pas dans le stuff du vivant.
     */
    public void deposer(String nomObj) throws ObjetNonPossedeParLeVivantException{
        if (!possede(getObjet(nomObj))){
            throw new ObjetNonPossedeParLeVivantException("L'objet "+nomObj+" à deposer n'est pas dans le stuff de "+this.getNom()+".");
        }
        Objet obj = retirer(nomObj);
        this.getPiece().deposer(obj);
        //stuff = Arrays.copyOf(stuff, stuff.length+1);
        //stuff[stuff.length-1]= obj;
        //Objet temp = retirer(obj.getNom());
    }

    public void deposer(Objet obj) throws ObjetNonPossedeParLeVivantException{
        deposer(obj.getNom());
    }

    /**
     * Cette méthode renvoie la pièce dans laquelle est le vivant.
     *
     * @return La pièce dans laquelle se trouve le vivant.
     *
     */
    public Piece getPiece(){
        return this.piece;
    }

    /*public java.util.HashMap<String,Objet> getObjets(){

    }*/

    /**
     * Cette fonction renvoie l'objet de nom 'nomObjet' présent dans le stuff du vivant.
     *
     * @param nomObjet
     *      Le nom de l'objet que l'on cherche à retourner.
     *
     * @return L'objet dont le nom est 'nomObjet' ou null si celui ci n'est pas présent.
     *
     */
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

    /**
     * Cette méthode vérifie si le vivant possède l'objet obj dans son stuff puis retourne la réponse sous forme de booléen.
     *
     * @param obj
     *      L'objet que l'on cherche dans le stuff du vivant.
     *
     * @return Un booléen qui informe si l'objet est bien présent dans le stuff.
     *
     */
    public boolean possede(Objet obj){
      for(int i=0;i<this.stuff.length;i++){
        if (stuff[i]==obj){
          return true;
        }
      }
      return false;
    }

    /**
     * Cette méthode retourne le nombre de points de vie du vivant.
     *
     * @return Un integer qui représente les points de vie(PV) du vivant.
     *
     */
    public int getPointVie(){
        return PV;
    }

    /**
     * Cette méthode retourne le nombre de points de force du vivant.
     *
     * @return Un integer qui représente les points de force(PF) du vivant.
     *
     */
    public int getPointForce(){
        return PF;
    }

    /**
     * Cette méthode retourne si le vivant est mort ou non.Si ses points de vie sont inférieurs ou égaux à 0 le vivant est mort.
     *
     * @return Un booléen qui informe si le vivant est mort ou non.
     *
     */
    public boolean estMort(){
        return (!(PV > 0));
    }

    /**
     * Cette méthode retourne un string listant les caractéristiques du vivant. Son nom, le monde dans lequel il est, la pièce dans laquelle il est, son stuff, ses PV et ses PF.
     *
     * @return Un String listant les caractéristiques du vivant.
     *
     */
    public String toString(){
        String str="";
        str = str+"Nom: "+getNom()+"\n";
        str = str+"Monde: "+getMonde().getNom()+"\n";
        str = str+"PV: "+getPointVie()+"\n";
        str = str+"PF: "+getPointForce()+"\n";
        for (int i =0;i<stuff.length;i++){
          str = str+" "+stuff[i].getNom();
        }
        return str;
    }
}
