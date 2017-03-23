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

/**
 * Classe qui permet de décrire une serrure.Celle ci décrit la clé qui permet de l'ouvrir ainsi que son état. <br>
 * Cette classe hérite de la classe objet. elle possède donc un nom et un monde. Celle ci n'est pas déplaçable.
 * Cette classe implémente l'interface Activable car une serrure est activable avec une clé ou un pied de biche.
 *
 * @see Objet
 * @see Activable
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class Serrure extends Objet implements Activable{

    /**
     * Clef permettant d'ouvrir la Serrure.
     */
    private Clef clef;

    /**
     * Etat de la Serrure.
     */
    private Etat etat;

    /**
     * Lors de la construction d'une serrure, si seulement un nom de monde est donné alors la serrure sera créée dans le monde donné avec un nom aléatoire.
     *
     * @param monde
     *        Le monde concerné
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom déjà utilisé dans monde.
     */
    public Serrure(Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        this(creerNomAlea("Serrure"),monde);
    }

    /**
     * Lors de la construction d'une serrure, se on donne le nom de serrure ainsi que le nom de monde alors le constructeur de la classe objet est utilisé. Il est ensuite créé la clé qui permet d'ouvrir cette serrure.
     * L'état de base d'une serrure est verrouillé.
     *
     * @param nom
     *        Le nom de la serrure.
     * @param monde
     *        Le monde concerné
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom déjà utilisé dans monde.
     */
    public Serrure(String nom,Monde monde)throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
        clef = creerClef();
        etat = Etat.VERROUILLE;
    }

    /**
     * Si la clé n'existe pas déjà, la création d'une clé consiste en l'utilisation du constructeur de la classe clef avec un nom de clé aléatoire ainsi que le nom du monde de la porte qui a appelé cette méthode. Si le nom est déjà utilisé on tire un nouveau nom aléatoire.
     * Une fois que cette clé est créée on la retourne.
     *
     * @return un objet clef créé avec un nom aléatoire. (ou rien du tout si celle ci existe déjà)
     */
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

    /**
     * Tout d'abord la méthode étudie si la serrure est activable avec l'objet. Si l'objet utilisé par la methode est un pied de biche alors la serrure prend l'état cassé.
     * Sinon, si la serrure était vérouillée alors elle prend l'état déverouillé. Si la serrure avais n'importe quel autre état elle prend l'état verouillé.
     *
     * @param obj
     *        L'objet avec lequel on cherche à activer la serrure.
     *
     * @throws ActivationImpossibleAvecObjetException
     *        Renvoie l'erreur d'un activation de la serrure impossible avec l'objet donné.
     *
     * @throws ActivationImpossibleException
     *        Renvoie l'erreur d'une activation de la serrure impossible.
     */
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

    /**
     * Une serrure n'est pas un objet déplaçable.
     */
    public boolean estDeplacable(){
        return false;
    }

    /**
     * Cette méthode informe si la serrure est activable avec l'objet donné.Si la serrure est cassée alors elle n'est pas activable quel que soit l'objet. Sinon si l'objet est un pied de biche ou la clé correspondant à la serrure alors on renvoie vrai.
     *
     * @param obj
     *        L'objet avec lequel on cherche à savoir si la serrure est activable.
     *
     * @return un booléen informant si la serrure est activable ou non avec l'objet donné.
     */
    public boolean activableAvec(Objet obj){
        if (this.getEtat().equals(Etat.CASSE))
            return false;
        else if ((obj instanceof PiedDeBiche)||(obj.equals(this.clef)))
          return true;
                else return false;
    }

    /**
     * Tenter d'activer une serrure avec rien est impossible et renvoie automatiquement un exception d'activation impossible.
     *
     */
    public void activer()throws ActivationImpossibleException{
        throw new ActivationImpossibleException("Ouvrir une porte VERROUILLE sans clef ni PiedDeBiche? Non, je ne pense pas."); // MDR tu t'es pris pour McGyver?
    }

    /**
     * Cette méthode renvoie l'état de la serrure.
     *
     * @return l'état de la serrure.
     */
    public Etat getEtat(){
        return this.etat;
    }

    /**
     * Cette méthode créée un nom aléatoire en ajoutant un nombre au string donné.
     *
     * @param param
     *        le début du nom aléatoire auquel on va ajouter un chiffre.
     *
     * @return un string avec le string donné et un nombre aléatoire derrière.
     */
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
