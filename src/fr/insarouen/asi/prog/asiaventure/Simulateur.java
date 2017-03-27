package fr.insarouen.asi.prog.asiaventure;

import java.lang.ClassNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import fr.insarouen.asi.prog.asiaventure.Monde;
import fr.insarouen.asi.prog.asiaventure.materiel.EtatDuJeu;
import java.util.Scanner;
import java.lang.String;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Piece;
import fr.insarouen.asi.prog.asiaventure.NomDEntiteDejaUtiliseDansLeMondeException;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie.Serrure;
import fr.insarouen.asi.prog.asiaventure.materiel.objets.serrurerie.Clef;
import fr.insarouen.asi.prog.asiaventure.materiel.structure.Porte;
import fr.insarouen.asi.prog.asiaventure.materiel.vivants.JoueurHumain;

public class Simulateur {
    private Monde monde;
    private EtatDuJeu jeu;

    public Simulateur(ObjectInputStream ois)throws IOException,ClassNotFoundException{
        this.monde = (Monde)ois.readObject();
        this.jeu = (EtatDuJeu)ois.readObject();
    }

    public Simulateur(Reader reader)throws IOException,NomDEntiteDejaUtiliseDansLeMondeException{
        jeu = EtatDuJeu.ENCOURS;
        Scanner scan = new Scanner(reader);
        do {
            switch(scan.next()){
                case "Monde" :
                lireMonde(scan);
                break;
                case "Piece" :
                lirePiece(scan);
                break;
                case "PorteSerrure" :
                lirePorteSerrure(scan);
                break;
                case "Porte" :
                lirePorte(scan);
                break;
                case "Clef" :
                lireClef(scan);
                break;
                case "JoueurHumain" :
                lireJoueurHumain(scan);
                break;
            }
        } while (scan.hasNext());
    }

    public void enregistrer(ObjectOutputStream oos)throws IOException{
        oos.writeObject(this.monde);
        oos.writeObject(this.jeu);
    }

    private void lireMonde(Scanner scan){
        String nomMonde = scan.next();
        nomMonde = nomMonde.substring(1,nomMonde.length()-1);
        this.monde = new Monde(nomMonde);
    }

    private void lirePiece(Scanner scan)throws NomDEntiteDejaUtiliseDansLeMondeException{
        String nomPiece = scan.next();
        nomPiece = nomPiece.substring(1,nomPiece.length()-1);
        new Piece(nomPiece,this.monde);
    }

    private void lirePorteSerrure(Scanner scan)throws NomDEntiteDejaUtiliseDansLeMondeException{
        String nomPorteSerrure = scan.next();
        nomPorteSerrure = nomPorteSerrure.substring(1,nomPorteSerrure.length()-1);
        String nomPremierePiece = scan.next();
        nomPremierePiece = nomPremierePiece.substring(1,nomPremierePiece.length()-1);
        String nomSecondePiece = scan.next();
        nomSecondePiece = nomSecondePiece.substring(1,nomSecondePiece.length()-1);
        new Porte(nomPorteSerrure,this.monde,new Serrure(this.monde),new Piece(nomPremierePiece,this.monde),new Piece(nomSecondePiece,this.monde));
    }

    private void lirePorte(Scanner scan)throws NomDEntiteDejaUtiliseDansLeMondeException{
        String nomPorte = scan.next();
        nomPorte = nomPorte.substring(1,nomPorte.length()-1);
        String nomPremierePiece = scan.next();
        nomPremierePiece = nomPremierePiece.substring(1,nomPremierePiece.length()-1);
        String nomSecondePiece = scan.next();
        nomSecondePiece = nomSecondePiece.substring(1,nomSecondePiece.length()-1);
        new Porte(nomPorte,this.monde,new Piece(nomPremierePiece,this.monde),new Piece(nomSecondePiece,this.monde));
    }

    private void lireClef(Scanner scan)throws NomDEntiteDejaUtiliseDansLeMondeException{
        String nomPorte = scan.next();
        nomPorte = nomPorte.substring(1,nomPorte.length()-1);
        String nomPiece = scan.next();
        nomPorte = nomPiece.substring(1,nomPiece.length()-1);
        Porte porte = (Porte)this.monde.getEntite(nomPorte);
        Piece piece = (Piece)this.monde.getEntite(nomPiece);
        Clef clef = porte.getSerrure().creerClef();
        piece.deposer(clef);
    }

    private void lireJoueurHumain(Scanner scan)throws NomDEntiteDejaUtiliseDansLeMondeException{
        String nomHumain = scan.next();
        nomHumain = nomHumain.substring(1,nomHumain.length()-1);
        int pv = scan.nextInt();
        int pf = scan.nextInt();
        String nomPiece = scan.next();
        nomPiece = nomPiece.substring(1,nomPiece.length()-1);
        Piece piece = (Piece)this.monde.getEntite(nomPiece);
        new JoueurHumain(nomHumain,this.monde,pv,pf,piece);
    }

}
