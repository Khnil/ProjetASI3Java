package fr.insarouen.asi.prog.asiaventure;

import java.util.HashMap;
import java.io.Serializable;
import java.lang.String;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.EntiteDejaDansUnAutreMondeException;

/**
 * classe définissant un monde du jeu. <br>
 * Un Monde est défini par:
 * <ul>
 *    <li> Un nom, </li>
 *    <li> Une map(String,Entite). </li>
 * </ul>
 *
 * @see Entite
 *
 * @author Tom / Constantin
 * @version 2.0
 */
public class Monde implements Serializable{
    /**
     * Le nom du monde.
     */
  private String nom;
  /**
   * Une map  (String,Entite) initialisée à nulle contenant les Entite du monde.
   */
  private HashMap<String,Entite> entites; //HashMap

  /**
   * Constructeur Monde <br>
   * A la construction d'un objet Monde, le "nom" du Monde est fixé.
   *
   * @param nomDuMonde
   *        Le nom du Monde utilisé pour la creation de ce dernier
   */
    public Monde(String nomDuMonde){
      this.nom = nomDuMonde;
      entites = new HashMap<>();
    }

    /**
     * Ajoute une entite à la map "entites" du monde.
     *
     * @param entite
     *        entite à ajouter
     *
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom d'entite déjà présent dans monde.
     *
     * @throws EntiteDejaDansUnAutreMondeException
     *        Renvoie l'exception d'une entité déjà présente dans un autre monde que le monde actuel.
     */
    public void ajouter(Entite entite)throws NomDEntiteDejaUtiliseDansLeMondeException,
                EntiteDejaDansUnAutreMondeException{
          if(this.getEntite(entite.getNom())!=null){
              throw new NomDEntiteDejaUtiliseDansLeMondeException("Cette entite existe déjà dans ce monde.");
          }
      if(!(this.nom.equals(entite.getMonde().getNom()))){
        throw new EntiteDejaDansUnAutreMondeException("Cette entite est déjà présente dans un autre monde.");
      }
      this.entites.put(entite.getNom(),entite);
    }

    /**
     * Renvoie l'entite qui correspond au nom nomEntite si elle est présente dans entites.<br>
     * Renvoie null si l'entite n'est pas présente.
     *
     * @param nomEntite
     *        nom de l'entite recherchée
     *
     * @return L'entite correspondante si présente, null sinon
     */
    public Entite getEntite(String nomEntite){
      return entites.get(nomEntite);
    }

    /**
     * Retourne le nom du monde.
     *
     * @return Le nom du monde
     */
    public String getNom(){
      return nom;
    }

    /**
     * Renvoie une cdc contenant le nom d'un monde.
     * le nom d'un Monde.  <br>
     *
     * @return La cdc
     */
    public String toString(){
      StringBuilder laChaine = new StringBuilder("");
      laChaine.append(this.getNom());
      laChaine.append("\n Entités: \n");
      for(Entite e : this.entites.values()){
          laChaine.append(String.format(" \t - %s \n",e.getNom()));
      }
      laChaine.append("\n");
      return laChaine.toString();
    }
}
