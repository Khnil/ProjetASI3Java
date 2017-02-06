package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;

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
     */
  public ElementStructurel (String nom, Monde monde){
    super(nom,monde);
  }
}
