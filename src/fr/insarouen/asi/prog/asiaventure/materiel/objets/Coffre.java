package fr.insarouen.asi.prog.asiaventure.materiel.objets;
import fr.insarouen.asi.prog.asiaventure.materiel.Activable;
import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.Etat;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleException;

/**
 * Classe qui permet de décrire un coffre.Celui ci est un simple objet doté d'une serrure.. <br>
 * Cette classe hérite de la classe objet. Elle possède donc un nom et un monde. Celui ci n'est pas déplaçable.
 * Cette classe implémente l'interface activable.
 *
 * @see Objet
 * @see Activable
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class Coffre extends Objet implements Activable{
    /**
     * Etat de la Serrure.
     */
    private Etat etat;

    /**
     * Lors de la construction d'un coffre, si on donne le nom du coffre ainsi que le nom de monde alors le constructeur de la classe objet est utilisé.
     * L'état de base d'un coffre est fermé.
     *
     * @param nom
     *        Le nom du coffre.
     * @param monde
     *        Le monde concerné
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom déjà utilisé dans monde.
     */
    public Coffre(String nom,Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
        this.etat = Etat.FERME;
    }

    /**
     * Un coffre n'est pas un objet déplaçable.
     */
    public boolean estDeplacable(){
        return false;
    }

    /**
     * Cette méthode informe si le coffre est activable avec l'objet donné.Si le coffre est cassée alors il n'est pas activable quel que soit l'objet. Sinon le coffre est activable avec n'importe quel objet.
     *
     * @param obj
     *        L'objet avec lequel on cherche à savoir si le coffre est activable.
     *
     * @return un booléen informant si le coffre est activable ou non avec l'objet donné.
     */
    public boolean activableAvec(Objet obj){
        if (this.getEtat().equals(Etat.CASSE))
          return false;
        else return true;
    }

    /**
     * Activer un coffre avec aucun objet donnera l'exception d'un objet nom activable si celui ci n'est ni fermé ni ouvert. Sinon cette méthode fait passer le coffre de ouvert à fermé et inversement.
     *
     */
    public void activer() throws ActivationImpossibleException{
        if (!((this.getEtat().equals(Etat.FERME))||(this.getEtat().equals(Etat.OUVERT))))
          throw new ActivationImpossibleException("Coffre impossible à activer");
        if (this.getEtat().equals(Etat.FERME))
                this.etat = Etat.OUVERT;
        else this.etat = Etat.FERME;
    }

    /**
     * Activer un coffre avec un objet reviens à utiliser la fonction activer sans objet mais avec la vérification que l'objet donné puisse l'activer auparavant.
     *
     */
    public void activerAvec(Objet obj)throws ActivationImpossibleAvecObjetException,ActivationImpossibleException{
        if (!activableAvec(obj)){
          throw new ActivationImpossibleAvecObjetException(String.format("Activation du coffre impossible avec l'objet %s",obj.getNom()));
        }
        this.activer();
    }

    /**
     * Cette méthode renvoie l'état du coffre.
     *
     * @return l'état du coffre.
     */
    public Etat getEtat(){
        return this.etat;
    }

    /**
     * Méthode toString renvoyant le nom du coffre.
     *
     * @return
     *        Un string listant les caractéristiques du coffre.
     */
    public String toString(){
        StringBuilder laChaine = new StringBuilder("Coffre : ");
        laChaine.append(String.format("%s ",getNom()));
        return laChaine.toString();
    }
}
