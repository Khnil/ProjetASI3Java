package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import java.lang.String;;

public class Porte extends ElementStructurel implements Activable{

    private Piece pieceA;
    private Piece pieceB;
    private Etat etat;

    public Porte(String nom, Monde monde, Piece pieceA,Piece pieceB)throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
        this.pieceA=pieceA;
        this.pieceB=pieceB;
        pieceA.addPorte(this);
        pieceB.addPorte(this);
    }

    public void activer()throws ActivationImpossibleException{
    }

    public Etat getEtat(){
        return this.etat;
    }
}
