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

/**
 * Porte est une classe permettant de manipuler une porte entre deux pieces.
 *
 * @author Tom Constantin
 * @version 1.0
 */
public class Porte extends ElementStructurel implements Activable{

    private Piece pieceA;
    private Piece pieceB;
    private Etat etat;

    public Porte(String nom, Monde monde, Piece pieceA,Piece pieceB) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
        this.pieceA=pieceA;
        this.pieceB=pieceB;
        pieceA.addPorte(this);
        pieceB.addPorte(this);
        this.etat = Etat.FERME;
    }

    public boolean activableAvec(Objet obj){
        if (this.getEtat().equals(Etat.CASSE))
            return false;
        if (obj instanceof PiedDeBiche)
            return true;
    }

    public void activer() throws ActivationImpossibleException{
        if (!((this.getEtat().equals(Etat.FERME)) || (this.getEtat().equals(Etat.OUVERT))))
            throw new ActivationImpossibleException("Porte impossible à activer.");
        if (this.etat.equals(Etat.FERME))
            this.etat = Etat.OUVERT;
        if (this.etat.equals(Etat.OUVERT))
            this.etat = Etat.FERME;
    }

    public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException, ActivationImpossibleException{
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

    public Etat getEtat(){
        return this.etat;
    }

    public Piece getPieceAutreCote(Piece piece){
        if (piece.equals(pieceA))
          return pieceB;
        else
          return pieceA;
    }

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
}
