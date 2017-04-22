package fr.insarouen.asi.prog.asiaventure.materiel.structure;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.materiel.Entite;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ElementStructurel;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.Vivant;
import java.lang.Object;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.VivantAbsentDeLaPieceException;

/**
 * Classe qui permet de décrire une pièce.Celle ci est composée d'une liste d'objets, d'une liste de vivants présents à l'intérieur et d'une liste de portes.. <br>
 * Cette classe hérite de la classe ElementStructurel. elle possède donc un nom et un monde.
 *
 * @see ElementStructurel
 *
 * @author Tom / Constantin
 * @version 2.1
 */
public class Piece extends ElementStructurel implements java.io.Serializable {

    private HashMap <String,Objet> objets= new HashMap<String,Objet>();//HashMap
    private HashMap <String,Vivant> vivants= new HashMap<String,Vivant>();//HashMap
    private HashMap<String,Porte> portes = new HashMap<String,Porte>();

    /**
     * Lors de la construction d'une pièce, le constructeur de la classe ElementStructurel est appelé avec le nom de la pièce et le monde associé.
     *
     * @param nom
     *        Le nom de l'ElementStructurel
     * @param monde
     *        Le monde concerné
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *        Renvoie l'exception d'un nom déjà utilisé dans monde.
     */
    public Piece(String nom, Monde monde) throws NomDEntiteDejaUtiliseDansLeMondeException{
        super(nom, monde);
    }

    /**
     * Cette fonction ajoute obj dan la liste des objets présxents dans la pièce. Elle agrandit le tableau objets d'une case pour mettre obj dans la dernière case qui vient d'être créée.
     *
     * @param obj
     *        L'objet que l'on cherche à ajouter à la pièce.
     *
     */
    public void deposer(Objet obj){
        this.objets.put(obj.getNom(),obj);
    }

    /**
     * Cette fonction retire l'objet de nom 'nom' de la pièce. Elle diminue également la taille du tableau objets d'une case. Elle retourne enfin l'objet en question.
     * Pour ce faire elle vérifie la présence de l'objet au préalable dans la pièce avant de le supprimer du tableau. Si celui ci n'est pas dans la pièce la méthode renvoie une exception et la fonction renvoie null.
     * De même si l'objet n'est pas déplacable (et donc impossible à enlever de la pièce) la méthode renvoie une exception.
     *
     * @param nom
     *      Le nom de l'objet que l'on cherche à retirer.
     *
     * @return L'objet dont le nom est 'nom' ou null si celui ci n'est pas présent.
     *
     * @throws ObjetAbsentDeLaPieceException
     *      Renvoie l'exception d'un objet absent de la pièce.
     * @throws ObjetNonDeplacableException
     *      Renvoie l'exception de si l'objet n'est pas déplacable.
     */
    public Objet retirer(String nom) throws ObjetAbsentDeLaPieceException,
                     ObjetNonDeplacableException{
          if(!(this.objets.containsKey(nom))) {
            throw new ObjetAbsentDeLaPieceException("L'objet "+nom+" à retirer n'est pas dans la pièce "+this.getNom()+".");
          }
          Objet obj = objets.remove(nom);
          if(!obj.estDeplacable()){
             deposer(obj);
            throw new ObjetNonDeplacableException("L'objet "+nom+" n'est pas déplacable.");
          }
          return obj;
    }


    /**
     * Il s'agit de la fonction retirer sur un objet mais avec l'objet en entrée et non son nom.
     *
     * @param obj
     *        L'objet que l'on cherche à retirer.
     *
     * @return L'objet que l'on a retiré de la pièce.
     *
     * @throws ObjetAbsentDeLaPieceException
     *      Renvoie l'exception d'un objet absent de la pièce.
     * @throws ObjetNonDeplacableException
     *      Renvoie l'exception de si l'objet n'est pas déplacable.
     */
    public Objet retirer(Objet obj) throws ObjetAbsentDeLaPieceException,
                     ObjetNonDeplacableException{
        return retirer(obj.getNom());
    }

    /**
     * Cette méthode vérifie la présence de l'objet de nom "nom" dans le tableau objets et retourne la réponse sous forme de booléen.
     *
     * @param nom
     *        Le nom de l'objet dont on cherche à vérifier la présence.
     *
     * @return Un booléen
     *
     */
    public boolean contientObjet(String nom){
        return this.objets.containsKey(nom);
    }

    /**
     *Cette méthode vérifie la présence de l'objet obj dans le tableau objets et retourne la réponse sous forme de booléen.
     *
     * @param obj
     *        L'objet dont on cherche à vérifier la présence dans la pièce.
     * @return booleen vrai si la piece contient l'objet, faux sinon.
     */
    public boolean contientObjet(Objet obj){
        return contientObjet(obj.getNom());
    }

    /**
     *Cette méthode renvoie un string listant les caractéristiques de la pièce. son nom, le monde dans lequel ell est ainsi que les objets et les vivants qu'elle contient.
     *
     * @return Un string listant les caractéristiques de la pièce.
     *
     */
    public String toString(){
        StringBuilder laChaine = new StringBuilder("");
        laChaine.append("Piece: ");
        laChaine.append(this.getNom());
        laChaine.append("\n Objets: \n");
        for(Objet o : this.objets.values()){
            laChaine.append(String.format(" \t - %s \n",o.getNom()));
        }
        laChaine.append("\n");
        return laChaine.toString();
    }

    /**
     *Cette méthode Fait entrer le vivant dans la pièce. Pour cela il grandit le tableau vivants d'une case et place le nouveau vivant dans la dernière case du tableau.
     *
     * @param vivant
     *      Le vivant qui entre dans la pièce.
     *
     */
    public void entrer(Vivant vivant){
        this.vivants.put(vivant.getNom(),vivant);
    }

    /**
     * Il s'agit de la fonction sortir sur un vivant mais avec le vivant en entrée et non son nom.
     *
     * @param vivant
     *        Le vivant que l'on cherche à retirer.
     *
     * @return Le vivant que l'on a retiré de la pièce.
     *
     * @throws VivantAbsentDeLaPieceException
     *      Renvoie l'exception du vivant absent de la pièce.
     *
     */
    public Vivant sortir(Vivant vivant) throws VivantAbsentDeLaPieceException{
        return sortir(vivant.getNom());
    }

    /**
     * Cette fonction fait sortir le vivant de nom 'nom' de la pièce. Elle diminue également la taille du tableau vivants d'une case. Elle retourne enfin le vivant en question.
     * Pour ce faire elle vérifie la présence du vivant au préalable dans la pièce avant de le supprimer du tableau. Si celui ci n'est pas dans la pièce la méthode renvoie une exception et la fonction renvoie null.
     *
     * @param nomVivant
     *      Le nom du vivant que l'on cherche à retirer.
     *
     * @return Le vivant dont le nom est 'nom' ou null si celui ci n'est pas présent.
     *
     * @throws VivantAbsentDeLaPieceException
     *      Renvoie l'exception d'un objet absent de la pièce.
     *
     */
    public Vivant sortir(String nomVivant) throws VivantAbsentDeLaPieceException{
            if(!(this.vivants.containsKey(nomVivant))) {
              throw new VivantAbsentDeLaPieceException("Le vivant "+nomVivant+" n'est pas dans la pièce "+this.getNom()+".");
            }
            Vivant vivant = this.vivants.get(nomVivant);
            this.vivants.remove(nomVivant);
        return vivant;
    }

    /**
     *Cette méthode vérifie la présence du vivant 'vivant' dans le tableau vivants et retourne la réponse sous forme de booléen.
     *
     * @param vivant
     *        Le vivant dont on cherche à vérifier la présence dans la pièce.
     * @return un booleen vrai si la piece contient le vivant, non sinon.
     */
    public boolean contientVivant(Vivant vivant){
        return contientVivant(vivant.getNom());
    }

    /**
     *Cette méthode vérifie la présence de l'objet obj dans le tableau objets et retourne la réponse sous forme de booléen.
     *
     * @param nomVivant
     *        Le nom de l'objet dont on cherche à vérifier la présence dans la pièce.
     * @return un booleen vrai si la piece contient le vivant, non sinon.
     */
    public boolean contientVivant(String nomVivant){
        return this.vivants.containsKey(nomVivant);
    }

    /**
     *Cette méthode renvoie le tableau objets
     *
     * @return Le tableau objets de la pièce.
     *
     */
    public HashMap<String,Objet> getObjets(){
      return objets;
    }

    /**
     * Cette méthode ajoute une porte aux portes de la Piece.
     *
     * @param porte
     *        porte à ajouter
     */
    protected void addPorte(Porte porte){
      this.portes.put(porte.getNom(),porte);
    }

    /**
     * Cette méthode vérifie si une porte est bien présente dans la pièce.
     *
     * @param nomPorte
     *        porte donc on vérifie la présence.
     *
     * @return Un booléen informant si la porte est bien présente dans la pièce.
     */
    public boolean aLaPorte(String nomPorte){
        return this.portes.containsKey(nomPorte);
    }

    /**
     * Cette méthode vérifie si une porte est bien présente dans la pièce.
     *
     * @param porte
     *        porte donc on vérifie la présence.
     *
     * @return Un booléen informant si la porte est bien présente dans la pièce.
     */
    public boolean aLaPorte(Porte porte){
        return aLaPorte(porte.getNom());
    }

    /**
     * Cette méthode retourne la porte de la pièce qu'on cherche.
     *
     * @param nomPorte
     *         nom de la porte qu'on cherche à retourner.
     *
     * @return La porte dont on a donné le nom.
     */
    public Porte getPorte(String nomPorte){
        return this.portes.get(nomPorte);
    }

    /**
     * Cette méthode retourne l'ensemble des portes de la pièce.
     *
     * @return Une map de portes.
     */
    public Map<String,Porte> getPortes(){
        return this.portes;
    }

}
