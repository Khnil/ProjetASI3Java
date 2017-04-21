package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.Activable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.Etat;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie.Serrure;

/**
 * Porte est une classe permettant de manipuler une porte entre deux pieces. Cette classe est composée de deux pièces et d'un état.
 *
 * @author Tom Constantin
 * @version 1.0
 */
public class Porte extends ElementStructurel implements Activable{

    private Piece pieceA;
    private Piece pieceB;
    private Etat etat;
    private Serrure serrure=null;

    /**
     * Lors de la construction d'une porte, le constructeur de la classe ElementStructurel est appelé avec le nom de la pièce et le monde associé.
     * On renseigne ensuite les deus pièces que la porte relie. L'état de base d'une porte est fermé.
     *
     * @param nom
     *        Le nom de l'ElementStructurel
     * @param monde
     *        Le monde concerné
     * @param pieceA
     *        La première piece reliée par la porte.
     * @param pieceB
     *        La seconde pièce reliée par la porte.
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom déjà utilisé dans monde.
     */
    public Porte(String nom, Monde monde, Piece pieceA,Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
        this.pieceA=pieceA;
        this.pieceB=pieceB;
        pieceA.addPorte(this);
        pieceB.addPorte(this);
        this.etat = Etat.FERME;
    }

    /**
     * Lors de la construction d'une porte, le constructeur de la classe ElementStructurel est appelé avec le nom de la pièce et le monde associé.
     * On renseigne ensuite les deux pièces que la porte relie. Si le constructeur comprend également une serrure alors la porte est con sidérée comme verouillée et elle est liée à la serrure en question.
     *
     * @param nom
     *        Le nom de l'ElementStructurel
     * @param monde
     *        Le monde concerné
     * @param pieceA
     *        La première piece reliée par la porte.
     * @param pieceB
     *        La seconde pièce reliée par la porte.
     * @param serrure
     *        La serrure qui est entre les deux pièces reliées par la porte.
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom déjà utilisé dans monde.
     */
    public Porte(String nom, Monde monde,Serrure serrure, Piece pieceA,Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
        this(nom,monde,pieceA,pieceB);
        this.serrure = serrure;
        this.etat = Etat.VERROUILLE;

    }

    /**
     * cette méthode retourne avec un booléen si la porte en question est ouvrable avec l'objet en paramètre. Si la porte est cassée alors elle n'est pas ouvrable. Si l'objet est un pied de biche alors la porte est ouvrable.
     *
     * @param obj
     *        L'objet que l'on cherche à utiliser pour ouvrir la porte.
     * @return
     *        Un booléen informant si la porte est ouvrable avec l'objet donné ou non.
     *
     */
    public boolean activableAvec(Objet obj){
        if (this.getEtat().equals(Etat.CASSE))
            return false;
        if (obj instanceof PiedDeBiche)
          return true;
        if(this.serrure != null){
            return this.serrure.activableAvec(obj);
        }
        return true;
    }

    /**
     * Cette fonction active la porte. Si celle ci était fermée elle passe à ouvert, à l'inverse ouvert passe à fermé. Si la porte est vérouillée on recoit l'erreur d'activation impossible.
     *
     * @throws ActivationImpossibleException
     *        retourne l'erreur d'une entité inctivable.
     *
     */
    public void activer() throws ActivationImpossibleException{
        if (!((this.getEtat().equals(Etat.FERME))||(this.getEtat().equals(Etat.OUVERT))))
          throw new ActivationImpossibleException("Porte impossible à activer");

        this.etat = (this.etat.equals(Etat.FERME))? Etat.OUVERT : Etat.FERME;
    }

    /**
     * Cette fonction active la porte en question avec l'objet donné en paramètre. Si la porte n'est pas activable avec l'objet donné l'erreur d'activation impossible avec l'objet est renvoyée.
     * Si l'objet est un pied de biche la porte prend l'état cassé. Sinon il s'agit d'un activation normale.
     *
     * @param obj
     *        L'objet qu'on cherche à utiliser pour ouvrir la porte.
     * @throws ActivationImpossibleAvecObjetException
     *        retourne l'erreur d'une entité inactivable avec l'objet.
     *
     */
    public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException{
        if (!activableAvec(obj))
            throw new ActivationImpossibleAvecObjetException("L'objet "+obj.getNom()+" ne permet pas d'ouvrir la porte "+this.getNom());
        if (obj instanceof PiedDeBiche && ((this.getEtat()==Etat.FERME) ||(this.getEtat()==Etat.VERROUILLE))){
          this.etat = Etat.CASSE;
         //ouvrir serrure
        }
        if (this.getEtat().equals(Etat.VERROUILLE))
            this.etat = Etat.OUVERT;
          else
            this.etat = Etat.VERROUILLE;
    }

    /**
     * Cette méthode retourne l'état de la porte.
     *
     * @return
     *        L'état de la porte.
     *
     */
    public Etat getEtat(){
        return this.etat;
    }

    /**
     * Cette méthode retourne l'une des deux pièces de la porte.
     * si la pièce entrée en paramètre est la pièce A alors la méthode retournera la pièce B.
     * si la pièce entrée en paramètre est n'importe quelle autre pièce (pièce B y compris) alors la méthode retournera la pièce A.
     *
     * @param piece
     *        La pièce a partir de laquelle on cherche à savoir la pièce de l'autre coté.
     * @return
     *        La pièce de l'autre coté de la porte. A partir de la pièce donnée.
     */
    public Piece getPieceAutreCote(Piece piece){
        if (piece.equals(pieceA))
          return pieceB;
        else
          return pieceA;
    }

    /**
     * Méthode toString renvoyant le nom de la porte, le monde dans lequel elle se trouve,les deux pièces auxquelles elle est liée ainsi que son état. Le tout sous la forme d'un string.
     *
     * @return
     *        Un string listant les caractéristiques de la porte.
     */
    public String toString(){
      StringBuilder laChaine = new StringBuilder("");
      laChaine.append("\n Nom: ");
      laChaine.append(this.getNom());
      laChaine.append("\n Monde: ");
      laChaine.append(this.getMonde());
      laChaine.append("\n Piece A: ");
      laChaine.append(this.pieceA.getNom());
      laChaine.append("\n Piece B: ");
      laChaine.append(this.pieceB.getNom());
      laChaine.append("\n Piece Etat: ");
      laChaine.append(getEtat());
      laChaine.append("\n");
      return laChaine.toString();
    }

    public Serrure getSerrure(){
        return this.serrure;
    }
}
