package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;

public abstract class ConditionDeFinVivantMort extends ConditionDeFin{

    Vivant vivantQuiPeutMourir;

    public ConditionDeFinVivantMort(EtatDuJeu etatConditionVerifiee, Vivant vivant){
        super(etatConditionVerifiee);
        this.vivantQuiPeutMourir=vivant;
    }

    public EtatDuJeu verifierCondition(){
        if (vivantQuiPeutMourir.estMort()){
            return this.getEtatConditionVerifiee();
        }
        else {
            return EtatDuJeu.ENCOURS;
        }
    }
}
