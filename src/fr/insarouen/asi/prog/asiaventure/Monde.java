package fr.insarouen.asi.prog.asiaventure;

import java.io.Serializable;
import java.lang.String;
import java.util.Arrays;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;

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
 * @version 1.0
 */
public class Monde implements Serializable{
    /**
     * Le nom du monde.
     */
  private String nom;
  /**
   * Une map  (String,Entite) initialisée à nulle contenant les Entite du monde.
   */
  private Entite[] entites= new Entite[0];

  /**
   * Constructeur Monde <br>
   * A la construction d'un objet Monde, le "nom" du Monde est fixé.
   *
   * @param nomDuMonde
   *        Le nom du Monde utilisé pour la creation de ce dernier
   */
    public Monde(String nomDuMonde){
      this.nom = nomDuMonde;
    }

    /**
     * Ajoute une entite à la map "entites" du monde.
     *
     * @param entite
     *        entite à ajouter
     */
    public void ajouter(Entite entite){
      entites = Arrays.copyOf(entites, entites.length+1);
      entites[entites.length-1]= entite;
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
     boolean trouve = false;
     int i=0;
     Entite entiteCherchee = null;
      while(!trouve && i<entites.length){
        if(entites[i].getNom()==nomEntite){
          trouve = true;
          entiteCherchee=this.entites[i];
        }else i++;
      }
      return entiteCherchee;
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
      String str=nom+"\n";
      for (int i =0;i<entites.length;i++){
        str = str+" "+entites[i].getNom();
      }
      return str;
    }
}