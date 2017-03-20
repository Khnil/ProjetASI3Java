package fr.insarouen.asi.prog.asiaventure.materiel.objets;
import fr.insarouen.asi.prog.asiaventure.materiel.Activable;
import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.Etat;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleException;

public class Coffre extends Objet implements Activable{
    /**
     * Etat de la Serrure.
     */
    private Etat etat;

    public Coffre(String nom,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
        this.etat = Etat.FERME;
    }

    public boolean estDeplacable(){
        return false;
    }

    public boolean activableAvec(Objet obj){
        if (this.getEtat().equals(Etat.CASSE))
          return false;
        else return true;
    }

    public void activer() throws ActivationImpossibleException{
        if (!((this.getEtat().equals(Etat.FERME))||(this.getEtat().equals(Etat.OUVERT))))
          throw new ActivationImpossibleException("Coffre impossible à activer");
        if (this.getEtat().equals(Etat.FERME))
                this.etat = Etat.OUVERT;
        else this.etat = Etat.FERME;
    }

    public void activerAvec(Objet obj)throws ActivationImpossibleAvecObjetException,ActivationImpossibleException{
        if (!activableAvec(obj)){
          throw new ActivationImpossibleAvecObjetException(String.format("Activation du coffre impossible avec l'objet %s",obj.getNom()));
        }
        this.activer();
    }

    public Etat getEtat(){
        return this.etat;
    }

    public String toString(){
        StringBuilder laChaine = new StringBuilder("Coffre : ");
        laChaine.append(String.format("%s ",getNom()));
        return laChaine.toString();
    }
}
