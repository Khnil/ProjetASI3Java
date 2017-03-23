package fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie;
import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationImpossibleException;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.Monde;

/**
 * Classe qui permet de décrire une clef.Celle ci est un simple objet pouvant activer une porte en particulier. <br>
 * Cette classe hérite de la classe objet. elle possède donc un nom et un monde. Celle ci n'est pas déplaçable.
 *
 * @see Objet
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public final class Clef extends Objet{

    /**
     * Lors de la construction d'une clef, le constructeur de Objet est simplement utilisé.
     *
     * @param nom
     *        Le nom de la clé
     * @param monde
     *        Le monde concerné
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom déjà utilisé dans monde.
     */
    protected Clef(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom,monde);
    }

    /**
     * Une clef est déplacable.
     */
    public boolean estDeplacable(){
        return true;
    }
}
