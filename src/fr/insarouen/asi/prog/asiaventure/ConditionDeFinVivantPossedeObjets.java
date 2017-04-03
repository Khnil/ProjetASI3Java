package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;

public class ConditionDeFinVivantPossedeObjets extends ConditionDeFin{
    private Vivant vivantQuiDoitPosseder;
    private Objet[] objetsAPosseder;

    public ConditionDeFinVivantPossedeObjets(EtatDuJeu etatConditionVerifiee, Vivant vivant, Objet[] objets){
        super(etatConditionVerifiee);
        this.vivantQuiDoitPosseder = vivant;
        this.objetsAPosseder = objets;
    }

    public EtatDuJeu verifierCondition(){
        boolean possedeTout = true;
        int i = 0;
        while (possedeTout && i<objetsAPosseder.length){
            if(!vivantQuiDoitPosseder.possede(objetsAPosseder[i])){
                possedeTout = false;
            }
            i=i+1;
        }
        if(possedeTout){
            return this.getEtatConditionVerifiee();
        }
        else{
            return EtatDuJeu.ENCOURS;
        }
    }
}
