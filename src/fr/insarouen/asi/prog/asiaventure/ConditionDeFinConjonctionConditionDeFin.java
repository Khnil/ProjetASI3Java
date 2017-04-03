package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;

public class ConditionDeFinConjonctionConditionDeFin extends ConditionDeFin{

    private ConditionDeFin [] conditionsAVerifier;

    ConditionDeFinConjonctionConditionDeFin(EtatDuJeu etatDuJeu, ConditionDeFin... cfs){
        super(etatDuJeu);
        conditionsAVerifier = new ConditionDeFin[cfs.length];
        for(int i=0;i< cfs.length;i++){
            this.conditionsAVerifier[i]=cfs[i];
        }
    }

    public EtatDuJeu verifierCondition(){
        EtatDuJeu etatDeSortie = this.getEtatConditionVerifiee();
        int i = 0;
        while(etatDeSortie != EtatDuJeu.ENCOURS && i<conditionsAVerifier.length){
            etatDeSortie = conditionsAVerifier[i].verifierCondition();
            i=i+1;
        }
        if(etatDeSortie==EtatDuJeu.ENCOURS){
            return this.getEtatConditionVerifiee();
        }
        else {
            return EtatDuJeu.ENCOURS;
        }
    }
}
