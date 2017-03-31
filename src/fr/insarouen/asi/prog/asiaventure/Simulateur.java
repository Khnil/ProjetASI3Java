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

/**
 * Classe Simulateur, celle ci comporte le monde présent et l'état du jeu. Elle sert nottament à mettre en place le jeu à l'aide de fichiers de sauvegarde.<br>
 *
 * @author Tom / Constantin
 * @version 1.0
 */
public class Simulateur {
    private Monde monde;
    private EtatDuJeu jeu;

    /**
     * Constructeur de Simulateur. Avec un ObjectInputStream le simulateur prend simplement comme nom de monde le nom du monde actuel et comme état de jeu l'état de jeu actuel.
     *
     * @param ois
     *          L'ObjectInputStream qui sert à récuperer monde et jeu.
     *
     * @throws IOException
     *          Renvoie toute erreur relative à un flux d'entrée d'objets. (IOS)
     * @throws ClassNotFoundException
     *          Renvoie toute erreur relative à l'utilisation de classes qui n'existent pas.
     */
    public Simulateur(ObjectInputStream ois)throws IOException,ClassNotFoundException{
        this.monde = (Monde)ois.readObject();
        this.jeu = (EtatDuJeu)ois.readObject();
    }

    /**
     * L'autre constructeur de simulateur prend en entrée un reader (c'est à dire un ojet de lecture de fichier)
     * Les fichier de sauvegarde sont de telle sorte que celui ci va lire en premier la classe de l'objet à créer.
     * Cette méthoide est donc un caseof permettant d'appliquer différents lecteurs et créateurs d'objets selon la classe lue.
     *
     * @param reader
     *          Le lecteur de fichier qui sert à créer les objets.
     *
     * @throws IOException
     *          Renvoie toute erreur relative à un flux d'entrée d'objets. (IOS)
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *          Renvoie toute erreur relative à la création d'un objet dont le nom est déjà utilisé dans le monde où il est créé.
     */
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

    /**
     * Cette méthode sert à enregistrer le monde actuel et l'état du jeu dans un flux de sortie d'objets.
     *
     * @param oos
     *          Le flux de sortie d'objets que l'on cherche à enregistrer.
     *
     * @throws IOException
     *          Renvoie toute erreur relative à un flux d'entrée d'objets. (IOS)
     */
    public void enregistrer(ObjectOutputStream oos)throws IOException{
        oos.writeObject(this.monde);
        oos.writeObject(this.jeu);
    }

    /**
     * Cette méthode sert à lire et créer le monde du fichier de sauvegarde.Pour cela il lit le nom, enlève les guillemets et créée un nouveau monde.
     *
     * @param scan
     *          Le scanner à partir duquel on lit le monde.
     */
    private void lireMonde(Scanner scan){
        String nomMonde = scan.next();
        nomMonde = nomMonde.substring(1,nomMonde.length()-1);
        this.monde = new Monde(nomMonde);
    }

    /**
     * Cette méthode sert à lire et créer une pièce du fichier de sauvegarde.Pour cela il lit le nom, enlève les guillemets et créée une nouvelle pièce dans le monde du scanner.
     *
     * @param scan
     *          Le scanner à partir duquel on lit la pièce.
     */
    private void lirePiece(Scanner scan)throws NomDEntiteDejaUtiliseDansLeMondeException{
        String nomPiece = scan.next();
        nomPiece = nomPiece.substring(1,nomPiece.length()-1);
        new Piece(nomPiece,this.monde);
    }

    /**
     * Cette méthode sert à lire et créer une porte avec une serrure du fichier de sauvegarde.Pour cela il lit le nom de la porte, enlève les guillemets
     * Puis lis le nom de la première pièce reliée à la porte, enlève les guillements
     * Puis lis le nom de la seconde pièce reliée à la porte, enlève les guillements
     * Et enfin créée une nouvelle porte avec serrure dans le monde du scanner.
     *
     * @param scan
     *          Le scanner à partir duquel on lit la porte avec serrure.
     *
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *          Renvoie toute erreur relative à la création d'entité dont le nom existe déjà dans le monde où elle est créée.
     */
    private void lirePorteSerrure(Scanner scan)throws NomDEntiteDejaUtiliseDansLeMondeException{
        String nomPorteSerrure = scan.next();
        nomPorteSerrure = nomPorteSerrure.substring(1,nomPorteSerrure.length()-1);
        String nomPremierePiece = scan.next();
        nomPremierePiece = nomPremierePiece.substring(1,nomPremierePiece.length()-1);
        String nomSecondePiece = scan.next();
        nomSecondePiece = nomSecondePiece.substring(1,nomSecondePiece.length()-1);
        new Porte(nomPorteSerrure,this.monde,new Serrure(this.monde),new Piece(nomPremierePiece,this.monde),new Piece(nomSecondePiece,this.monde));
    }

    /**
     * Cette méthode sert à lire et créer une porte du fichier de sauvegarde.Pour cela il lit le nom de la porte, enlève les guillemets
     * Puis lis le nom de la première pièce reliée à la porte, enlève les guillements
     * Puis lis le nom de la seconde pièce reliée à la porte, enlève les guillements
     * Et enfin créée une nouvelle porte dans le monde du scanner.
     *
     * @param scan
     *          Le scanner à partir duquel on lit la porte.
     *
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *          Renvoie toute erreur relative à la création d'entité dont le nom existe déjà dans le monde où elle est créée.
     */
    private void lirePorte(Scanner scan)throws NomDEntiteDejaUtiliseDansLeMondeException{
        String nomPorte = scan.next();
        nomPorte = nomPorte.substring(1,nomPorte.length()-1);
        String nomPremierePiece = scan.next();
        nomPremierePiece = nomPremierePiece.substring(1,nomPremierePiece.length()-1);
        String nomSecondePiece = scan.next();
        nomSecondePiece = nomSecondePiece.substring(1,nomSecondePiece.length()-1);
        new Porte(nomPorte,this.monde,new Piece(nomPremierePiece,this.monde),new Piece(nomSecondePiece,this.monde));
    }

    /**
     * Cette méthode sert à lire et créer une clé du fichier de sauvegarde.Pour cela il lit le nom de la porte liée à cette clé, enlève les guillemets
     * Puis lis le nom de la pièce dans laquelle on veut déposer cette clé,
     * Et enfin créée une nouvelle clé qu'elle dépose dans la pièce voulue.
     *
     * @param scan
     *          Le scanner à partir duquel on lit la clé.
     *
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *          Renvoie toute erreur relative à la création d'entité dont le nom existe déjà dans le monde où elle est créée.
     */
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

    /**
     * Cette méthode sert à lire et créer un joueur humain du fichier de sauvegarde.Pour cela il lit le nom du joueur, enlève les guillemets
     * Puis lis les pv de celui ci,
     * Puis lis les pf de celui ci,
     * Puis lis le nom de la pièce dans laquelle le joueur est, enlève les guillements,
     * Enfin il créée le joueur avec les caractéristiques données.
     *
     * @param scan
     *          Le scanner à partir duquel on lit le joueur.
     *
     * @throws NomDEntiteDejaUtiliseDansLeMondeException
     *          Renvoie toute erreur relative à la création d'entité dont le nom existe déjà dans le monde où elle est créée.
     */
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
