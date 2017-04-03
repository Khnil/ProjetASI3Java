package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;

public abstract class ConditionDeFin extends java.lang.Object implements java.io.Serializable{

    private EtatDuJeu etatDeSortie;

    public ConditionDeFin(EtatDuJeu etatDuJeu){
        this.etatDeSortie=etatDuJeu;
    }

    public EtatDuJeu getEtatConditionVerifiee(){
        return this.etatDeSortie;
    }

    public abstract EtatDuJeu verifierCondition();
}
