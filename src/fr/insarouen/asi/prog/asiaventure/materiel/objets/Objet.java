package fr.insarouen.asi.prog.asiaventure.materiel.objets;

import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;

/**
 * Classe de base pour représenter les objets.<br>
 * Cette classe hérite de la classe Entite (avec la déplacabilité en plus). <br>
 *
 * @see Entite
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public abstract class Objet extends Entite {

    /**
     * Constructeur Objet. <br>
     * A la construction d'un objet Objet, le constructeur de la classe Entite est appelé
     * avec le nom de l'Objet et le monde concerné.
     * Objet étant un abstract, celui ci ne peut donc être instancié.
     * Les tests se feront donc sur la classe PiedDeBiche.
     *
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom d'entité utilisé comme doublon dans monde.
     * @param nom
     *        Nom de l'Objet
     * @param monde
     *        Monde concerné
     */
  public Objet(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
    super(nom,monde);
  }

  /**
   * @return un booléen suivant la déplacabilité de l'Objet.
   */
  public abstract boolean estDeplacable();
}
