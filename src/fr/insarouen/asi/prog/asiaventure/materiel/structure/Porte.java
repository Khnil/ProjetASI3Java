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
        //a completer
    }

    public void activerAvec(Objet obj) throws ActivationImpossibleAvecObjetException, ActivationImpossibleException{
        if (!activableAvec(obj))
            throw new ActivationImpossibleAvecObjetException("L'objet "+obj.getNom()+" ne permet pas d'ouvrir la porte "+this.getNom());

    }

    public Etat getEtat(){
        return this.etat;
    }
}
