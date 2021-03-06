package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Classe qui permet de décrire la structure d'un élement. <br>
 *
 * @see Entite
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public abstract class ElementStructurel extends Entite {

    /**
     * Lors de la construction d'un objet ElementStructurel, le constructeur de la classe Entite est appelé avec le nom de l'elementStructurel et le monde associé.
     *
     * @param nom
     *        Le nom de l'ElementStructurel
     * @param monde
     *        Le monde concerné
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *         Propage l'exception NomDEntiteDejaUtiliseDansLeMondeException
     */
  public ElementStructurel (String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
  }
}
