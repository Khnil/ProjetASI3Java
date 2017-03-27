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
     */
     public JoueurHumain(String nom, Monde monde, int pv, int pf, Piece piece) throws NomDEntiteDejaUtiliseDansLeMondeException {
       super(nom,monde,pv,pf,piece);
       ordreAFaire = null;
     }

     public void setOrdre(java.lang.String ordre){
         this.ordreAFaire = ordre;
     }

     private void commandePrendre(String nomObjet)throws ObjetAbsentDeLaPieceException, ObjetNonDeplacableException{
         this.prendre(nomObjet);
     }

     private void commandePoser(String nomObjet)throws ObjetNonPossedeParLeVivantException{
         this.deposer(nomObjet);
     }

     private void commandeFranchir(String nomPorte)throws PorteFermeException, PorteInexistanteDansLaPieceException{
         this.franchir(nomPorte);
     }

     private void commandeOuvrirPorte(String nomPorte)throws ActivationException, PorteInexistanteDansLaPieceException{
         this.activerActivable(this.getPiece().getPorte(nomPorte));
     }

     private void commandeOuvrirPorte(String nomPorte, String nomObjet)throws ActivationException, PorteInexistanteDansLaPieceException,ObjetNonPossedeParLeVivantException{
         this.activerActivableAvecObjet(this.getPiece().getPorte(nomPorte),this.getObjet(nomObjet));
     }

     public void executer() throws java.lang.Throwable{

     }

}
