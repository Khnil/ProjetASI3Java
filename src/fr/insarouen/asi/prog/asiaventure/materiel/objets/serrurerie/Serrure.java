package fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie;
import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.materiel.Activable;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleAvecObjetException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.Etat;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.PiedDeBiche;

public class Serrure extends Objet implements Activable{

    /**
     * Clef permettant d'ouvrir la Serrure.
     */
    private Clef clef;

    /**
     * Etat de la Serrure.
     */
    private Etat etat;

    public Serrure(Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        this(creerNomAlea("Serrure"),monde);
    }

    public Serrure(String nom,Monde monde)throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
        clef = creerClef();
        etat = Etat.VERROUILLE;
    }

    public final Clef creerClef(){
        if (this.clef == null)
        {
            do{
                try{
                    this.clef = new Clef(creerNomAlea("Clef")+this.getMonde(),this.getMonde());
                    }
                catch (NomDEntiteDejaUtiliseDansLeMondeException e) {
                //on retire un nom aleatoire
                }
            }while(clef==null);

        return this.clef;
    }
    else    return null;

    }

    public void activerAvec(Objet obj)throws ActivationImpossibleAvecObjetException,ActivationImpossibleException{
        if (!activableAvec(obj)){
          throw new ActivationImpossibleAvecObjetException(String.format("Activation impossible avec l'objet %s",obj.getNom()));
        }

        if ((obj instanceof PiedDeBiche)&& this.getEtat()==Etat.VERROUILLE)
            this.etat = Etat.CASSE;
        else if (this.etat == Etat.VERROUILLE)
                this.etat = Etat.DEVERROUILLE;
        else this.etat = Etat.VERROUILLE;

    }

    public boolean estDeplacable(){
        return false;
    }

    public boolean activableAvec(Objet obj){
        if (this.getEtat().equals(Etat.CASSE))
            return false;
        else if ((obj instanceof PiedDeBiche)||(obj.equals(this.clef)))
          return true;
                else return false;
    }

    public void activer()throws ActivationImpossibleException{
        throw new ActivationImpossibleException("Ouvrir une porte VERROUILLE sans clef ni PiedDeBiche? Non, je ne pense pas.");
    }

    public Etat getEtat(){
        return this.etat;
    }

    private static String creerNomAlea(String param) throws NomDEntiteDejaUtiliseDansLeMondeException{
        String nomAleatoire;

                int nombreAlea = (int)(MAXIMUMNOMALEATOIRE*Math.random());
                String nomAlea = String.format("%d",nombreAlea);

                if (param == "Serrure") {
                    nomAleatoire = String.format("Serrure numero %s",nomAlea);
                }
                else{
                    nomAleatoire = String.format("Clef %s de la serrure numero ",nomAlea);
                }

        return nomAleatoire;
    }
}
