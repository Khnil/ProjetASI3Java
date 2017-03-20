package fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie;
import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;


public final class Clef extends Objet{

    protected Clef(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
    }

    public boolean estDeplacable(){
        return true;
    }
}
