package fr.insarouen.asi.prog.asiaventure.materiel.vivants;

import java.util.*;
import fr.insarouen.asi.prog.asiaventure.materiel.Executable;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.ObjetNonDeplacableException;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.ObjetAbsentDeLaPieceException;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.ObjetNonPossedeParLeVivantException;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.PorteFermeException;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.PorteInexistanteDansLaPieceException;
import fr.insarouen.asi.prog.asiaventure.materiel.ActivationException;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.Objet;
import java.lang.reflect.*;

public class JoueurHumain extends Vivant implements Executable {

    private String ordreAFaire;

    /**
     * Constructeur JoueurHumain.<br>
     *
     * @param nom
     *        Le nom à associer au joueur
     * @param monde
     *        Le Monde auquel appartient le joueur
     * @param pv
     *        Les points de vie du joueur
     * @param pf
     *        Les points de force du joueur
     * @param piece
     *        La Piece dans laquelle se situe le joueur
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *         Propage l'exception NomDEntiteDejaUtiliseDansLeMondeException
     */
     public JoueurHumain(String nom, Monde monde, int pv, int pf, Piece piece) throws NomDEntiteDejaUtiliseDansLeMondeException {
       super(nom,monde,pv,pf,piece);
       ordreAFaire = null;
     }

    /**
     * Cette méthode sert à demander au joueur l'ordre qu'il veut donner à son avatar. Celui ci est enregistré par le biais d'un string qui se retrouve enregistré dans l'objet Joueur.
     *
     * @param ordre
     *         L'ordre que le personnage devra exécuter.
     */
     public void setOrdre(java.lang.String ordre){
         this.ordreAFaire = ordre;
     }

     /**
      * Cette méthode correspond à l'action de prendre un objet pour le joueurHumain.
      *
      * @param nomObjet
      *         Le nom de l'objet dont le joueur doit se saisir.
      *
      * @throws ObjetAbsentDeLaPieceException
      *         Renvoie l'erreur d'un objet à prendre qui n'est pas dans la même piece que le joueur.
      * @throws ObjetNonDeplacableException
      *         Renvoie l'erreur d'un objet que le joueur veut prendre qui n'est pas déplaçable.
      */
     private void commandePrendre(String nomObjet)throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
         this.prendre(nomObjet);
     }

     /**
      * Cette méthode correspond pour le joueur à l'action de déposer un objet de son stuff dans la pièce où il est présent.
      *
      * @param nomObjet
      *         Le nom de l'objet que le joueur veut déposer.
      *
      * @throws ObjetNonPossedeParLeVivantException
      *         Renvoie l'erreur d'un objet que le joueur ne possède pas et ne peut donc pas déposer.
      */
     private void commandePoser(String nomObjet)throws ObjetNonPossedeParLeVivantException{
         this.deposer(nomObjet);
     }

     /**
      * Cette méthode correspond pour le joueur à l'action de franchir une porte, changeant alors de pièce.
      *
      * @param nomPorte
      *         Le nom de la porte que le joueur veut franchir.
      *
      * @throws PorteFermeException
      *         Renvoie l'erreur d'une porte non traversable car fermée.
      * @throws PorteInexistanteDansLaPieceException
      *         Renvoie l'erreur d'une porte non présente dans la pièce où est le joueur et qu'il ne peut donc pas traverser.
      */
     private void commandeFranchir(String nomPorte)throws PorteFermeException, PorteInexistanteDansLaPieceException{
         this.franchir(nomPorte);
     }

     /**
      * Cette méthode correspond pour le joueur à l'action d'ouvrir une porte. (plus précisément de l'activer. Si la porte est déjà ouverte il va la fermer).
      *
      * @param nomPorte
      *         Le nom de la porte que le joueur veut activer.
      *
      * @throws ActivationException
      *         Renvoie l'erreur d'une porte non activable. (Parce que cassée ou verrouillée par exemple)
      * @throws PorteInexistanteDansLaPieceException
      *         Renvoie l'erreur d'une porte non présente dans la pièce où est le joueur et qu'il ne peut donc pas activer.
      */
     private void commandeOuvrirPorte(String nomPorte)throws ActivationException, PorteInexistanteDansLaPieceException{
         this.activerActivable(this.getPiece().getPorte(nomPorte));
     }

     /**
      * Cette méthode correspond pour le joueur à l'action d'ouvrir une porte, avec un objet en particulier. (plus précisément de l'activer. Si la porte est déjà ouverte il va la fermer).
      *
      * @param nomPorte
      *         Le nom de la porte que le joueur veut activer.
      * @param nomObjet
      *         Le nom de l'objet que le joueur veut utiliser pour activer la porte.
      *
      * @throws ActivationException
      *         Renvoie l'erreur d'une porte non activable. (Parce que cassée ou verrouillée par exemple)
      * @throws PorteInexistanteDansLaPieceException
      *         Renvoie l'erreur d'une porte non présente dans la pièce où est le joueur et qu'il ne peut donc pas activer.
      */
     private void commandeOuvrirPorte(String nomPorte, String nomObjet)throws ActivationException, PorteInexistanteDansLaPieceException,ObjetNonPossedeParLeVivantException{
         this.activerActivableAvecObjet(this.getPiece().getPorte(nomPorte),this.getObjet(nomObjet));
     }

     /**
      * Cette méthode n'est pas encore définie.
      */
     public void executer() throws CommandeImpossiblePourLeVivantException, Throwable{
            String[] mots = ordreAFaire.split(" ");
            String ordreDonne = mots[0];

            ordreDonne = ordreDonne.substring(0,1).toUpperCase()+ordreDonne.substring(1);
            String nomMethode = "commande"+ordreDonne;


            System.out.println("\n"+nomMethode+"\n");

            Class[] paramsFormels = new Class[mots.length-1];
            for (int i=0; i<paramsFormels.length;i++){
                paramsFormels[i]=java.lang.String.class;
            }

            try{
                Object[] objets = Arrays.copyOfRange(mots,1,mots.length);
                Method methode = this.getClass().getDeclaredMethod(nomMethode,paramsFormels);
                methode.invoke(this,objets);
            }
            catch(NoSuchMethodException e){
                throw new CommandeImpossiblePourLeVivantException("Problème avec '"+ nomMethode +"' : cette commande n'existe pas pour le vivant "+this.getNom());
            }
            catch(IllegalArgumentException e){
                throw new CommandeImpossiblePourLeVivantException("Problème avec la commande '"+ nomMethode +"' : Paramètres non valides");
            }
            catch(InvocationTargetException e){
                System.err.println(e.getCause().getMessage());
            }
     }

}
